package uta.cse3310;


import java.util.ArrayList;

public class Hand 
{
    Deck deck;
    ArrayList<Card> cards;
    int totalVal;

    //Reety
    //Initialize hand
    //Pull two cards from deck
    public Hand(Deck d) 
    {
        deck = d;
        cards = new ArrayList<Card>();
        deck.shuffle();
        cards.add(deck.getRandom());
        cards.add(deck.getRandom());
    }

    //Reety
    //Calculating value of hand
    public int getVal()
    {
        totalVal = 0;
        int numOfAces = 0;
        int chosenVal = 0;

        for (Card c : cards)
        {
            if (c.getRank() == Card.Rank.ACE)
            {
                numOfAces++;
            }
            else
            {
                totalVal += c.getRank().getValue();
            }
        }
        //Ask player what value they want for ace, store in chosenVal
        totalVal += numOfAces * chosenVal;
        return totalVal;
    }

    public void updateDeck()
    {
        
    }
   
}
