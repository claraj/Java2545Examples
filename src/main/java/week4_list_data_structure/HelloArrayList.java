package week4_list_data_structure;


import java.util.ArrayList;
import java.util.List;

public class HelloArrayList {

    public static void main(String[] args) {

        // Create an ArrayList that can store any type of object
        // It's rare to do this, more commonly you'll decide
        // what type of object the List will contain
        
        List myList = new ArrayList();
        myList.add("Hello");
        myList.add(6);
        myList.add("Data");
        myList.add(100);
        myList.add("More data");
        System.out.println("Item 1 is " + myList.get(1));
        System.out.println("Item 3 is " + myList.get(3));

        // Storing data in a variable
        // Everything in the list is an object
        Object ob = myList.get(2);

        // If you know you have a String, need to cast it to the correct type
        // Awkward and error prone - fix for this in the lab. Ignore for now.
        String s = (String)myList.get(0);

        // .get() takes the element number as the argument
        // This line would cause an error - there's no element 100
        //   Object error = myList.get(100);
    }

}
