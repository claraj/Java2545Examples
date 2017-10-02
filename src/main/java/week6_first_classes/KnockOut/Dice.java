package week6_first_classes.KnockOut;

import java.util.Random;

/**
 * Created by clara on 10/2/17.
 */
public class Dice {
    
    Random rnd = new Random();
    
    int roll() {
        return rnd.nextInt(6) + 1;
    }
}
