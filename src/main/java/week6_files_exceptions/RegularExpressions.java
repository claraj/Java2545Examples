package week6_files_exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CheckedOutputStream;

/**
 * Created by clara on 10/9/19.
 */
public class RegularExpressions {
    
    public static void main(String[] args) {
        
        String testString = "The Java class is ITEC 2545 and it is in room 3050.";
        String regexPattern = "\\d+";   //Match at least 1 number
        
        // Create a pattern from the regex string
        Pattern pattern = Pattern.compile(regexPattern);
        // Make a matcher, based off this pattern, to examine the testString
        Matcher matcher = pattern.matcher(testString);
        
        if (matcher.find()) {
            String code = matcher.group();
            System.out.println("The class code is " + code);
            int codeInt = Integer.parseInt(code);
            System.out.println("Class code, as integer, is " + codeInt);
        }
        
        if (matcher.find()) {
            String room = matcher.group();
            System.out.println("The room number is " + room);
            int roomInt = Integer.parseInt(room);
            System.out.println("Room number, as integer, is " + roomInt);
        }
 
        // Alternative: could also also loop over all the matches
//        while (matcher.find()) {
//            System.out.println(matcher.group());
//        }
        
        
        
    }
}
