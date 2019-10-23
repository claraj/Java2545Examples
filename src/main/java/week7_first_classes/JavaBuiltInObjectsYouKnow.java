package week7_first_classes;

import java.util.*;

/**
 * Created by clara on 10/23/19.
 */
public class JavaBuiltInObjectsYouKnow {
    
    public static void main(String[] args) {
        
        // Some objects you already know!
        
        // ArrayList (also LinkedList, Vector)
        List<String> colleges = new ArrayList<>();
        colleges.add("MCTC");
        colleges.add("St Paul College");
        System.out.println("Does colleges contain MCTC? " + colleges.contains("MCTC"));
        
        // HashMaps
        Map<String, Integer> roomCapacities = new HashMap<>();
        roomCapacities.put("T.3030", 25);
        roomCapacities.put("T.3040", 20);
        roomCapacities.put("T.3050", 35);
        
        System.out.println("The capacity of T.3040 is " + roomCapacities.get("T.3050"));
        
        // Random number generators
        Random rnd = new Random();
        System.out.println("A random number is " + rnd.nextInt(10));
        
        // FileReader, FileWriter, BufferedReader, BufferedWriter are also objects
        
        
    }
}
