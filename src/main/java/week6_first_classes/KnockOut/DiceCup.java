package week6_first_classes.KnockOut;

import java.util.ArrayList;

/** Represents a cup of dice to roll in a game. Configure the number of
 * Can roll all of the dice, and total the results of a roll.*/

public class DiceCup {
    
    private ArrayList<Dice> allDice;  // All the Dice objects
    
    DiceCup(int numberOfDice) {
    
        allDice = new ArrayList<>();
        for (int d = 0 ; d < numberOfDice ; d++) {
            Dice dice = new Dice();
            allDice.add(dice);
        }
    }
    
    int[] rollAll() {
        
        int[] rolls = new int[allDice.size()];
        int diceNumber = 0;
        for (Dice d : allDice) {
            rolls[diceNumber] = d.roll();
            diceNumber++;
        }
        return rolls;
        
    }

    
    int rollTotal(int[] rolls) {
        int total = 0;
        for (int roll : rolls) {
            total += roll;
        }
        return total;
    }
    
}


