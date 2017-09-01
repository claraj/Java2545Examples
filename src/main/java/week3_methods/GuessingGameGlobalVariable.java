package week3_methods;


import static input.InputUtils.stringInput;

public class GuessingGameGlobalVariable {

    static String correctAnswer = "chips";

    //This is the main method - the first code to run
    public static void main(String[] args) {

        String computerFavoriteFood = "chips";       // sorry
        String guess = stringInput("Guess what a computer's favorite food is?");

        if (checkUserGuess(guess)) {
            System.out.println("Correct!");
        } else {
            System.out.println("Sorry, the right answer is " + computerFavoriteFood);
        }


    }    // This is the end of the main method.


    // Verify if user's guess is correct or not, and return a boolean
    // We should accept "chips?" as well as "chips", and we would like to ignore case.
    private static boolean checkUserGuess(String guess) {

        if (guess.equalsIgnoreCase(correctAnswer)) {
            return true;
        } else if (guess.equalsIgnoreCase(correctAnswer + "?")) {
            return true;
        } else {
            return false;
        }

    }  // end of checkUserGuess method

} // End of the class


