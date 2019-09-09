package week7_first_classes.KnockOut;

import java.util.Random;

/**
 * Represents a single dice (or 'die') in a program.
 *
 * Class names are generally singular, for example, Player, Card, Deck
 *
 * 'Dice' is a valid singular form, as well as 'Die'
 * https://english.stackexchange.com/questions/167104/singular-of-dice
 */

public class Dice {
    
    private Random rnd = new Random();
    
    int roll() {
        return rnd.nextInt(6) + 1;
    }
}


