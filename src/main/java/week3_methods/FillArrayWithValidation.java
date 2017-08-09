package week3_methods;

import java.util.Scanner;

public class FillArrayWithValidation {

    //Create two scanners
    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    //This is the main method - the first code to run
    public static void main(String[] args) {


        System.out.println("Please enter a small integer number");
        int smallNumber = numberScanner.nextInt();
        System.out.println("Please enter a large integer number");
        int largeNumber = numberScanner.nextInt();

        //Let's check if smallNumber is actually smaller than largeNumber...

        if (largeNumber - smallNumber < 0) {
            //For example, if user enters 6 for smallNumber and 3 for largeNumber,
            //the loop won't work.
            System.out.println("Error - please enter a small number and then a large number");
        }

        else if (smallNumber == largeNumber) {
            System.out.println("Both of these numbers are the same");
        }

        else {

            //Yay - have a sensible large number and small number
            int[] integerNumberArray = fillArray(smallNumber, largeNumber);

            System.out.println("Here's the array I have created");
            printArray(integerNumberArray);
        }

        //Close scanners.
        stringScanner.close();
        numberScanner.close();

    }    // This is the end of the main method.


    //Creates and return an array, filled with the numbers min through max
    // e.g. if min = 3 and max = 6 the array will contain { 3, 4, 5, 6 }
    public static int[] fillArray(int min, int max) {

        int numbers[] = new int[(max-min) + 1];

        for (int i = 0 ; i <= max-min ; i++) {
            numbers[i] = i+min;
        }
        return numbers;
    }

    //Takes an int array, and prints it out, one element per line
    public static void printArray(int array[]){
        for (int i = 0 ; i < array.length ; i++ ) {
            System.out.println(array[i]);
        }
    }


}



