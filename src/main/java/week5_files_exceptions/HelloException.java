package week5_files_exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HelloException {

    public static void main(String[] args) {

        String filename = "non_existent_file.txt";

        try {
            //Try to open a file that doesn't exist
            FileReader reader = new FileReader(filename);
            BufferedReader bufReader = new BufferedReader(reader);
            String line = bufReader.readLine();

            while (line != null) {
                System.out.println(line);
                line = bufReader.readLine();
            }
            bufReader.close();

        } catch (IOException ioe) {
            System.out.println("Could not open or read " + filename);
            System.out.println(ioe.toString());
        }
        System.out.println("If the code did not work, the program did not crash");
        System.out.println("The program keeps running so could perhaps ask the user " +
                "to create this file, or specify the file location");
    }
}
