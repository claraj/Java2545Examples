package week5_files_exceptions;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * TODO better exception handling
 */
public class RandomNumbersInFile {

    public static void main(String args[]) throws IOException {

        String filename = "30_random_numbers.txt";
        // Storing filenames in variables is useful, you typically need to refer to them more than once,
        // and having the filename in a variable saves typing and makes sure it's always spelled correctly.

        //Create BufferedWriter, which wraps a FileWriter
        BufferedWriter bufWriter = new BufferedWriter(new FileWriter(filename));

        Random rnd = new Random();

        //Create write 30 random numbers between 0 and 99, write each one to a line of the file
        for (int r = 0 ; r < 30 ; r++) {
            bufWriter.write(rnd.nextInt(100) + "\n");
        }

        //Close the BufferedWriter. This will aslo close the FileWriter it wraps
        bufWriter.close();

        System.out.println("Created and wrote 30 random numbers to " + filename);

        //Read the file and store all of the random numbers in a list.
        //Create BufferedReader, which wraps a FileReader
        BufferedReader bReader = new BufferedReader(new FileReader(filename));

        ArrayList<Integer> myRandomNumbers = new ArrayList<>();

        //Read in one line...
        String randomNumberFromFile = bReader.readLine();
        //line will be null if there are no lines to read - the end of the file
        //Start a loop to display this line, and then read the next line..
        //But only while line != null
        //So, this loop will read until it gets to the end of the file
        while (randomNumberFromFile != null) {
            //convert the line to
            myRandomNumbers.add(Integer.parseInt(randomNumberFromFile));
            randomNumberFromFile = bReader.readLine();
            //If you wanted to do more complex processing with each line, you could
        }

        System.out.println("Here are the random numbers, read from the file");
        //Here's the data read from the file
        System.out.println(myRandomNumbers);

    }
}