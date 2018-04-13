package week3_methods.tires;

import static input.InputUtils.doubleInput;
import static input.InputUtils.stringInput;

public class Tires2 {

    public static void main(String[] args) {

        // Move tire calculating code to a method.
        // Now, can call method as many times as we need.
        tirePricer();
        tirePricer();
        tirePricer();
        tirePricer();

        // We can still improve... see Tires3.primary_keys

    }

    public static void tirePricer(){

        String tireName = stringInput("Enter name of tire");
        double price = doubleInput("Enter price for " + tireName);
        double miles = doubleInput("Enter miles for " + tireName);
        double pricePer1000Miles =  price / miles * 1000;
        System.out.println("The " + tireName + " tire costs " + pricePer1000Miles + " per 1000 miles." );

    }



}
