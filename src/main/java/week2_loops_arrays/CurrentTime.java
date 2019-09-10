package week2_loops_arrays;

import java.util.Date;

/**
 * Created by clara on 2019-09-10.
 */
public class CurrentTime {
    
    public static void main(String[] args) throws Exception {
        
        while (true) {
            
            Date d = new Date();
            System.out.println("The date and time is " + d);
            Thread.sleep(1000);   // sleep for 1000 thousandths of a second = 1 second
            
        }
        
    }
}
