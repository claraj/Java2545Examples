package week4_list_data_structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Capitalize all of the Strings in an ArrayList
 */
public class CapitalizingArrayListGenericTypes {

    public static void main(String[] args) {

        //Create an ArrayList that can only contain String variables
        List<String> myList = new ArrayList<>();

        //Adding is the same - you can only add String data
        myList.add("JavaScript");
        myList.add("C#");
        myList.add("Java");
        myList.add("ruby");

        //Process list, item by item. Capitalize all items and print capitalized version
        //Loop over all of the Strings in the list, not all of the Objects

        for (String item : myList) {
            item = item.toUpperCase();
            System.out.println(item);
        }

        // Altering the data in the list. Overwrite the original Strings with capitalized versions
        // Easier with a traditional for loop

        System.out.println("The list is: " + myList);

        for (int x = 0 ; x < myList.size() ; x++) {
            String item = myList.get(x);
            String uppercase = item.toUpperCase();
            myList.set(x, uppercase);        // set replaces element x with the variable uppercase
        }

        System.out.printf("The capitalized list is " + myList);
    }
}
