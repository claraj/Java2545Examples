package week2_loops_arrays;

import static input.InputUtils.positiveDoubleInput;

public class PCPartPrices {

    public static void main(String[] args) {

        /* PC component arrays - get price per component, and figure out total */

        String programName = "PC Part Prices";
        // Array creation - array initializer.  What else do we need?
        String[] components = {"Motherboard", "Case", "Power Supply", "CPU", "SSD", "Memory", "Cables"};

        // Array creation - 'empty' array - each element contains 0.0
        double[] prices = new double[components.length];   // parallel array to components

        /* Ask the user for the price for each component */
        /* TODO run this in the debugger! */
        for (int x = 0; x < components.length; x++) {
            String component = components[x];
            double pricePerComponent = positiveDoubleInput("Enter price for " + component);
            prices[x] = pricePerComponent;
        }

        /* Calculate total price for PC build */
        double total = 0;
        for (int x = 0; x < prices.length; x++) {
            double price = prices[x];
            total = total + price;
        }
        System.out.println("The total price is " + total);

        // print components and prices in a table, using string formatting
        System.out.printf("%-20s %-20s\n", "Component", "Price");
        for (int x = 0; x < components.length; x++) {
            String component = components[x];
            double price = prices[x];
            System.out.printf("%-20s $%-20.2f\n", component, price);
        }
    }
}
