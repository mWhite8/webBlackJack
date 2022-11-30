
package uta.cse3310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Collections;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple WebSocketServer implementation. Keeps track of a "chatroom".
 */
public class BlackJack extends WebSocketServer {

  private int numPlayers;
  private Game game;
  // to protect the game object from concurrent access
  private Object mutex = new Object();

  private void setNumPlayers(int N) {
    numPlayers = N;
  }

  public BlackJack(int port) throws UnknownHostException {
    super(new InetSocketAddress(port));
  }

  public BlackJack(InetSocketAddress address) {
    super(address);
  }

  public BlackJack(int port, Draft_6455 draft) {
    super(new InetSocketAddress(port), Collections.<Draft>singletonList(draft));
  }

  @Override
  public void onOpen(WebSocket conn, ClientHandshake handshake) {

    System.out.println(
        conn.getRemoteSocketAddress().getAddress().getHostAddress() + " connected");

    // Since this is a new connection, it is also a new player
    numPlayers = numPlayers + 1; // player id's start at 0
    Player player = new Player(numPlayers);
    if (numPlayers == 0) {
      System.out.println("starting a new game");
      game = new Game();
    }
    // This puts the player number into the conn data structure so
    // it is available later on
    conn.setAttachment(numPlayers);

    // this is the only time we send info to a single client.
    // it needs to know it's player ID.
    conn.send(player.asJSONString());
    synchronized (mutex) {
      game.addPlayer(player);
    }

    // and as always, we send the game state to everyone
    synchronized (mutex) {
      broadcast(game.exportStateAsJSON());
      System.out.println("the game state" + game.exportStateAsJSON());
    }
  }

  @Override
  public void onClose(WebSocket conn, int code, String reason, boolean remote) {
    System.out.println(conn + " has closed");

    // the player number of this connection was saved earlier when the
    // websocket connection was opened.
    int idx = conn.getAttachment();

    
    synchronized (mutex) {
      game.removePlayer(idx);

      System.out.println("removed player index " + idx);

      // The state is now changed, so every client needs to be informed
      broadcast(game.exportStateAsJSON());
      System.out.println("the game state" + game.exportStateAsJSON());
    }
  }

  @Override
  public void onMessage(WebSocket conn, String message) {

    synchronized (mutex) {
      // all incoming messages are processed by the game
      game.processMessage(message);
      // and the results of that message are sent to everyone
      // as the "state of the game"

      broadcast(game.exportStateAsJSON());
    }
    System.out.println(conn + ": " + message);
  }

  @Override
  public void onMessage(WebSocket conn, ByteBuffer message) {
    synchronized (mutex) {
      broadcast(message.array());
    }
    System.out.println(conn + ": " + message);
  }

  public class upDate extends TimerTask {

    @Override
    public void run() {
      if (game != null) {
        synchronized (mutex) {
        }
        if (game.update()) {

          broadcast(game.exportStateAsJSON());
        }
      }
    }
  }

  public static void main(String[] args) throws InterruptedException, IOException {

    // Create and start the http server

    HttpServer H = new HttpServer(9083, "./html");
    H.start();

    // create and start the websocket server

    int port = 9883;

    BlackJack s = new BlackJack(port);
    s.start();
    System.out.println("WebPokerServer started on port: " + s.getPort());

    // Below code reads from stdin, making for a pleasant way to exit
    BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String in = sysin.readLine();
      s.broadcast(in);
      if (in.equals("exit")) {
        s.stop(1000);
        break;
      }
    }
  }


  
  @Override
  public void onError(WebSocket conn, Exception ex) {
    ex.printStackTrace();
    if (conn != null) {
      // some errors like port binding failed may not be assignable to a specific
      // websocket
    }
  }

  @Override
  public void onStart() {
    System.out.println("Server started!");
    setConnectionLostTimeout(0);
    setConnectionLostTimeout(100);
    setNumPlayers(-1);
    // once a second call update
    // may want to start this in the main() function??
    //new java.util.Timer().scheduleAtFixedRate(new upDate(), 0, 1000);
  }

}