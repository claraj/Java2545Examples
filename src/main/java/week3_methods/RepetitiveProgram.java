package week3_methods;

import java.util.Scanner;

public class RepetitiveProgram {

    //Create two scanners
    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Coffee Shop Sales Calculator Program");

        double totalSales = 0;

        System.out.println("How many cups of coffee did you sell today?");
        int cups = numberScanner.nextInt();
        System.out.println("What does a cup of coffee cost?");
        double price = numberScanner.nextDouble();
        double drinkSales = price * cups;
        totalSales = totalSales + drinkSales;

        System.out.println("How many cups of hot chocolate did you sell today?");
        cups = numberScanner.nextInt();
        System.out.println("What does a cup of hot chocolate cost?");
        price = numberScanner.nextDouble();
        drinkSales = price * cups;
        totalSales = totalSales + drinkSales;

        System.out.println("How many cups of tea did you sell today?");
        cups = numberScanner.nextInt();
        System.out.println("What does a cup of tea cost?");
        price = numberScanner.nextDouble();
        drinkSales = price * cups;
        totalSales = totalSales + drinkSales;

        System.out.println("How many cups of cappuccino did you sell today?");
        cups = numberScanner.nextInt();
        System.out.println("What does a cup of cappuccino cost?");
        price = numberScanner.nextDouble();
        drinkSales = price * cups;
        totalSales = totalSales + drinkSales;

        System.out.println("Total sales for the day are $"  + totalSales);


        //Close scanners.
        stringScanner.close();
        numberScanner.close();

    }
}