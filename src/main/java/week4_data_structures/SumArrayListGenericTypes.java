package week4_data_structures;

import java.util.ArrayList;

/**
 * Add up all of the elements in an ArrayList
 */
public class SumArrayListGenericTypes {

    public static void main(String[] args) {

        // Specify that this is an ArrayList of Integers.
        // Now, we can only add Integers to the ArrayList, and the compiler will
        // complain if we try and add anything else. Java guarantees that this is a list of Integers.
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        numberList.add(100);
        numberList.add(200);
        numberList.add(300);

        //The compiler would indicate an error on this line.
        //numberList.add("Not an integer");  // Error! Program won't compile.


        // Now, when we add up all of the numbers in numberList, we know it's just numbers,
        // so when we loop over the list, we can loop over all of the Integers in the list
        // No need for casting

        int sum = 0;

        // Loop over all of the Integers in the list
        for (Integer number: numberList) {
            sum = sum + number;    // So now the variable from the list is an Integer
                                   // and we can do Integer things with it without casting
        }

        System.out.println("The total of all numbers is " + sum);

    }
}
