package week1_variables_if_else;

import java.util.Scanner;

import static input.InputUtils.stringInput;

public class JavascriptQuiz {

   
    public static void main(String[] args) {

        System.out.println("Quiz time! Finish the quote.");
        System.out.println("Java is to Javascript as Car is to... ?");

        String answer = stringInput();

        // The .equals method is case sensitive. If you don't need
        // to be case sensitive, you can use the equalsIgnoresCase method.
        // So JavaScript and JAVASCRIPT and javascript are all correct answers.
        if ( answer.equalsIgnoreCase("javascript") ) {
            System.out.println("Correct!!!");
        } else {
            System.out.println("Sorry, the answer is 'Javascript'. ");
        }


    }
}