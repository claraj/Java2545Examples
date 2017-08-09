package week3_methods;

import java.util.Scanner;

public class Squares {

    //Create two scanners
    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    //This is the main method - the first code to run
    public static void main(String[] args) {

        System.out.println("Please enter a number and I'll square it");
        double number = numberScanner.nextDouble();
        square(number);

        //Close scanners.
        stringScanner.close();
        numberScanner.close();

    }    // This is the end of the main method.


    // This method takes one argument, a number
    // It calculates the square of that number (by multiplying it by itself)
    // and prints the number and its square value
    public static void square(double n) {

        double sq = n * n;   // The square of a number is that number multiplied by itself
        System.out.println("The square of " + n + " is " + sq);

    }    // The end of the squares method

} // End of the Squares class



