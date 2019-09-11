package week4_list_data_structure;

import java.util.ArrayList;
import java.util.List;

import static input.InputUtils.positiveDoubleInput;

/**
 * Created by clara on 2019-09-10.
 */
public class CountIncidences {
    
    public static void main(String[] args) {
    
        List<Double> speeds = new ArrayList<>();
    
        int totalHours = 12;
        
        for (int hour = 0; hour < totalHours; hour++) {
            double speed = positiveDoubleInput("Enter the internet speed for hour " + hour);
            speeds.add(speed);
        }
    
        System.out.println("All the speeds are:");
    
        for (int hour = 0; hour < speeds.size(); hour++) {
            double speed = speeds.get(hour);
            System.out.printf("Hour: %d  Speed %.2f\n", hour, speed);
        }
        
        // Count the number of times the speed was 0
    
        int zeroCount = 0;
        
        for (double speed: speeds) {
            if (speed == 0) {
                zeroCount++;
            }
        }
        
        System.out.println("Number of times speed was 0 (no connection) : " + zeroCount);
        
        
        // Remove all zeros
        while (speeds.contains(0.0)) {
            speeds.remove(0.0);
        }
    
        /* Questions:
           - Why remove 0.0 instead of 0?
           - Why is a while loop used instead of a for loop?
         */
        
        System.out.println(speeds);
    }
}
