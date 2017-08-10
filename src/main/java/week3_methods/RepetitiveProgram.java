package week3_methods;


import static input.InputUtils.doubleInput;
import static input.InputUtils.intInput;

public class RepetitiveProgram {


    public static void main(String[] args) {

        System.out.println("Coffee Shop Sales Calculator Program");

        double totalSales = 0;

        System.out.println("How many cups of coffee did you sell today?");
        int cups = intInput();
        System.out.println("What does a cup of coffee cost?");
        double price = doubleInput();
        double drinkSales = price * cups;
        totalSales = totalSales + drinkSales;

        System.out.println("How many cups of hot chocolate did you sell today?");
        cups = intInput();
        System.out.println("What does a cup of hot chocolate cost?");
        price = doubleInput();
        drinkSales = price * cups;
        totalSales = totalSales + drinkSales;

        System.out.println("How many cups of tea did you sell today?");
        cups = intInput();
        System.out.println("What does a cup of tea cost?");
        price = doubleInput();
        drinkSales = price * cups;
        totalSales = totalSales + drinkSales;

        System.out.println("How many cups of cappuccino did you sell today?");
        cups = intInput();
        System.out.println("What does a cup of cappuccino cost?");
        price = doubleInput();
        drinkSales = price * cups;
        totalSales = totalSales + drinkSales;

        System.out.println("Total sales for the day are $"  + totalSales);

        
    }
}