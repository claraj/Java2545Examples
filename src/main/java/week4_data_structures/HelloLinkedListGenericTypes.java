package week4_data_structures;


/** LinkedList is very similar to ArrayList. Use Generic types in the same way */


import java.util.LinkedList;

public class HelloLinkedListGenericTypes {

    public static void main(String[] args) {

        LinkedList<Double> myList = new LinkedList<Double>();

        myList.add(23456.0);
        myList.add(-60.5);
        myList.add(1234.2345);
        myList.add(10.0);
        myList.add(98765.0);
        System.out.println("Item 1 is " + myList.get(1));
        System.out.println("Item 3 is " + myList.get(3));

        // Storing data in a variable
        // Everything in the list is an object
        double thirdItem = myList.get(2);

        // Add up all of the numbers in the list
        double sum = 0.0;

        for (double d : myList) {
            sum += d;
            // sum += d; is shorthand for
            // sum = sum + d;
        }

        System.out.println("All of the numbers added together makes: " + sum);
    }
}
