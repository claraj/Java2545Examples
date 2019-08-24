package week3_methods.tires;

import static input.InputUtils.doubleInput;
import static input.InputUtils.stringInput;

/**
 * Created by clara on 2019-08-23.
 * Calculate cost per mile for a tire, during it's warranty miles.
 */
public class Tires1 {
    
    public static void main(String[] args) {
        String tireName = stringInput("Enter name of tire");
        double price = doubleInput("Enter price for " + tireName);
        double miles = doubleInput("Enter warranty miles for " + tireName);
        double pricePerMile = price / miles;
        System.out.println("The " + tireName + " tire costs " + pricePerMile + " dollars per miles.");
    }
}

