package uta.cse3310;

public class Player extends Hand
{
    Hand hand;
    String ID;
    double balance = 200;
    boolean in;

    public Hand getHand() 
    {
        return hand;
    }
}