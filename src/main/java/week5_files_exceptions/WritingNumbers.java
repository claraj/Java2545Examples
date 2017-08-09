package week5_files_exceptions;

/**
 * Created by admin on 8/18/16.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WritingNumbers {

    public static void main(String[] args) throws IOException {

        FileWriter writer = new FileWriter("numbers.txt");
        BufferedWriter bufWriter = new BufferedWriter(writer);

        int data1 = 67;
        int data2 = 65;
        int data3 = 84;

        //What does this write to the file numbers.txt? Is it what you expected?
        bufWriter.write(data1);
        bufWriter.write(data2);
        bufWriter.write(data3);

        //Always close files when you are done working with them.
        bufWriter.close();

    }
}

