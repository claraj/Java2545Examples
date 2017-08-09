package week5_files_exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Try with resources - neater code!
 */
public class TryWithResourcesReader {

    public static void main(String[] args) {

        String filename = "file_that_doesnt_exist.txt"  ; // Change to a file that does exist?

        // Open the resource as the try block starts.
        try ( BufferedReader bufReader = new BufferedReader(new FileReader(filename))) {

            String line = bufReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufReader.readLine();
            }
            bufReader.close();  //Still need to close file - do all the regular file IO tasks
        }

        //If an exception is thrown, the resource(s) opened in the try statement will be closed
        catch (IOException ioe) {
            System.out.println("Could not open or read " + filename);
            System.out.println(ioe.toString());
            System.out.println("This code automatically closed the reader and bufReader in the event of an IOException");
            System.out.println("Can do more error handling here, if needed");
        }
    }
}

