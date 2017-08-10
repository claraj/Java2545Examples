package week3_methods;


import static input.InputUtils.intInput;

public class Counting {


    //This is the main method - the first code to run
    public static void main(String[] args) {

        int smallNumber = intInput("Please enter a small integer number");
        int largeNumber = intInput("Please enter a large integer number");

        System.out.println("I will now count from " + smallNumber + " to " + largeNumber);

        //Call the count method
        count(smallNumber, largeNumber);

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




