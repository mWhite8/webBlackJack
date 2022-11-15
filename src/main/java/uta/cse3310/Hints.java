package uta.cse3310;

import java.util.ArrayList;

public class Hints {
    ArrayList<String> hints;

    // take parameters cardpoints, and nextcard from deck
    // will suggest to take a card if poits less than or equal 21, will say not to if it goes over 21
    //Pedro
    public String displayHint(double cardPoints, int nextCard) {
        String message;
        if ((cardPoints + nextCard) <= 21) {
            message = "It is safe to draw a card.";
        } else {
            message = "Quit while you're ahead.";
        }
        return message;
    }

    //String hint = null;return hint;
}
