package week5_files_exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HelloExceptionCloseReader {

    public static void main(String[] args) {

        String filename = "non_existent_file.txt";

        BufferedReader bufReader = null;
        try {
            //Try to open a file that doesn't exist
            bufReader = new BufferedReader(new FileReader(filename));
            String line = bufReader.readLine();

            while (line != null) {
                System.out.println(line);
                line = bufReader.readLine();
            }

        } catch (IOException ioe) {
            System.out.println("Could not open or read " + filename);
            System.out.println(ioe);
        }

        finally {

            // Code in a finally block will run whether an exception is thrown or not
            // Typically close resources and tidy up in finally blocks

            //Close the reader, if it was opened
            if (bufReader != null) {
                try {
                    bufReader.close();
                    System.out.println("Closed BufferedReader");
                } catch (IOException ioe) {
                    System.out.println("Error closing BufferedReader " + ioe);
                }
            }
        }

        System.out.println("If the code did not work, the program did not crash");
        System.out.println("The program keeps running so could perhaps ask the user " +
                "to create this file, or specify the file location");
    }
}
