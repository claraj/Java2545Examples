package week4_list_data_structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Removing data from integer ArrayLists.
 */

public class RemovingIntFromArrayList {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        
        numbers.add(100);   // Add int value
        
        // Add some more ints
        numbers.add(5);
        numbers.add(42);
        numbers.add(71);
        numbers.add(201);
        numbers.add(22);
        
        System.out.println(numbers);   // [100, 5, 42, 71, 201, 22]
        
        numbers.remove(5);
        
        System.out.println(numbers);  // [100, 5, 42, 71, 201].
        
        // What happened? The data 5 is still in the list.
        // The call to remove(5) removed the element at index 5.
        // 100 is an int, and remove() will try to remove element 100.
        // But there's only 5 elements in the list so the program will crash.

        // And if it doesn't crash - for example, code like
        // myList.remove(4);
        // may be expected this to remove the element containing the int 4
        // but it actually removes the element in position 4 of the ArrayList
        // which can cause hard-to-find bugs

        // So how do you remove an int from an ArrayList?

        // Convert your int to an Integer object, and then remove that.
        // This removes the element with the value 5
        
        numbers.remove(Integer.valueOf(5));
        System.out.println(numbers);        // [100, 42, 71, 201]
       
        // Why? There are two versions of remove().
        // One takes an int as an argument. The other takes an Object as the argument.
        // int is a primitive type, NOT an object. If the argument is an int, then remove() treats the argument as a
        // int representing an element number and attempts to remove the data at that element number.
        // If the argument to remove() is an Object, of any kind, then remove() treats that argument as data to search
        // the ArrayList for, and remove it if found.

        // So, if we want to search the ArrayList for an integer number and remove that, we need to turn that int into an Object.
        // All primitive types have a corresponding Object type. The Object type simply 'wraps' the primitive type.
        // So, there are int (primitive) and Integer (Object).
        // To remove an int element from an ArrayList, create an Integer from it with
        // Integer.valueOf(number)
        // and then use remove() to remove that Integer object.

        numbers.remove(Integer.valueOf(42));   // Removes the int 4 from the ArrayList.
        System.out.println(numbers);
        
        // Remove by element number and save the data removed
        
        int first = numbers.remove(0);
     
        System.out.println("The first element is " + first);   // The first element is 100
        System.out.println("And the list is now " + numbers);   // And the list is now [71, 201]
        
        int moreData = numbers.remove(1);
        System.out.println("Removed this element from the ArrayList: " + moreData);   // Removed this element from the ArrayList 201
        System.out.println("The ArrayList is now " + numbers);    //  The ArrayList is now [71]
    
        
        // If you try to remove an element that is not in the ArrayList, then the remove statement has no effect
        numbers.remove(Integer.valueOf(888));  // no effect on the ArrayList
    
        // remove(yourElement) actually returns a boolean value, which reflects whether an item was removed or not,
        // so you can use it to verify if the item was found and removed.
    
        System.out.println("Attempting to remove 100000");
        if (numbers.remove(Integer.valueOf(100000))) {
            System.out.println("The element 100000 was removed");
        } else {
            System.out.println("The element 100000 was not found in the list, so nothing was removed");
        }
        
    }
}
