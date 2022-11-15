package uta.cse3310;

import java.util.ArrayList;

public class Deck extends Card
{
    int hearts = 13;
    int spades = 13;
    int clovers = 13;
    int diamonds = 13;
    ArrayList<Card> deck;
    int totalcards;

    //check to make sure there are enough cards to play
    //arbitrarily chose 12 cards per player, if fewer, add cards
    //Pedro
    
    public void checkDeck(int numPlayers, int totalCardsLeft){
        int minCards = 12*numPlayers;

        if(totalCardsLeft < minCards){
            //add one deck here - 
            //Pedro
        }

    }

    public void shuffle(ArrayList<Card> deck)
    {

    }

    public void nextCardDisplay(ArrayList<Card> deck)
    {

    }

    public Card getRandom()
    {
        //placeholder until functionality is added
        Card card = null;
        return card;
    }
}
