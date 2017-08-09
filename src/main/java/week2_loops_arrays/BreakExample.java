package week2_loops_arrays;

import java.util.Random;
import java.util.Scanner;

public class BreakExample {

    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    public static void main(String[] args) {

        Random randomNumberGenerator = new Random();

        while (true) {

            System.out.println("Would you like a random number?");
            System.out.println("Enter any key for a random number, or Q to quit");

            String userInput = stringScanner.nextLine();

            if (userInput.equalsIgnoreCase("Q")) {

                break;   //immediately stops the loop, jump to next statement after the loop
            }

            // If we get to this line, the loop didn't break
            // Generate and display a random number

            int randomNumber = randomNumberGenerator.nextInt();
            // .nextInt() with no argument generate a random number from all the possible integer values

            System.out.println("Your random number is " + randomNumber);

        }

        System.out.println("Thanks for using the program - bye!");

        stringScanner.close();
        numberScanner.close();

    }

}
