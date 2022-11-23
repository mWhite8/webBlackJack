package uta.cse3310;

public class Dealer {


    Hand dealerHand;
    Integer ID;
    String behavior;
    String Name;
    int points;
    double netMoney = 200;
    double betMoney;

        //int Id;
    //String Name;
    //uta.cse3310.Card Cards[];
    String LastMessageToPlayer;
    

    public Dealer(int id) {
        this.ID = id;
        this.Name = "Dealer";
        // there is a lot smarter ways to do this,
        // but at least this is obvious
        dealerHand = new Hand();
       // for (int i = 0; i < 2; i++) {
        //Cards[i].suite = ("DIAMOND");
        //    Cards[i].value = Hand.getValue();
        //}
    }

public Hand getHand() 
{
    return dealerHand;
}

public double getnetMoney(){
    
    return netMoney;
}
public double getBetMoney(){
    
    return betMoney;
}


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
    */
}
