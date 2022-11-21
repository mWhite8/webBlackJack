package uta.cse3310;

public class Bots {

    uta.cse3310.Hand Cards[];
    Integer ID;
    String behavior;
    String Name;
    int points;
    double netMoney = 200;
    double betMoney;
    boolean in;
    

    allin = Risk.riskLevel(behavior, points);
    

    
  

    //int Id;
    //String Name;
    //uta.cse3310.Card Cards[];
    String LastMessageToPlayer;
    

    public Bots(int id) {
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
