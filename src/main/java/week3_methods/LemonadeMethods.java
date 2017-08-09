package week3_methods;

import java.util.Scanner;

public class LemonadeMethods {

    //Create two scanners
    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Calculate operating cost and profit for a lemonade stand.
        // The lemonade stand sells lemonade, and cookies too.

        double lemonadeProfit = calculateProfit("lemonade");
        System.out.println("Lemonade profit = $" + lemonadeProfit);

        // Do same calculation for cookies

        double cookieProfit = calculateProfit("cookie");
        System.out.println("Cookie profit = $" + cookieProfit);

        // Now it would be much easier to add another produce eg. brownies, or coffee

        //Close scanners.
        stringScanner.close();
        numberScanner.close();

    }

    // Generic calculate profit method
    public static double calculateProfit(String productName) {

        // To calculate profit, need to know how much was spent on supplies, what one item
        // sold for, and the number of items sold.
        System.out.println("How much did you spend on " + productName + " supplies?");
        double suppliesCost = numberScanner.nextDouble();
        System.out.println("What did you sell one " + productName + " for?");
        double salePrice = numberScanner.nextDouble();
        System.out.println("How many " + productName + " units did you sell?");  //could improve the wording :)
        int numberSold = numberScanner.nextInt();

        // Calculate profit
        double profit = ( numberSold * salePrice ) - suppliesCost;

        return profit;

    }

}




