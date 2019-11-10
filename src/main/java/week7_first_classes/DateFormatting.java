package week7_first_classes;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by clara on 11/10/19.
 */
public class DateFormatting {
    
    public static void main(String[] args) {
        
        Date now = new Date();
    
        // Create date formatter using a pattern String. This pattern is month-day-year
        // Find out more about how to build a pattern https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        
        String formattedDate = formatter.format(now);
    
        System.out.println(formattedDate);
        
        
    }
}
