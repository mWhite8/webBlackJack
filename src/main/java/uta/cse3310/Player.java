package uta.cse3310;



    
     
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Player //extends Hand
{
    uta.cse3310.Hand Cards[];
    Integer ID;
    String Name;
    double netMoney = 200;
    double betMoney;
    boolean in;

  

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


}
     
     
    
