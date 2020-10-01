package week6_files_exceptions;

import static input.InputUtils.intInput;

/**
 * Validation with a while loop
 */
public class UserEntersData_While {

    public static void main(String[] args) {

        // Example: you want the user to enter a number between 1 and 10
        // while version

        int userInput = intInput("Please enter a number between 1 and 10");

        // repeat while the input is invalid, outside the range 1-10
        while (userInput < 1 || userInput > 10) {
            userInput = intInput("Please enter a number between 1 and 10");
        }

        System.out.println("Thanks, the number you entered is " + userInput);
    }
}


