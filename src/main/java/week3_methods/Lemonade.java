package week3_methods;

import java.util.Scanner;

public class Lemonade {

    //Create two scanners
    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Calculate operating cost and profit for a lemonade stand.
        // The lemonade stand sells lemonade, and cookies too.

        // To calculate profit, need to know how much was spent on lemonade supplies, what one cup of
        // lemonade sold for, and the number of cups sold.
        System.out.println("How much did you spend on lemonade supplies?");
        double lemonadeSuppliesCost = numberScanner.nextDouble();
        System.out.println("What did you sell one cup of lemonade for?");
        double lemonadeSalePrice = numberScanner.nextDouble();
        System.out.println("How many cups of lemonade did you sell");
        int lemonadeCupsSold = numberScanner.nextInt();

        // Calculate profit

        double lemonadeProfit = ( lemonadeCupsSold * lemonadeSalePrice ) - lemonadeSuppliesCost;

        System.out.println("Lemonade profit = $" + lemonadeProfit);

        // Do same calculation for cookies

        // To calculate profit, need to know how much was spent on cookie supplies, what one cookie
        // sold for, and the number of cookies sold.
        System.out.println("How much did you spend on cookie supplies?");
        double cookieSuppliesCost = numberScanner.nextDouble();
        System.out.println("What did you sell one cookie for?");
        double cookieSalePrice = numberScanner.nextDouble();
        System.out.println("How many cookies did you sell?");
        int cookiesSold = numberScanner.nextInt();

        // Calculate profit
        double cookieProfit = ( cookiesSold * cookieSalePrice ) - cookieSuppliesCost;

        System.out.println("Cookie profit = $" + cookieProfit);

        //Close scanners.
        stringScanner.close();
        numberScanner.close();

    }
}




