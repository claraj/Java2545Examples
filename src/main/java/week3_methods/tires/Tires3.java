package week3_methods.tires;

import static input.InputUtils.*;

public class Tires3 {

    public static void main(String[] args) {

        // We can also use a loop

        int tires = intInput("How many tires to compare?");
        for (int x = 0 ; x < tires ; x++) {
            tirePricer();
        }

        // Can we do better? The output from the program is
        // hard to read. The input and output are all mixed together
        // Can we print a report about all the tires when
        // all the data has been entered?
        // See Tires4.java

    }

    public static void tirePricer(){

        String tireName = stringInput("Enter name of tire");
        double price = doubleInput("Enter price for " + tireName);
        double miles = doubleInput("Enter miles for " + tireName);
        double pricePer1000Miles =  price / miles * 1000;
        System.out.println("The " + tireName + " tire costs " + pricePer1000Miles + " per 1000 miles." );

    }



}
