package week5_files_exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Read in a file. Assume you've got a file called hello.txt, which you will, if you've run Reader.java.
 */
public class ReadingConcise {

    public static void main(String[] args) throws IOException {

        // Can combine creating the FileReader and BufferedReader on one line.
        BufferedReader bufReader = new BufferedReader(new FileReader("hello.txt"));

        String line = bufReader.readLine();

        while (line != null) {
            System.out.println(line);
            line = bufReader.readLine();
        }

        bufReader.close();   //This closes the inner FileReader too
    }
}

