package week5_map_data_structure;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by clara on 2019-10-01. Speed test for various HashMap loops
 */
public class HashMapSpeedTest {
    
    static Random rnd = new Random();
    
    public static void main(String[] args) {
        
        // Create a GINORMOUS HashMap
        Map<String, Integer> test = new HashMap<>();
        
        // This might take a while
        for (int value = 0; value < 10000000; value++) {
            test.put(randomString(), value);
        }
    
        System.out.println("Generated HashMap of size " + test.size());
    
        // Speed tests
        
        timeValues(test);    // Example run 2023 ms, about 2 seconds
        timeKeySet(test);    // Example run 1569 ms, about 1.5 seconds
        timeEntrySet(test);  // Example run 3848 ms, about 4 seconds
    
        
        // Conclusion: looping over keys or values is about 2-3 times faster than the EntrySet method
        // Looping over keys is not that much slower than looping over values, because i'ts very fast to loop op value for a key
        
    }
    
    public static String randomString() {
        
        // Generate random strings of 10 capital letters
        
        StringBuilder b = new StringBuilder();
        
        for (int x = 0; x < 10 ; x++) {
            String letter = Character.toString(rnd.nextInt(26) + 65);   // Generate random letter
            b.append(letter);
        }
    
        return b.toString();
    }
    
    public static void timeEntrySet(Map<String, Integer> test ) {
        long startTime = new Date().getTime();
    
        long total = 0;
        for (Map.Entry<String, Integer> entry: test.entrySet()) {
            total += entry.getValue();
        }
    
        long endTime = new Date().getTime();
    
        System.out.println("EntrySet total is " + total + " and loop took " + (endTime-startTime) + "ms.");
    }
    
    
    public static void timeKeySet(Map<String, Integer> test) {
        long startTime = new Date().getTime();
    
        long total = 0;
        for (String key: test.keySet()) {
            total += test.get(key);
        }
    
        long endTime = new Date().getTime();
    
        System.out.println("Key total is " + total + " and loop took " + (endTime-startTime) + "ms.");
    
    }
    
    
    public static void timeValues(Map<String, Integer> test) {
        long startTime = new Date().getTime();
        
        long total = 0;
        for (int value: test.values()) {
            total += value;
        }
        
        long endTime = new Date().getTime();
        
        System.out.println("Value total is " + total + " and loop took " + (endTime-startTime) + "ms.");
        
    }
    
}
