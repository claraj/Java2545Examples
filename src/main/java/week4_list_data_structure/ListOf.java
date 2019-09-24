package week4_list_data_structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clara on 2019-09-24.
 */
public class ListOf {
    
    public static void main(String[] args) {
        
        // Create a non-modifiable list using List.of
        List<String> nonModifiableList = List.of("Cat", "Bird", "Fish");
        //nonModifiableList.add("Giraffe");  // This will error
        //nonModifiableList.remove(0); // This will error too
    
        System.out.println(nonModifiableList);
        
        // Compare to creating a list that can be modified
        List<String> modifiableList = new ArrayList<>();
        
        // Adding and removing works
        modifiableList.add("Owl");
        modifiableList.add("Bee");
        modifiableList.add("Yak");
        modifiableList.remove(1);
        System.out.println(modifiableList);
        
    
    
    }
}
