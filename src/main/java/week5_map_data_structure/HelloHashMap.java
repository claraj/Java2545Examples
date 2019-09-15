package week5_map_data_structure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Creating and using a HashMap
 */
public class HelloHashMap {
    
    public static void main(String[] args) {
        
        //Create a new HashMap
        Map<String, String> h = new HashMap<>();
        
        //Add some test data. The class codes are the keys, the class names are the values
        h.put("1100", "Info Tech Concepts");
        h.put("1110", "Info Tech Skills");
        h.put("1150", "Programming Logic");
        h.put("1250", "Windows");
        h.put("1425", "Data Communications");
    
        // printing a HashMap. Note the order of keys is not the same as the order the key-value pairs were added
        System.out.println(h);
        // {1425=Data Communications, 1100=Info Tech Concepts, 1110=Info Tech Skills, 1250=Windows, 1150=Programming Logic}
        
        // Using some HashMap methods
        
        System.out.println("The value for the key 1150 is " + h.get("1150"));
        System.out.println("The value for the key 1999 is " + h.get("1999"));  // null, not error
    
        System.out.println("Does HashMap contain the key 1100? " + h.containsKey("1100"));   // true
    
        System.out.println("Is this HashMap empty? " + h.isEmpty());   // false
        
        System.out.println("How many key value pairs? " + h.size());   // 5
        
        System.out.println("Is there an entry with the value \"Windows\"? " + h.containsValue("Windows"));  // true
        
        System.out.println("Delete the 1250 key-value pair by key. The value is " + h.remove("1250"));  // "Data Communications"
        
        System.out.println("Delete a key that doesn't exist, what does this return? " + h.remove("1724"));   // null
        
        //Want to iterate over the keys? First get a set of all of the keys, then use a for each loop
        
        System.out.println("\nPrinting out all key-value pairs using a for each loop");
        
        System.out.println("\nGet a set of the keys, and loop over that set:\n");
        
        for (String classNumber : h.keySet()) {
            //Use the key to get each value. Repeat for each key.
            System.out.println("Class Number = " + classNumber + " Class Name = " + h.get(classNumber) );
        }
        
        System.out.println("\nPrinting out all values using a loop\n");
        
        for (String value : h.values()) {
            System.out.println(value);
        }
    
        System.out.println("\nA loop for both keys and values\n");
        
        for (Map.Entry<String, String> entry: h.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        
        System.out.println("\nQuestion: why can't you get the key from a value?\n");
        
    }
    
}
