package week2_loops_arrays;

import java.text.NumberFormat;

import static input.InputUtils.doubleInput;
import static input.InputUtils.yesNoInput;

public class SalesTaxWhileLoopCurrencyFormat {
    
    public static void main(String[] args) {

        boolean moreCalculations = true;
        double price;
        double salesTax = 1.07;

        while (moreCalculations) {
            
            price = doubleInput("Type in a price");
            double priceInclTax = price * salesTax;

            //Create a NumberFormat object - this takes numbers, and formats them to a particular format
            //in this case, as a currency value. If your computer's location is set to the US, then
            //it will display with a dollar sign, a period separating the dollars and cents, and 2 decimal places.
            //If you happen to be in Europe, you'll see a Euro sign, and a comma separating the Euros and cents.

            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
            String formattedPrice = currencyFormatter.format(priceInclTax);

            System.out.println("The price plus sales tax is " + formattedPrice);

            moreCalculations = yesNoInput("Do you want to continue? ");
        }

        System.out.println("Thanks for using the program - goodbye!");
        
    }

}
