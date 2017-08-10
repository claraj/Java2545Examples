package week1_variables_if_else;

import static input.InputUtils.intInput;

public class Apollo11Quiz {
    
    public static void main(String[] args) {

        System.out.println("Quiz time!");
        System.out.println("What year did the Apollo 11 spaceship land on the moon?");

        //Hint... it was 1969

        int answer = intInput();

        // The != operator tests if two values are NOT equal
        // This condition tests if answer is not equal to 1969.
        if ( answer != 1969 ) {
            System.out.println("Wrong answer - it was 1969");
        }
        
    }
}


