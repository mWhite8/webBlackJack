package uta.cse3310;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
 
public class Deck
{
    int hearts = 13;
    int spades = 13;
    int clovers = 13;
    int diamonds = 13;
    ArrayList<Card> deck;
    int totalcards;

    //Reety
    //Initializing deck
    public Deck()
    {
        deck = new ArrayList<Card>();

        for (Card.Suit s : Card.Suit.values())
        {
            for (Card.Rank r : Card.Rank.values())
            {
                deck.add(new Card(r, s));
            }
        }

        totalcards = deck.size();
    }
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

    //Reety
    //Shuffle using random number generator
    public void shuffle()
    {
        Collections.shuffle(deck, new Random());
    }

    public void nextCardDisplay(ArrayList<Card> deck)
    {

    }

    //Reety
    public Card getRandom()
    {
        Random rand = new Random();
        int randInt = rand.nextInt(totalcards);
        Card randCard = deck.remove(randInt);
        totalcards--;
        return randCard;
    }

    
}
