package week2_loops_arrays;

import java.util.Scanner;

public class WhileLoopPassword {

    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    public static void main(String[] args) {

        String secretPassword = "kittens";

        System.out.println("Enter the password");
        String userPassword = stringScanner.nextLine();

        //Always use the .equals method to check if two Strings have the exact same characters

        //Before we let the user in, we need to check that the password is correct
        //This loop will repeat while the password is NOT "kittens", our secretPassword
        while ( ! userPassword.equals(secretPassword) ) {
            // The user got the password wrong. Print an error message
            System.out.println("Password incorrect, access denied!");
            // And ask user to try again.
            System.out.println("Try again");
            // Replace userPassword with the user's next attempt.
            userPassword = stringScanner.nextLine();
            // If the user gets it wrong again, the loop will repeat.
        }

        // if the loop condition is false, then the user got the password right.
        // Print 'access granted' method

        System.out.println("Correct password - access granted");

        // TODO - top secret program here!

        stringScanner.close();
        numberScanner.close();
    }
}
