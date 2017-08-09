package week3_methods;

import java.util.Scanner;

public class Counting {

    //Create two scanners
    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    //This is the main method - the first code to run
    public static void main(String[] args) {

        System.out.println("Please enter a small integer number");
        int smallNumber = numberScanner.nextInt();
        System.out.println("Please enter a large integer number");
        int largeNumber = numberScanner.nextInt();

        System.out.println("I will now count from " + smallNumber + " to " + largeNumber);

        //Call the count method
        count(smallNumber, largeNumber);


        //Close scanners.
        stringScanner.close();
        numberScanner.close();

    }    // This is the end of the main method.


    // A new method that we've created called count
    // This method takes two arguments, both integers,
    // representing a number to start counting from and a number to stop counting at
    // It will count from min to max, printing out each number.
    public static void count(int min, int max) {

        for (int i = min ; i <= max ; i++) {
            System.out.println(i);
        }

    }  // The end of the count method

}   // The end of the Counting class




