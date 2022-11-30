package uta.cse3310;



    
     
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Player
{
    /* 
    uta.cse3310.Hand Cards[];
    Integer ID;
    String Name;
    double netMoney = 200;
    double betMoney;
    boolean in;

  tried using the code from webpoker and apply it here

    //int Id;
    //String Name;
    //uta.cse3310.Card Cards[];
    String LastMessageToPlayer;
    

    public Player(int id) {
        ID = id;
        Name = "not set";
        // there is a lot smarter ways to do this,
        // but at least this is obvious
        Cards = new Hand[2];
       // for (int i = 0; i < 2; i++) {
        //Cards[i].suite = ("DIAMOND");
        //    Cards[i].value = Hand.getValue();
        //}
    }

public Hand getHand() 
{
    return Cards[2];
}

public double getnetMoney(){
    
    return netMoney;
}
public double getBetMoney(){
    
    return betMoney;
}

*/


int Id;
String Name;
uta.cse3310.Card Cards[];
String LastMessageToPlayer;
double netMoney = 200;
boolean in;

public Player(int id) {
    this.Id = id;
    this.Name = "not set";
    // there is a lot smarter ways to do this,
    // but at least this is obvious
    this.Cards = new Card[2];
    for (int i = 0; i < 2; i++) {
        Cards[i] = new Card();
        Cards[i].suite = Card.Suite.valueOf("SPADES");
        Cards[i].value = Card.Value.valueOf("FIVE");
    }

}

public void SetName(String N) {
    this.Name = N;
    LastMessageToPlayer="Welcome " + N + " to the game.";
}
//malachi
public void addMoney(double d){
    this.netMoney += d;
}

public void lostMoney(double d){
    this.netMoney -= d;
}
public int getId(){
    return this.Id;
}

public String asJSONString() {
    Gson gson = new Gson();
    return gson.toJson(this);
}







}
     
     
    
