package week7_first_classes.KnockOut;

import java.util.ArrayList;

/** Represents a cup of dice to roll in a game. Configure the number of
 * Can roll all of the dice, and total the results of a roll.
 */

public class DiceCup {

    private ArrayList<Dice> allDice;  // All the Dice objects

    DiceCup(int numberOfDice) {

        allDice = new ArrayList<>();

        for (int d = 0; d < numberOfDice; d++) {
            Dice dice = new Dice();
            allDice.add(dice);
        }
    }


    // Rolls all the dice, adds the values and returns the total of all dice
    public int rollAll() {
        int total = 0;
        for (Dice d : allDice) {
            int diceRoll = d.roll();
            total += diceRoll;
        }
        return total;
    }
}


