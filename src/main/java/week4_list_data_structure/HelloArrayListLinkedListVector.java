package week4_list_data_structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Created by clara on 2019-09-09.
 */
public class HelloArrayListLinkedListVector {
    
    public static void main(String[] args) {
        
        /* The three types of Lists in Java - ArrayList, LinkedList and Vector,
        are all created and used in the same way. However, they work differently
        internally. The best one to choose depends on what the list will be used for.
         */
        
        List<String> vector = new Vector<>();
        vector.add("Hello");
        vector.add("World");
        for (String s: vector) {
            System.out.println(s);
        }
    
    
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");
        arrayList.add("World");
        for (String s: arrayList) {
            System.out.println(s);
        }
    
    
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Hello");
        linkedList.add("World");
        for (String s: linkedList) {
            System.out.println(s);
        }
    
    
    
    
    }
    
}
