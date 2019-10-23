package week7_first_classes;

import java.util.Date;

/**
 * Created by clara on 10/23/19.
 */
public class DateObjects {
    
    public static void main(String[] args) {
        
        // A Date objects represents a point in time
        
        // Date is a class, so can create date objects like this,
        Date now = new Date();   // Defaults to representing right now
        System.out.println(now);  // Example format: "Wed Oct 23 10:41:28 CDT 2019"
        
    }
}
