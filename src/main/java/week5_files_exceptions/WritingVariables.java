package week5_files_exceptions;

/**
 * Created by admin on 8/18/16.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WritingVariables{

    public static void main(String[] args) throws IOException {

        //Let's write some variables to a file

        FileWriter writer = new FileWriter("variables.txt");
        BufferedWriter bufWriter = new BufferedWriter(writer);

        int intData = 42;
        double dblData = 987.654;
        String strData = "Java";

        // Use the BufferedWriter to write all the data to the file

        bufWriter.write(intData + "\n");
        bufWriter.write(dblData + "\n");
        bufWriter.write(strData + "\n");

        //Always close files when you are done working with them.
        //Or all of the data you think you've written will be lost!!
        bufWriter.close();

    }
}

