package uta.cse3310;

public class Card {

    //Reety
    //Each rank has an int value you can get by using getValue()
    enum Suit {SPADES, HEARTS, DIAMONDS, CLUBS};
    enum Rank {
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);
        private int val;
        
        private Rank (int v)
        {
            val = v;
        }
        
        public int getValue()
        {
            return val;
        }

    }
    Rank rank;
    Suit suit;

    public Card(Rank r, Suit s)
    {
        rank = r;
        suit = s;
    }

    public Rank getRank() 
    {
        return rank;
    }

    public Suit getSuit() 
    {
        return suit;
    }
    
    
}
