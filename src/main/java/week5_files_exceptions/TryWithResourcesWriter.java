package week5_files_exceptions;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Try with resources - neater code!
 */
public class TryWithResourcesWriter {

    public static void main(String[] args) {

        String filename = "myfile.txt"  ;

        // Open the resource as the try block starts.
        try ( BufferedWriter bufWriter = new BufferedWriter(new FileWriter(filename))) {

            bufWriter.write("Some example data\n");
            bufWriter.write("Some more example data\n");
            bufWriter.close();  //Still need to close file - do all the regular file IO tasks

            //Question: what could go wrong when writing a file?
        }

        //If an exception is thrown, the resource(s) opened in the try statement will be closed
        catch (IOException ioe) {
            System.out.println("Could not open or write to " + filename);
            System.out.println(ioe.toString());
            System.out.println("This code automatically closed the BufferedWriter and FileWriter" +
                    " in the event of an IOException");
            System.out.println("Can do more error handling here, if needed");
        }
    }
}

