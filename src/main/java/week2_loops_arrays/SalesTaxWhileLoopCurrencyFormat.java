package week2_loops_arrays;


import java.text.NumberFormat;
import java.util.Scanner;

public class SalesTaxWhileLoopCurrencyFormat {

    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    public static void main(String[] args) {

        String moreCalculations = "y";
        double price;
        double salesTax = 1.07;

        while (moreCalculations.equals("y")) {
            System.out.println("Type in a price");
            price = numberScanner.nextDouble();
            double priceInclTax = price * salesTax;

            //Create a NumberFormat object - this takes numbers, and formats them to a particular format
            //in this case, as a currency value. If your computer's location is set to the US, then
            //it will display with a dollar sign, a period separating the dollars and cents, and 2 decimal places.
            //If you happen to be in Europe, you'll see a Euro sign, and a comma separating the Euros and cents.

            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
            String formattedPrice = currencyFormatter.format(priceInclTax);

            System.out.println("The price plus sales tax is " + formattedPrice);

            System.out.println("Do you want to continue? Type y to continue");
            moreCalculations = numberScanner.next();
        }

        System.out.println("Thanks for using the program - goodbye!");

        stringScanner.close();
        numberScanner.close();

    }

}
