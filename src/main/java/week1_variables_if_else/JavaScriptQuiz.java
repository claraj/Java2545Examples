package week1_variables_if_else;

import static input.InputUtils.stringInput;

public class JavaScriptQuiz {

   
    public static void main(String[] args) {

        System.out.println("Quiz time! Finish the quote.");
        System.out.println("Java is to JavaScript as Car is to... ?");
        
        // "Java is to JavaScript as car is to carpet." -- Chris Heilmann, https://christianheilmann.com/

        String answer = stringInput();

        // The .equals() method is case sensitive. If you don't need
        // to be case sensitive, you can use the equalsIgnoresCase method.
        // So here, carpet and CARPET and cArPet are all correct answers.
        if ( answer.equalsIgnoreCase("carpet") ) {
            System.out.println("Correct!!!");
        } else {
            System.out.println("Sorry, the answer is 'Carpet'. ");
        }
    }
}


