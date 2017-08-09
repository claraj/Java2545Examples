package week4_data_structures;

import java.util.ArrayList;

/**
 * Capitalize all of the Strings in an ArrayList
 */
public class CapitalizingArrayList {

    public static void main(String[] args) {

        ArrayList myList = new ArrayList();

        myList.add("JavaScript");
        myList.add("C#");
        myList.add("Java");
        myList.add("ruby");

        //Process list, item by item. Capitalize all items and print capitalized version

        for (Object ob : myList) {
            String item = (String) ob;
            item = item.toUpperCase();
            System.out.println(item);
        }

        // Altering the data in the list. Overwrite the original Strings with capitalized versions
        // Easier with a traditional for loop

        System.out.println("The list is: " + myList);

        for (int x = 0 ; x < myList.size() ; x++) {
            String item = (String) myList.get(x);
            String uppercase = item.toUpperCase();
            myList.set(x, uppercase);        // set replaces element x with the variable uppercase
        }

        System.out.printf("The capitalized list is " + myList);
    }
}
