
// Pedro Santana - adding random class to handle all of the risk levels for players and bots in one place




package uta.cse3310;
//import java.util.Random;

public class Risk {

    boolean riskChoice = false;
    //Random r = new Random(); //may not need random 
     
    //int risk = r.nextInt();

    public boolean riskLevel(String name, int total){
       // int risk = r.nextInt();
       //boolean riskChoice = false;

        switch(name){
            case "Minimal":
            if(total <= 16){
                riskChoice = true;
            }
            else riskChoice = false;
            case "Normal":
            if(total <= 17){
                riskChoice = true;
            }
            else riskChoice = false;

            case "High":
            if (total <= 18){
                riskChoice = true;
            }
            else riskChoice = false;

            case "Counter":
            //not sure on logic here
            default:
            return false;
        }

        //return riskChoice;
        
    }
    
}




//Pedro Santana