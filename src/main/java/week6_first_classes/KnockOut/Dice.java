package week6_first_classes.KnockOut;

import java.util.Random;

/**
 * Represents a single dice (or 'die') in a program.
 *
 * Class names are generally the singular form, Player, Card, Deck
 * Unless one object made from this class represents multiple things and the name needs to reflect that
 * DeckOfCards is a ok name (but Deck is arguably better)
 *
 * 'Dice' is also a valid singular form, as well as 'Die'
 * https://english.stackexchange.com/questions/167104/singular-of-dice
 */

public class Dice {
    
    private Random rnd = new Random();
    
    int roll() {
        return rnd.nextInt(6) + 1;
    }
}


