package week3_methods;


import static input.InputUtils.doubleInput;

public class MilesToKm {


    //This is the main method - the first code to run
    public static void main(String[] args) {

        double miles = doubleInput("Please enter number of miles");
        double km = milesToKM(miles);
        System.out.println(miles + " miles is equal to " + km + " kilometers");

    }    // This is the end of the main method.

    // This method takes one argument, a number of miles
    // It calculates the equivalent in kilometers, and returns that value
    public static double milesToKM(double miles) {

        double km = miles * 1.6;   // One mile is 1.6 kilometers
        return km;

    }    // The end of the milesToKM method

}


