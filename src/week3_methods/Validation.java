package week3_methods;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {

    //Create two scanners
    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);


    public static void main(String[] args) {


        // Test the validation methods

        double computerPrice = doubleInput("What is the price of a computer?");
        System.out.println("Thank you, you entered $" + computerPrice);

        System.out.println("Please enter the price of a cellphone");
        double cellPrice = doubleInput();
        System.out.println("Thank you, you entered $" + cellPrice);


        int numberOfStudents = intInput("How many students in a class?");
        System.out.println("Thank you, you entered " + numberOfStudents);

        System.out.println("Please enter the quantity of cellphones");
        int cellQuantity = intInput();
        System.out.println("Thank you, you entered " + cellQuantity);



        //Close scanners.
        stringScanner.close();
        numberScanner.close();

    }    // This is the end of the main method.


    // A variant of the method below - notice it calls doubleInput with null as the argument
    public static double doubleInput() {
        return doubleInput(null);
    }

    //Takes a question, asks user the question, checks to make sure user enters a double, and
    //then returns that double to the calling method.
    public static double doubleInput(String question) {

        while (true) {
            // If user has provided a question, then print it for the user
            if (question != null) {
                System.out.println(question);
            }

            //Try to read what the user typed, expect it to be a double.
            try {
                // If the input can be read as a double, that double value will be returned
                // This ends the loop, and this method, and control returns to the calling method.
                return numberScanner.nextDouble();

            } // if the input can't be read as a double, then an error will be raised.
            // That error can be 'caught' by this code, and we can print an error message.
            // Since we are inside a while loop, then the loop can repeat and ask the user for input again.
            catch (InputMismatchException ime) {
                System.out.println("Error - please enter a number");
                numberScanner.next();
                /* If the value fetched from numberScanner.nextDouble can't be interpreted as a double,
                then that value is 'left' in the scanner, in case you wanted to try and read it with a numberScanner.nextLine()
                or other scanner method.
                So as your loop repeats, it keeps trying to read the same invalid data from the scanner.
                To fix, in the event of an exception, clear the invalid input with numberScanner.next()
                */
            }
        }

    }

    // A variant of the method below - notice it calls intInput with null as the argument
    public static int intInput() {
        return intInput(null);
    }

    //Takes a question, asks user the question, checks to make sure user enters an int, and
    //then returns that int to the calling method.
    public static int intInput(String question) {

        while (true) {
            // If user has provided a question, then print it for the user
            if (question != null) {
                System.out.println(question);
            }

            //Try to read what the user typed as an int.
            try {
                // If the input can be read as a int, that int will be returned
                // This ends the loop, and this method, and control returns to the calling method.
                return numberScanner.nextInt();

            } // if the input can't be read as an int, then an error will be raised.
            // For example, if the user enters 'ten' or 1.4 or 123456543454343434, these are not ints, so will cause an error.
            // That error can be 'caught' by this code, and we can print an error message.
            // Since we are inside a while loop, then the loop can repeat and ask the user for input again.
            catch (InputMismatchException ime) {
                System.out.println("Error - please enter an integer number");
                numberScanner.next();
                /* If the value fetched from numberScanner.nextInt can't be interpreted as a int,
                then that value is 'left' in the scanner, in case you wanted to try and read it with a
                numberScanner.nextLine() or numberScanner.nextDouble() or other scanner method.
                So as your loop repeats, it keeps trying to read the same invalid data from the scanner.
                To fix, in the event of an exception, clear the invalid input with numberScanner.next()
                */
            }
        }

    }
}



