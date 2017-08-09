package week3_methods;

import java.util.Scanner;

public class GuessingGame {

    //Create two scanners
    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    //This is the main method - the first code to run
    public static void main(String[] args) {

        String computerFavoriteFood = "chips";       // sorry
        System.out.println("Guess what a computer's favorite food is?");
        String guess = stringScanner.nextLine();

        if (checkUserGuess(guess, computerFavoriteFood)) {
            System.out.println("Correct!");
        } else {
            System.out.println("Sorry, the right answer is " + computerFavoriteFood);
        }

        //Close scanners.
        stringScanner.close();
        numberScanner.close();

    }    // This is the end of the main method.


    // Verify if user's guess is correct or not, and return a boolean
    // We should accept "chips?" as well as "chips", and we would like to ignore case.
    private static boolean checkUserGuess(String guess, String correctAnswer) {

        if (guess.equalsIgnoreCase(correctAnswer)) {
            return true;
        } else if (guess.equalsIgnoreCase(correctAnswer + "?")) {
            return true;
        } else {
            return false;
        }

    }  // end of checkUserGuess method

} // End of the class

