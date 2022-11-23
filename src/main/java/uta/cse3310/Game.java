package uta.cse3310;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import uta.cse3310.UserEvent.UserEventType;

public class Game {





private ArrayList<Player> players = new ArrayList<>();
    private int turn; // player ID that has the current turn
    private transient int seconds;
    public ArrayList<Player> queue = new ArrayList<>(); 
    int GameIdx;
    Double pot;
    Player currentplayer;
    String gameMessage;

    public String exportStateAsJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public void removePlayer(int playerid) {
        // given it's player number, this method
        // deletes the player from the players array
        // and does whatever else is needed to remove
        // the player from the game.
        players.remove(playerid - 1);
    }

    public void processMessage(String msg) {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        // take the string we just received, and turn it into a user event
        UserEvent event = gson.fromJson(msg, UserEvent.class);

        if (event.event == UserEventType.NAME) {
            players.get(event.playerID).SetName(event.name);
        }

    }

    public boolean update() {

        // this function is called on a periodic basis (once a second) by a timer
        // it is to allow time based situations to be handled in the game
        // if the game state is changed, it returns a true.
        seconds = seconds + 1;
        if ((seconds % 10) == 0) {
            turn = turn + 1;
            if (turn == 5) {
                turn = 0;
            }
            return true;
        }
        return false;

        // return false;
        // expecting that returning a true will trigger a send of the game
        // state to everyone

    }
    //malachi
    public void new_player(int Id, UserEvent event){
        Player tempPlayer = new Player(Id);
        tempPlayer.SetName(event.name);
    }
    public Game() {
        System.out.println("creating a Game Object");
        Deck d = new Deck();
        d.shuffle();
        pot = 0.0;
        GameIdx = 0;
    }

    //Game logic!!!!!!!!!!
    
    public void startOfGame(UserEvent event){
        if(event.event == UserEventType.NAME && event.playerID >=3){
            for(int i = 0;i<queue.size();i++){
                if(queue.get(i).getId() == event.playerID){
                    queue.get(i).SetName(event.name);
                }
            }
        }
        else if(event.event == UserEventType.NAME){
            new_player(event.playerID, event);
        }
        if(players.size() >= 1){
            currentplayer = players.get(0);
            GameIdx++;
        }
        GetGameMessage();
    }

    public void GetGameMessage(){
        if(GameIdx == 0){
            gameMessage = "Waiting for players...";
        }
    }






}

