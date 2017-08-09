package week2_loops_arrays;

import java.util.Random;

public class RandomInteger {

    public static void main(String[] args) {

        //Create a Random object - this is a random number generator object
        Random random = new Random();

        int randomNumber = random.nextInt(10);  // Generate a random number between 0 and 9

        System.out.println("Random secret number between 0 and 9 = " + randomNumber);

        int anotherRandomNumber = random.nextInt(1000); // Generate a random number between 0 and 999

        System.out.println("Another random  number between 0 and 999 = " + anotherRandomNumber);

        // What if you want a random number between 1 and 10 (instead of 0 to 9 ?)
        // Generate a random number between 0 and 9, and then add 1 to it. So 0 becomes 1, 1 becomes 2, ... 9 becomes 10.
        int andAnotherRandomNumber = random.nextInt(10) + 1;
        System.out.println("Another random number between 1 and 10 = " + andAnotherRandomNumber);

        // How about a random number between 5 and 12?
        // The range is 12 - 5 = 7, or 7 different possibilities of random number.
        // So, generate a random number between 0 and 7, and add 5 to it.
        int yetAnotherRandomNumber = random.nextInt(7) + 5;
        System.out.println("Another random number between 5 and 12 = " + yetAnotherRandomNumber);


    }

}
