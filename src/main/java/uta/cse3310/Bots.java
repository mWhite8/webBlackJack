package uta.cse3310;

public class Bots extends Hand
{
    Hand hand;
    String behavior;
    int points;
    double balance = 200;
    boolean in;

    in = Risk.riskLevel(behavior, points);
    

    

    public Hand getHand()
    {
        return hand;
    }
}
