package week6_files_exceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by clara on 2019-09-14.
 */
public class DateParsingException {
    
    public static void main(String[] args) {
    
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
        String dateString = "Aug 20 2019";
    
        try {
            Date date = dateFormat.parse(dateString);
            System.out.println("The date is " + date);
        } catch (ParseException e) {
            System.out.println("Error, the String '" + dateString +
                    "' can't be turned into a date object in the format '" + dateFormat.toPattern() + "'");
        }
    
        String dateString2 = "The twentieth of August, 2019";
    
        try {
            Date date2 = dateFormat.parse(dateString2);
            System.out.println("The date is " + date2);
        } catch (ParseException e) {
            System.out.println("Error, the String '" + dateString2 +
                    "' can't be turned into a date object in the format '" + dateFormat.toPattern() + "'");
        }


    }
}
