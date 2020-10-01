package week6_files_exceptions;

import static input.InputUtils.intInput;

/**
 * Validation with a while loop
 */
public class UserEntersData_Do {

    public static void main(String[] args) {

        // Example: you want the user to enter a number between 1 and 10
        // do-while version

        int userInput;
        do {
            userInput = intInput("Please enter a number between 1 and 10");
        } while (userInput < 1 || userInput > 10);

        System.out.println("Thanks, the number you entered is " + userInput);
    }
}


