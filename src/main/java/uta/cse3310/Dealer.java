package uta.cse3310;

public class Dealer {

    Hand dealerHand;
    double netMoney;

    public double tenProbability()
    {
        double prob = 0;
        // Reety
        int card_count = dealerHand.cards.size();
        int num_of_tens = 0;
        
        for (Card c : dealerHand.cards)
        {
            if (c.getRank() == Card.Rank.TEN)
            {
                num_of_tens++;
            }
        }

        prob = (double) num_of_tens/card_count;
        return prob;
    }
}
