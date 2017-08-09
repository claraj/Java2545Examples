package week2_loops_arrays;


import java.util.Scanner;

public class SalesTaxWhileLoop {

    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    public static void main(String[] args) {

        String moreCalculations = "y";
        double price;
        double salesTax = 1.07;

        //This loop repeats as long as the user wants to do more calculations

        while (moreCalculations.equals("y")) {
            System.out.println("Type in a price");
            price = numberScanner.nextDouble();
            double priceInclTax = price * salesTax;
            System.out.println("The price plus sales tax is " + priceInclTax);

            // To decide if the loop should repeat, ask the user if they want to continue.
            // Notice that the moreCalculations variable is used in the while loop condition.
            System.out.println("Do you want to continue? Type y to continue");
            moreCalculations = numberScanner.next();
        }

        System.out.println("Thanks for using the program - goodbye!");

        stringScanner.close();
        numberScanner.close();

    }

}
