package week5_files_exceptions;

/**
 * Created by admin on 8/18/16.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writing {

    public static void main(String[] args) throws IOException {

        // FileWriter can open, close a file, and write text to the file
        //This line opens a file called hello.txt for writing
        //If hello.txt doesn't exist, it will be created
        //If hello.txt already exists, then it will be erased and overwritten!
        FileWriter writer = new FileWriter("hello.txt");

        // BufferedWriter 'wraps' the FileWriter and handles file IO in the
        // background, so slow file IO operations don't slow down your program
        BufferedWriter bufWriter = new BufferedWriter(writer);

        // Use the BufferedWriter to write Strings to the file
        bufWriter.write("Hello\n");
        bufWriter.write("Data here\n");
        bufWriter.write("Goodbye\n");

        //Always close files when you are done working with them.
        //Or all of the data you think you've written will be lost!!
        bufWriter.close();

    }
}

