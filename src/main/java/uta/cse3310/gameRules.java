package uta.cse3310;

public class gameRules {
    //enum rules {
    //};


//bet rules - bets must be no less than $2 and no more than $500
//pass in balance of player/bot and their desired bet
//Pedro
    public int moneyBet(int netMoney, int betMoney) {
        if (betMoney >= 2 && betMoney <= 500) {
            netMoney = netMoney - betMoney;
        }
        else{System.out.println("Bet amount not valid\n");}

        return netMoney;
    }

    //boolean - will return true if two cards are of the same denomination
    // if true, the button to split should become available
    //Pedro
    public boolean splitCard(String cardA, String cardB){
        boolean splitOrNot;
        if (cardA == cardB){
            splitOrNot = true;
        }
        else {splitOrNot = false;}
        return splitOrNot;
    }

    //if double down, player's bet is doubled and they can only draw one card
    //Pedro
    public double doubleDown(int betMoney, int netMoney){
        if(netMoney >= 2*betMoney){
            netMoney = netMoney - (2*betMoney);
        }
        //logic to only allow to draw one card, face down after everyone draws
        return netMoney;
    }

    //pass in 3 parameters: their total money, the money they originally bet, and the insurance...
    //...bet, which cannot be more than half of original bet
    //Pedro
    public double insuranceBet(double netMoney, double betMoney, double insBet){
        //check if dealer has Ace as their first card before passing parameters
        double insurance = betMoney + (betMoney/2);
        if (insBet > insurance){
            System.out.println("invalid bet.");
        }
        else if(insBet <= insurance){
            betMoney = betMoney - insurance;
        }
        return betMoney;
        //subtract betMoney from netMoney after this function has been called

    }

    //checks to see if first 2 cards equal 21 and pays 1.5 original bet
    //returns the updated netmoney after bet has been updated and paid
    //may beed additional functionality to check if dealer also has 21
    //PEdro
    public double twentyOne(double netPoints, double netBet, double netMoney){
        double betpay;
        if (netPoints == 21){
            betpay = netBet*1.5;
            netMoney = netMoney + betpay;
            
        }
        return netMoney;
    }
    
}

