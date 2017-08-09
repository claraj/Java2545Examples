package week2_loops_arrays;

import java.util.Scanner;

public class WhileLoopPassword5Attempts {

    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    public static void main(String[] args) {

        String secretPassword = "kittens";
        int passwordAttemptsAllowed = 4;   // Question - why is this 4, not 5? Hint: think about the loop condition

        System.out.println("Enter the password");
        String userPassword = stringScanner.nextLine();

        //Always use the .equals method to check if two Strings have the exact same characters

        //Before we let the user in, we need to check that the password is correct
        //This loop will repeat while the password is NOT "kittens", our secretPassword
        //AND as long as passwordAttemptsAllowed is greater than 0

        while ( ! userPassword.equals(secretPassword) && passwordAttemptsAllowed > 0 ) {

            // The user got the password wrong. Print an error message
            System.out.println("Password incorrect, access denied!");

            // And ask user to try again.
            System.out.println("Try again - you have " + passwordAttemptsAllowed + " attempt(s) left");
            // Replace userPassword with the user's next attempt.
            userPassword = stringScanner.nextLine();
            // If the user gets it wrong again, the loop will repeat.

            // Subtract 1 from passwordAttemptsAllowed
            passwordAttemptsAllowed = passwordAttemptsAllowed - 1;

        }

        // if the loop condition is false, then the user got the password right OR they ran out of password attempts

        // Check to see if they did get the password right

        if ( userPassword.equals(secretPassword)) {
            System.out.println("Correct password - access granted! ");

            // TODO - start top secret program here!

        }

        else {
            //The user ran out of password attempts.

            System.out.println("Sorry, you got the password wrong too many times. Bye!");
        }


        stringScanner.close();
        numberScanner.close();
    }
}
