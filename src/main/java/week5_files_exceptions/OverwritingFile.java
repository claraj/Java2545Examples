package week5_files_exceptions;

/**
 * Created by admin on 8/18/16.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OverwritingFile {

    public static void main(String[] args) throws IOException {

        // Create and open hello.txt for writing
        FileWriter writer = new FileWriter("hello.txt");
        // Wrap FileWriter in BufferedWriter
        BufferedWriter bufWriter = new BufferedWriter(writer);

        //Write some Strings..
        bufWriter.write("Hello\n");
        bufWriter.write("Data here\n");
        bufWriter.write("Goodbye\n");

        //Always close your file! Closing the BufferedWriter will also close
        //the FileWriter that it wraps and close hello.txt.
        bufWriter.close();

        // If you want to access hello.txt again, you need to create an new
        // BufferedWriter and FileWriter
        // BUT! Since hello.txt already exists, it will be overwritten!
        writer = new FileWriter("hello.txt");
        // Wrap FileWriter in BufferedWriter
        bufWriter = new BufferedWriter(writer);

        //This will overwrite the previous data
        bufWriter.write("This data\n");
        bufWriter.write("overwrites the first set of data.\n");

        //As always, close your files when done writing.
        bufWriter.close();
    }
}

