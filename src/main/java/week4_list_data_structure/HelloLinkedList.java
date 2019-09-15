package week4_list_data_structure;

import java.util.LinkedList;
import java.util.List;

public class HelloLinkedList {

    public static void main(String[] args) {

        List<String> trees = new LinkedList<>();  // Create LinkedList
    
        trees.add("Pine");     // Add data at the end
        trees.add("Oak");      // Add data at the end
        trees.add("Elm");      // Add data at the end
        trees.add("Aspen");    // Add data at the end
    
        trees.add(2, "Palm");   // Add data at index 2, in the middle
    
        System.out.println("Tree at index 1 is " + trees.get(1));  // Get by index. Prints "Oak"
    
        for (String tree: trees) {
            System.out.println(tree);
        }
    
        trees.remove("Oak");   // Remove by value
        trees.remove(0);     // Remove String at index 0, the first element
    
        System.out.println(trees);
        
        if (trees.contains("Aspen")) {
            System.out.println("Tree List contains Aspen");
        }
    
        int numberOfTrees = trees.size();
        System.out.println("There are " + numberOfTrees + " trees in the list.");
        
    }

}
