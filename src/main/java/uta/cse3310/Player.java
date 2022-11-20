package uta.cse3310;



    
     
      import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Player //extends Hand
{
    Hand hand;
    String ID;
    double netMoney = 200;
    double betMoney;
    boolean in;

    public Hand getHand() 
    {
        return hand;
    }

    public double getnetMoney(){
        
        return netMoney;
    }
    public double getBetMoney(){
        
        return betMoney;
    }

    int Id;
    String Name;
    uta.cse3310.Card Cards[];
    String LastMessageToPlayer;
    

    public Player(int id) {
        Id = id;
        Name = "not set";
        // there is a lot smarter ways to do this,
        // but at least this is obvious
        Cards = new Card[2];
        for (int i = 0; i < 2; i++) {
            //Cards[i] = Card.get;
            //Cards[i].suite = Card.getSuite();
            //Cards[i].value = Card.getRank();
        }
}}
     
     
    
