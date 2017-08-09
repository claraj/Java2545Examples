package week9_and_more_gui_jlist_combobox.lake_run_gui;

import java.io.*;
import java.util.Vector;

/**
 * Serialises (turns object into String) and deserializes (turns String into Object) Lakes to a file.
 * In other words, reads Lake data from a file, and writes Lake data to that file.
 */
public class FileIO {


    //Stores lake data in a file, one line per lake.
    //File is formatted as the lake's name followed by list of times, separated by commas.

    private static String filename = "LAKE_DATA.TXT";
    private static String separator = ",";


    /** Read in data from file, convert to Lake objects, and return. */
    static Vector<Lake> getLakes()  {

        Vector<Lake> allLakes = new Vector<Lake>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String lakeData = reader.readLine();

            while (lakeData != null) {

                Lake l = parseLakeDataIntoLake(lakeData);
                allLakes.add(l);
                lakeData = reader.readLine();
            }

            return allLakes;

        } catch (IOException ioe) {
            System.out.println("Error reading file");    //This will happen the first time the program runs, or if the file is deleted, so could be ok. TODO check for type of IOException and do something different if different type of error.
            return new Vector<>();
        }
    }

    /** Save all of the Lakes in a list to the file.
     * Erases the data currently in the file and replaces with the data in the LinkedList */
     static void saveLakes(Vector<Lake> lakes) {

        //Join name and list of times with commas eg.  "Como,45,56,32,56"

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            for (Lake lake : lakes) {

                String output = lake.getName();

                for (double time : lake.getTimes()) {
                    output += ",";
                    output += time;
                }

                output += "\n";

                writer.write(output);
            }
        }

        catch (IOException ioe) {
            System.out.println("Error writing data");
        }


    }

    static Lake parseLakeDataIntoLake(String data) {

        //Split the String by the separator
        String[] lakeData = data.split(separator);

        if (lakeData.length == 0) {    // This will happen if there are empty lines in the file, which there shouldn't be...
            return null;
        } else {
            String lakeName = lakeData[0];
            Lake lake = new Lake(lakeName);
            for (int i = 1 ; i < lakeData.length ; i++) {
                double time = Double.parseDouble(lakeData[i]);
                lake.addTime(time);
            }
            return lake;
        }
    }

}
