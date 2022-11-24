package uta.cse3310;

public class Dealer {
    Hand dealerHand;
    Integer ID;
    String behavior;
    String Name;
    int points;
    double netMoney = 0;
    String LastMessageToPlayer;
    //******************************** 
    //getters
    //******************************** 
    public Hand getHand() {
        return dealerHand;
    }
    public double getnetMoney(){
        return netMoney;
    }

    //******************************** 
    //setters
    //******************************** 
    public void updateNetMoney(double d, String s){
        if(s == "lost"){netMoney -= d;}
        if(s == "gained"){netMoney += d;}
    }

    //******************************** 
    //other
    //******************************** 
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

    public Dealer(int id) {
        this.ID = id;
        this.Name = "Dealer";
        dealerHand = new Hand();
    }
}
