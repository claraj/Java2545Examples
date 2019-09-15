package week4_list_data_structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Removing data from ArrayLists.
 */
public class RemovingFromArrayList {

    public static void main(String[] args) {

        List<String> animals = new ArrayList<>();
    
        animals.add("Lion");
        animals.add("Tiger");
        animals.add("Bear");
    
        System.out.println(animals);   // [Lion, Tiger, Bear]
        System.out.println("Is the list empty? " + animals.isEmpty());  // false
        
        // Remove everything
        animals.clear();
    
        System.out.println(animals);   // []
        System.out.println("Is the list empty? " + animals.isEmpty());  // true
    
        
        animals.add("Lion");
        animals.add("Tiger");
        animals.add("Bear");
        
        int numberOfAnimals = animals.size();
        System.out.println("There are " + numberOfAnimals + " animals in the list.");
        
    
        if (animals.contains("Bear")) {
            System.out.println("The list contains a bear");
        } else {
            System.out.println("No bear in this list");
        }
        
        
        animals.set(2, "Panther");  // List is [Lion, Tiger, Panther]
        //animals.set(4, "Cheetah");  // error!
    
        // Remove everything
        animals.clear();
    
        animals.add("Lion");
        animals.add("Tiger");
        animals.add("Bear");
        
        animals.remove(2);  // Removes "Bear", list is [Lion, Tiger]
        animals.remove(0);  // removes "Lion", list is [Tiger]
        
        // Remove everything
        animals.clear();
        
        animals.add("Cat");
        animals.add("Bird");
        animals.add("Frog");
    
        animals.remove("Frog");   // List is now [Cat, Bird]
        animals.remove("Zebra");  // No effect on list
    
        // Remove everything
        animals.clear();
        
        // Add some data and variables
        animals.add("Cat");
        animals.add("Parrot");
        animals.add("Frog");
        animals.add("Tiger");
        animals.add("Whale");
        animals.add("Penguin");
        
        String last = "Giraffe";
        animals.add(last);

        System.out.println(animals);  // [Cat, Parrot, Frog, Tiger, Whale, Penguin, Giraffe]
    
        // Remove by object's value. Can use literal data, or variables
        // The remove(value) method returns a boolean, whether the data was found and removed or not.
        // You can ignore the return value if you don't need it.
    
        animals.remove("Frog");
        System.out.println(animals);  // [Cat, Parrot, Tiger, Whale, Penguin, Giraffe]
        
        animals.remove(last);         // last was "Giraffe"
        System.out.println(animals);  // [Cat, Parrot, Tiger, Whale, Penguin]
        
        // If you try to remove an element that is not in the ArrayList, then the remove statement has no effect
        animals.remove("Squid");  // no effect on the ArrayList

        // Using the returned boolean to verify if the item was found and removed.

        System.out.println("Attempting to remove \"Armadillo\"");
        if (animals.remove("Armadillo")) {
            System.out.println("Armadillo was removed");
        } else {
            // This is printed
            System.out.println("The data \"Armadillo\" was not found in the list, so nothing was removed");
        }

        // Remove by index position. remove(index) returns the object that was removed.
        
        // Remove element at index 2
        animals.remove(2);
        System.out.println(animals);  // [Cat, Parrot, Whale, Penguin]
    
        // Remove element at index 0
        animals.remove(2);
        System.out.println(animals);    // [Cat, Parrot, Penguin]
    
        // Remove by index number and save the data removed

        // What's the first element?
        String a1 = animals.remove(0);

        System.out.println("The first element is: " + a1);   // The first element is: Cat
        System.out.println("And the list is now " + animals);   // And the list is now [Parrot, Penguin]
        
        String a2 = animals.remove(1);
        System.out.println("Removed this element from the ArrayList: " + a2);    // Removed this element from the ArrayList: Penguin
        System.out.println("The ArrayList is now " + animals);    // The ArrayList is now [Parrot]
        
        // Make sure you remove valid indexes
        // What do you think this will do? There is no index 100 in this List
        //animals.remove(100);
        
    }
}
