package week5_files_exceptions;

/**
 * Created by clara on 9/1/17.
 */
public class TimingExceptions {
    
    public static void main(String[] args) {
        
        
        // A basic way of measuring time taken for excecution.
        // Code profiling is a more sophisticated way to time parts of your code,
        // but this gives us some rough figures
        
        int repeats = 10000000;
        
        long start = System.currentTimeMillis();
        int totalChars = 0;
        for (int x = 0 ; x < repeats ; x++) {
            totalChars += countCharactersException(null);
        }
        long end = System.currentTimeMillis();
        
        long time = end-start;
        System.out.println("Total chars:" + totalChars);
        System.out.println("Time taken, with exception handling, " + time);  // 973 ms, about 1 second on my computer
    
    
        start = System.currentTimeMillis();
        totalChars = 0;
        for (int x = 0 ; x < repeats ; x++) {
            totalChars += countCharactersNullCheck(null);
        }
        end = System.currentTimeMillis();
    
        time = end-start;
        System.out.println("Total chars:" + totalChars);
        System.out.println("Time taken, with a null check, " + time);  // 9 ms, about a one-hundredths of a second on my computer
    
    
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
