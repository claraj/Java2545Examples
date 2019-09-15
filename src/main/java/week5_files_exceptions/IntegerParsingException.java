package week5_files_exceptions;

import static input.InputUtils.stringInput;

/**
 * Created by clara on 2019-09-14.
 */
public class IntegerParsingException {
    
    public static void main(String[] args) {
        
        
        String numberString = "5";
        
        // number will be 5
        // this works because numberString can be converted to an integer
        int number = Integer.parseInt(numberString);
        
        
        // What if the String can't be converted to an integer?
        
        /*
        
        // Uncomment this code to see it crash.
        
        String catString = "cat";
        int catNumber = Integer.parseInt(catString);  // Crash! NumberFormatException
        */
        
        String birdString = "bird";
        try {
            int birdNumber = Integer.parseInt(birdString);  // Crash! NumberFormatException
            System.out.println("Bird number is " + birdNumber);   // This line is never executed
        } catch (NumberFormatException e) {
            System.out.println("Error - " + birdString + " can't be turned into an integer");
        }
       
      
    
        // If you are converting an unknown String to an int,
    
        
        String userNumberString = stringInput("Enter an integer number");   // Try a number, or not a number
        try {
            int userNumber = Integer.parseInt(userNumberString);  // Crash! NumberFormatException
            System.out.println("You entered a valid integer. Your data is  " + userNumber);   // This line is never executed
        } catch (NumberFormatException e) {
            System.out.println("Error - " + userNumberString + " can't be turned into an integer");
        }
    
    
    
    
    }
}
