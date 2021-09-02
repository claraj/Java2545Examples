package week5_map_data_structure;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by clara on 2019-10-01. Speed test for various HashMap loops
 */

public class HashMapSpeedTest {

    public static void main(String[] args) {

        System.out.println("Creating a large HashMap, please wait...");
        Map<String, Integer> test = new HashMap<>();

        // Create a GINORMOUS HashMap by adding lots of key-value pairs
        // This might take a while

        int size = 10000000;
        double onePercent = size / 100.0;  // for a basic progress meter
        int percentCounter = 0;

        for (int pair = 0; pair < size; pair++) {
            if (pair % onePercent == 0) {   // displays a dot for every 1% of the key-value pairs created
                System.out.println(percentCounter++ + "%");
            }
            // add random key-value pair to HashMap
            test.put(randomString(), pair);
        }

        System.out.println("Done");
        System.out.println("Generated HashMap of size " + test.size() + " key-value pairs.");

        // Speed tests

        timeValues(test);    // Example run with one million key-value pairs 1233 ms
        timeKeySet(test);    // Example run with one million key-value pairs 1128 ms
        timeEntrySet(test);  // Example run with one million key-value pairs 716 ms

        // Try again...

        timeValues(test);    // Example run with one million key-value pairs 622 ms
        timeKeySet(test);    // Example run with one million key-value pairs 990 ms
        timeEntrySet(test);  // Example run with one million key-value pairs 683 ms


        // Conclusion: it's all about the same. Use whichever loop makes most sense in your program.

    }
    
    public static String randomString() {

        // Create a random UUID value. UUID = Universally unique identifier, a
        // long string that looks something like this, 7a7de706-0bf1-4443-9d08-b44cd510522c
        // Each randomly generated UUID is unique.

        UUID uuid = UUID.randomUUID();
        return uuid.toString();
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
