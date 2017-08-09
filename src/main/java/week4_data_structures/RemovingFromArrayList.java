package week4_data_structures;

import java.util.ArrayList;

/**
 * Removing data from ArrayLists.
 */
public class RemovingFromArrayList {

    public static void main(String[] args) {

        ArrayList myList = new ArrayList();

        // Add some data and variables

        myList.add("Hello");
        myList.add(4);
        myList.add("Data");
        myList.add(100);
        myList.add("More data");
        myList.add(12.34);
        myList.add("Even more data!");

        String last = "Last item";
        myList.add(last);

        System.out.println(myList);
        // myList is [Hello, 4, Data, 100, More data, 12.34, Even more data!, Last item]

        //Remove by object's value
        myList.remove("More data");
        System.out.println(myList);
        //Now myList is [Hello, 4, Data, 100, 12.34, Even more data!, Last item]

        //Remove by object's value. Can use literal data, or variables
        myList.remove(last);
        System.out.println(myList);
        //Now myList is [Hello, 4, Data, 100, 12.34, Even more data!]


        // If you try to remove an element that is not in the ArrayList, then the remove statement has no effect

        myList.remove("A non-existent element");  // no effect on the ArrayList

        // remove(yourElement) actually returns a boolean value, which reflects whether an item was removed or not,
        // so you can use it to verify if the item was found and removed.

        System.out.println("Attempting to remove \"Another non-existent element\"");
        if (myList.remove("Another non-existent element")) {
            System.out.println("The element was removed");
        } else {
            System.out.println("The element was not found in the list, so nothing was removed");
        }

        //Removing by position - this removes item 2 (the 3rd item) - the String "Data"
        myList.remove(4);
        System.out.println(myList);
        //Now myList is [Hello, 4, 100, 12.34, Even more data!]

        //What if you want to remove the int 100 from the list? Perhaps something like this?

        //myList.remove(100);

        // Unfortunately this isn't going to work.
        // 100 is an int, and remove() will try to remove element 100.
        // But there's only 5 elements in the list so the program will crash.

        // And if it doesn't crash - for example, code like
        // myList.remove(4);
        // may be expected this to remove the element containing the int 4
        // but it actually removes the element in position 4 of the ArrayList
        // which can cause hard-to-find bugs

        //So how do you remove an int from an ArrayList?

        // Convert your int to an Integer object, and then remove that. This removes the element containing 100
        myList.remove(new Integer(100));
        System.out.println(myList);
        //Now myList is [Hello, 4, 12.34, Even more data!]

        // Why? There are two versions of remove().
        // One takes an int as an argument. The other takes an Object as the argument.
        // int is a primitive type, NOT an object. If the argument is an int, then remove() treats the argument as a
        // int representing an element number and attempts to remove the data at that element number.
        // If the argument to remove() is an Object, of any kind, then remove() treats that argument as data to search
        // the ArrayList for, and remove it if found.

        // So, if we want to search the ArrayList for an integer number and remove that, we need to turn that int into an Object.
        // All primitive types have a corresponding Object type. The Object type simply 'wraps' the primitive type.
        // So, there are int (primitive) and Integer (Object).
        // To remove an int element from an ArrayList, convert it into an Integer and then use remove() to remove that Integer object.

        myList.remove(new Integer(4));   // Removes the int 4 from the ArrayList.
        System.out.println(myList);
        // Now myList is [Hello, Data, Even more data!]

        // Remove by element number and save the data removed

        //What's the first element?
        //Everything is an Object. If you know that your data is a String and that it should be saved in a
        // String variable, it is necessary to cast it to the String type. That's what (String) is for.
        // This is yucky. We'll see a better way in lab.

        String first = (String)myList.remove(0);
        //String first = myList.remove(0); // would not work - everything is an Object, not a String.

        System.out.println("The first element is " + first);   // "Hello"
        System.out.println("And the list is now " + myList);   // The list is now [Data, Even more data!]


        String moreData = (String) myList.remove(1);
        System.out.println("Removed this element from the ArrayList" + moreData);   // "Even more data!"
        System.out.println("The ArrayList is now " + myList);    //  [Data]


    }
}
