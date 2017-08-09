package week3_methods;

import java.util.Scanner;

public class HelloMethods {

    //Create two scanners
    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    //This is the main method - the first code to run
    public static void main(String[] args) {

        System.out.println("Please enter your name");
        String name = stringScanner.next();
        String greeting = makeGreeting(name);
        System.out.println(greeting);


        //Close scanners.
        stringScanner.close();
        numberScanner.close();

    }    // This is the end of the main method.


    // A new method that we've created.
    // This method takes one argument, a String.
    // It will create a new String made from the word "Hello"
    // plus the String argument, plus an exclamation point !
    // It will then return that new greeting String.
    public static String makeGreeting(String n) {

        String greeting = "Hello " + n + "!";
        return greeting;

    }    // The end of the makeGreeting method

}   // End of the HelloMethods class





