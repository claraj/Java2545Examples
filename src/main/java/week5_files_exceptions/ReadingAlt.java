package week5_files_exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Read in a file. Assume you've got a file called hello.txt, which you will, if you've run Reader.java.
 */
public class ReadingAlt {

    public static void main(String[] args) throws IOException {

        //Create a FileReader and BufferedReader with one line of code.
        BufferedReader bufReader = new BufferedReader(new FileReader("hello.txt"));

        // Read in the first line...
        String line = bufReader.readLine();

        // If this line is not null, then print it out...
        while (line != null) {
            System.out.println(line);

            // And then read in the next line ...
            line = bufReader.readLine();
        }

        bufReader.close();   //This closes the inner FileReader too
    }
}

