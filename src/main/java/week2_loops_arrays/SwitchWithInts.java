package week2_loops_arrays;

import java.util.Random;

public class SwitchWithInts {

    public static void main(String args[]) {

        System.out.println("Testing the random number generator");
        Random rng = new Random(); // rng = random number generator
        // This should pick an integer in the range 0 to 4 (so 0 to (5 minus 1)).

        int randomChoice = rng.nextInt(5);

        //Use a switch statement to check which number was generated
        switch (randomChoice) {
            case 0:
                System.out.println("RNG chose 0");
                break;
            case 1:
                System.out.println("RNG chose 1");
                break;
            case 2:
                System.out.println("RNG chose 2");
                break;
            case 3:
                System.out.println("RNG chose 3");
                break;
            case 4:
                System.out.println("RNG chose 4");
                break;
            default:
                //The default case happens if none of the other cases are true
                System.out.println("RNG chose something else:" + randomChoice);
                // For our random number generator, something went wrong if you see this message :)
        }
    }
}

