package week2_loops_arrays;

import java.util.Arrays;

public class HelloArrays {

    public static void main(String[] args) {

        //Create and work with some example arrays

        // Create an array to store 10 int variables
        // For example, to store 10 quiz scores
        int[] scores = new int[10];

        //Create an array called values to store 3 ints
        int[] values = new int[3];

        //The size of the array is an integer too, so you can use a variable to specify the size of array
        //Perhaps you'll ask the user how many items of data they need to store, and use that for size?
        int size = 10;
        int[] moreData = new int[size];

        //Create an array called names to store 100 Strings
        String[] names = new String[100];

        //Create an array called prices to store 70 doubles
        double[] prices = new double[70];

        // Create an array to store 3 int variables

        int[] data = new int[3];

        //Put some data into the array
        //Set the first element - (element 0) to 10
        data[0] = 10;

        //Set the second element, (element 1), to 15
        data[1] = 15;

        //Set the third element - (element 2) - to 7
        data[2] = 7;

        // Display the data in the array

        System.out.println("Element 0 is " + data[0]);
        System.out.println("Element 1 is " + data[1]);
        System.out.println("Element 2 is " + data[2]);


        //Modify the data in some of the array elements

        // Set the first element to 50
        data[0] = 50;
        // Set the last element to -10
        data[2] = -10;

        // The array is now { 50, 15, -10 }

        // Add 3 to the first element

        data[0] = data[0] + 3;

        // The array is now { 53, 15, -10 }


        // Copy the second element (element 1) to a new int variable
        // The array is not modified
        int someData = data[1];

        System.out.println("The data copied was " + someData);

        // Copy some data from a variable to the last element of the array
        int newData = 25;
        data[2] = newData;

        // The array is now { 53, 15, 25 }


        // How many things are in the array? Or, what is the length of the array?
        // use arrayname.length to get an int value, the number of elements.

        int sizeOfArray = data.length;

        System.out.println("The data array has " + sizeOfArray + " elements");


        // Try to print the array...
        System.out.println("Here's the data array " + data);
        // oh no! Look at the output. It will look something like this
        // [I@5451c3a8
        // The exact numbers may be different on your computer, that's ok.
        // Arrays are objects, and if you print an object, you'll actually see the type of this object and it's memory location.
        // [I  is an abbreviation for integer array, the numbers are the location in memory of this array object.

        // Two ways to fix:

        // 1. Loop over the array and print each value

        for (int x = 0 ; x < data.length ; x++) {
            System.out.println("Element " + x + " is " + data[x]);
        }

        // 2. Use a library method called Arrays.toString
        // This prints [53, 15, 25]
        System.out.println(Arrays.toString(data));


        // Let's create another array, initialized with data
        // The length of the array is the number of data points supplied.
        int[] evenNumbers = {0, 2, 4, 6, 8};

        //Print this array, to verify
        System.out.println(Arrays.toString(evenNumbers));

        // Create a string array, initialized with data
        String[] classrooms = { "T3010", "T3020", "T3030", "T3040", "T3050", "T3080"};



        // How many elements in the array? What's the size - or length - of the array?
        int numberOfClassrooms = classrooms.length;

        System.out.println("There are " + numberOfClassrooms + " classrooms");


        //Use a loop to print all of the data from the array
        //Notice how the loop counter is used
        for (int x = 0 ; x < 6 ; x++) {
            System.out.println(classrooms[x]);
        }

        // This is a better way of looping over the array.
        // Do you think this will work if we have a different number of classrooms?
        for (int x = 0 ; x < classrooms.length ; x++) {
            System.out.println(classrooms[x]);
        }

        //Can also print the entire array on one line too
        System.out.println(Arrays.toString(classrooms));


    }
}
