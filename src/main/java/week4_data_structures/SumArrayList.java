package week4_data_structures;

import java.util.ArrayList;

/**
 * Add up all of the elements in an ArrayList
 */
public class SumArrayList {

    public static void main(String[] args) {

        ArrayList numberList = new ArrayList();
        numberList.add(100);
        numberList.add(200);
        numberList.add(300);

        // Add up all of the numbers in numberList

        int sum = 0;
        for (Object ob : numberList) {
            int number = (int) ob;        // Casting Object to int
            sum = sum + number;
        }

        System.out.println("The total of all numbers is " + sum);

    }
}
