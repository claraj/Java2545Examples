package week3_methods;


import static input.InputUtils.intInput;

public class FillArray {


    //This is the main method - the first code to run
    public static void main(String[] args) {

        int smallNumber = intInput("Please enter a small integer number");
        int largeNumber = intInput("Please enter a large integer number");

        int[] integerNumberArray = fillArray(smallNumber, largeNumber);

        System.out.println("Here's the array I have created");
        printArray(integerNumberArray);

    }    // This is the end of the main method.


    //Creates and return an array, filled with the numbers min through max
    // e.g. if min = 3 and max = 6 the array will contain { 3, 4, 5, 6 }
    public static int[] fillArray(int min, int max) {

        // What size is the array? max-min, plus 1.
        int numbers[] = new int[ (max-min) + 1];

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



