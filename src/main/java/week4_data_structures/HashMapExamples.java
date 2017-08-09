package week4_data_structures;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Creating and using a HashMap
 */
public class HashMapExamples {

    public static void main(String[] args) {

        //Create a new HashMap
        HashMap h = new HashMap();

        //Add some test data. The class codes are the keys, the class names are the values
        h.put("1100", "Info Tech Concepts");
        h.put("1110", "Info Tech Skills");
        h.put("1150", "Programming Logic");
        h.put("1250", "Windows");
        h.put("1425", "Data Communications");

        //Test some HashMap methods

        System.out.println("Does HashMap contain the key 1100? " + h.containsKey("1100"));

        System.out.println("The value for the key 1150 is " + h.get("1150"));

        System.out.println("Is this HashMap empty? " + h.isEmpty());

        System.out.println("How many key value pairs? " + h.size());

        System.out.println("Is there an entry with the value \"Windows\"? " + h.containsValue("Windows"));

        System.out.println("Delete the 1250 key-value pair, return the value. Value= " + h.remove("1250"));

        System.out.println("Delete a key that doesn't exist, what does this return? " + h.remove("1724"));



        //Want to iterate over the keys? First get a set of all of the keys, then use a for each loop

        System.out.println("\nPrinting out all key-value pairs using a for each loop");

        System.out.println("Get a Set of the keys, and iterate over of that set:\n");



        //How do you print out all of the data - keys and values - in a Hashmap?

        //Creates a set of the keys, and iterate over that

        for ( Object classNumber : h.keySet()) {

            //Use the key to get each value. Repeat for each key.

            System.out.println("Class Number =" + classNumber + " Class Name = " + h.get(classNumber) );

        }



        //The older way of displaying all of the data
        System.out.println("\nDisplaying all data, using an Iterator:\n");

        //You'll see this in older Java code. The For Each loop is relatively new.
        //Using a while loop is more common with an iterator, although you can re-write with a for loop

        Iterator it = h.keySet().iterator();

        while (it.hasNext()) {
            //it.next() is the next key
            String key = (String) it.next();
            System.out.println("Class Number = " + key + " Class Name = " + h.get(key) );
        }



        //Perhaps we just want to display the values.

        System.out.println("\nPrinting out all values using an iterator");

        Collection values = h.values();    //A HashMap returns all of its values in a Collection object

        for (Object value : values) {

            System.out.println(value);

        }


        System.out.println("Question: why can't you get the key from a value?\n");


    }

    }
