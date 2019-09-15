package week4_list_data_structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  Collections utility methods for ArrayList and LinkedList
 */
public class CollectionsMethods {

    public static void main(String[] args) {

        List<String> animals = new ArrayList<>();
        
        animals.add("Cat");
        animals.add("Zebra");
        animals.add("Fish");
        animals.add("Bird");
        animals.add("Fish");    // I means to add "Fish" twice

        System.out.println("Original animals list: " + animals);

        Collections.sort(animals);      // Sort into order - only if the type of data in the list is sortable
        
        System.out.println("Sorted animals list: " + animals);

        Collections.replaceAll(animals, "Fish", "Shark");  // Replace all "Fish" elements with "Shark"
        System.out.println("Replace \"Fish\" with \"Shark\", now the list is: " + animals);

        Collections.reverse(animals);   // reverse the order of the list
        System.out.println("In reverse order: " + animals);

        Collections.shuffle(animals);   // put elements in random order
        System.out.println("Shuffled list: " + animals);
    
        // Display the minimum value = the lowest value = for strings, the first in the alphabet
        System.out.println("First in the alphabet: " + Collections.min(animals));
        // Display the maximum value = the lowest value = for Strings, the last in the alphabet
        System.out.println("Last in the alphabet: " + Collections.max(animals));
        
        Collections.fill(animals, "Koala");   // Fill the entire ArrayList with "Koala"
        System.out.println("Replaced every element with Koala and now the list is: " + animals);

    }
}
