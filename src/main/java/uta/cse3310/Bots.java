package uta.cse3310;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Bots {

    uta.cse3310.Card Cards[];
    //uta.cse3310.Hand Cards[];
    Integer ID;
    String behavior;
    String Name;
    int points;
    double netMoney = 200;
    double betMoney;
    //boolean in;
    

    //allin = Risk.riskLevel(behavior, points);
    

    
  

    int Id;
    //String Name;
    //uta.cse3310.Card Cards[];
    String LastMessageToPlayer;
    

    public Bots(int id) {
        this.ID = id;
        this.Name = "not set";
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
