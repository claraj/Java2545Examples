package week3_methods;


import static input.InputUtils.doubleInput;

public class Squares2 {

    //This is the main method - the first code to run
    public static void main(String[] args) {

        double number = doubleInput("Please enter a number and I'll square it");
        double squaredNumber = square(number);
        System.out.println("The square of " + number + " is " + squaredNumber);


    }    // This is the end of the main method.


    // This method takes one argument, a number
    // It calculates the square of that number (by multiplying it by itself)
    // and then returns the square value.
    public static double square(double n) {

        double sq = n * n;   // The square of a number is that number multiplied by itself
        return sq;

    }    // The end of the squares method
}



