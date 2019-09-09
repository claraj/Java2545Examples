package week6_files_exceptions;

/**
 * Created by clara on 9/1/17.
 */
public class TimingExceptions {
    
    public static void main(String[] args) {
        
        
        // A basic way of measuring time taken for execution.
        // Code profiling is a more sophisticated way to time parts of your code,
        // but this gives us some rough figures
        
        int repeats = 10000000;
    
        System.out.println("Repeat each task " + repeats + " times.");
        
        long start = System.currentTimeMillis();
        int totalChars = 0;
        for (int x = 0 ; x < repeats ; x++) {
            totalChars += countCharactersException(null);
        }
        long end = System.currentTimeMillis();
        
        long time = end-start;
        System.out.println("Total chars:" + totalChars);
        System.out.println("Time taken for a null String, with exception handling: " + time);  // 521 ms, about half a second on my computer
    
    
        start = System.currentTimeMillis();
        totalChars = 0;
        for (int x = 0 ; x < repeats ; x++) {
            totalChars += countCharactersNullCheck(null);
        }
        end = System.currentTimeMillis();
    
        time = end-start;
        System.out.println("Total chars:" + totalChars);
        System.out.println("Time taken for a null String, with a null check, " + time);  // 27 ms, twenty times faster than exception handling
    
    
        // What about calling the code with non-null Strings?
    
        start = System.currentTimeMillis();
        totalChars = 0;
        
        for (int x = 0 ; x < repeats ; x++) {
            totalChars += countCharactersException("pizza");
        }
        end = System.currentTimeMillis();
    
        time = end - start;
        System.out.println("Total chars:" + totalChars);
        System.out.println("Time taken for a non-null String, with exception handling, " + time);  // 29 ms, about 1 second on my computer
    
    
        start = System.currentTimeMillis();
        totalChars = 0;
        for (int x = 0 ; x < repeats ; x++) {
            totalChars += countCharactersNullCheck("pizza");
        }
        end = System.currentTimeMillis();
    
        time = end - start;
        System.out.println("Total chars:" + totalChars);
        System.out.println("Time taken for a non-null String, with a null check, " + time);  // 40 ms - about 30% slower than the exception handling approach
    }
    
    
    public static int countCharactersException(String str) {
        try {
            return str.length();
        } catch (NullPointerException npe) {
            return 0;
        }
    }
    
    
    public static int countCharactersNullCheck(String str) {
        if (str == null) {
            return 0;
        }
        return str.length();
    }
    
}
