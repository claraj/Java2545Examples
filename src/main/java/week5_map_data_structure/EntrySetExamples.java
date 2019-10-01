package week5_map_data_structure;

import javax.swing.*;
import java.util.Map;
import java.util.Set;

/**
 * Created by clara on 2019-10-01.
 */
public class EntrySetExamples {
    
    public static void main(String[] args) {
        
        // exampleMap is a HashMap
        Map<String, Integer> exampleMap = Map.of("a", 1, "b", 2);
        
        for (Map.Entry<String, Integer> keyValuePair :  exampleMap.entrySet()) {
            // Loop repeats once per key, or once per key-value pair
            System.out.println(keyValuePair);
            System.out.println(keyValuePair.getKey());
            System.out.println(keyValuePair.getValue());
        }
     
        
        Map<String, Boolean> classroomHasPCs = Map.of("T.3010", true, "T.3020", true, "T.3030", true, "T.3040", false);
        
        for (Map.Entry<String, Boolean> oneClassRoomAndWhetherItHasPCs: classroomHasPCs.entrySet() ) {
            String classroom = oneClassRoomAndWhetherItHasPCs.getKey();
            boolean hasPCs = oneClassRoomAndWhetherItHasPCs.getValue();
            System.out.println("The classroom is " + classroom + ". Does it have PCs? " + hasPCs);
        }
        
        for (String classroom: classroomHasPCs.keySet()) {
            boolean hasPCs = classroomHasPCs.get(classroom);
            System.out.println("The classroom is " + classroom + ". Does it have PCs? " + hasPCs);
        }
        
    }
    
}
