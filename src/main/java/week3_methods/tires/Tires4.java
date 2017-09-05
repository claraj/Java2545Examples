package week3_methods.tires;

import static input.InputUtils.*;

public class Tires4 {

    public static void main(String[] args) {


        int tires = intInput("How many tires to compare?");

        String[] tireReports = new String[tires];

        for (int x = 0 ; x < tires ; x++) {
            String report = tirePricer();
            tireReports[x] = report;
        }

        for (int x = 0 ; x < tires; x++) {
            System.out.println(tireReports[x]);
        }
    }

    // Return the output String from the tirePricer method.
    // main method can save that string, and print all the report
    // Strings together.

    public static String tirePricer(){

        String tireName = stringInput("Enter name of tire");
        double price = doubleInput("Enter price for " + tireName);
        double miles = doubleInput("Enter miles for " + tireName);
        double pricePer1000Miles =  price / miles * 1000;
        return "The " + tireName + " tire costs " + pricePer1000Miles
                + " per 1000 miles." ;

    }



}
