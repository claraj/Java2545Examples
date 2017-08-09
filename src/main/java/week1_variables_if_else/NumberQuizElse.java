package week1_variables_if_else;

import java.util.Scanner;

public class NumberQuizElse {

    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    public static void main(String[] args) {

        int secretNumber = 6;

        System.out.println("Guess the number I am thinking of");
        int guess = numberScanner.nextInt();

        //If the guess is equal to secret number, the user guessed correctly
        if (guess == secretNumber) {
            System.out.println("You guessed correctly!");
        } else {
            //else, they did not guess correctly. Tell them the right answer
            System.out.println("Sorry, I was thinking of " + secretNumber);
        }

        stringScanner.close();
        numberScanner.close();
    }
}