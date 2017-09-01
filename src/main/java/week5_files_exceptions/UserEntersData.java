package week5_files_exceptions;

import static input.InputUtils.intInput;

/**
 * Validation with a while loop
 */
public class UserEntersData {
    
    public static void main(String[] args) {
        
        // Example: you want the user to enter a number between 1 and 10
        
        int userInput = 0;
        while (userInput < 1 || userInput > 10) {
            userInput = intInput("Please enter a number between 1 and 10");
        }
    
        System.out.println("Thanks, the number you entered is " + userInput);
    }
}


