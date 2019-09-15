package week6_files_exceptions;

/**
 * Created by clara on 9/1/17. First exception handling program
 */
public class HelloException {
    
    public static void main(String[] args) {
        
        // This works fine
        String testString = "Hello Java Students";
        int characters = countCharacters(testString);
        System.out.println("The String '" + testString + "' has " + characters + " characters.");
        
        
        // But what if the string is null?
        String testString2 = null;
        int characters2 = countCharacters(testString2);
        System.out.println("The String '" + testString2 + "' has " + characters2 + " characters.");
        
    }
    
    
    public static int countCharacters(String str) {
        return str.length();
    }
    
}

