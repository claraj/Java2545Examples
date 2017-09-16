package week3_methods.tires;

import static input.InputUtils.doubleInput;
import static input.InputUtils.stringInput;

public class Tires {

    public static void main(String[] args) {

        /* Unit price tire calculator

        Imagine you are shopping for new tires.

        Here's some example tires:

        Michelin tires, 60000 miles, $89 each
        Bridgestone tires, 70000 miles, $109 each
        Goodyear tires, 10000 miles, $126 each

        Which one is the best value for money?

        Let's calculate the price for 1000 miles, so we can compare the tires.

         */

        String tireName = stringInput("Enter name of tire");
        double price = doubleInput("Enter price for " + tireName);
        double miles = doubleInput("Enter miles for " + tireName);
        double pricePer1000Miles =  price / miles * 1000;
        System.out.println("The " + tireName + " tire costs " + pricePer1000Miles + " per 1000 miles." );


        String tireName2 = stringInput("Enter name of tire");
        double price2 = doubleInput("Enter price for " + tireName2);
        double miles2 = doubleInput("Enter miles for " + tireName2);
        double pricePer1000Miles2 =  price2 / miles2 * 1000;
        System.out.println("The " + tireName2 + " tire costs " + pricePer1000Miles2 + " per 1000 miles." );

        String tireName3 = stringInput("Enter name of tire");
        double price3 = doubleInput("Enter price for " + tireName3);
        double miles3 = doubleInput("Enter miles for " + tireName3);
        double pricePer1000Miles3 =  price3 / miles3 * 1000;

        System.out.println("The " + tireName3 + " tire costs " + pricePer1000Miles3 + " per 1000 miles." );

        // That's a lot of repetition! Can we improve? See Tires2.java
    }
}
