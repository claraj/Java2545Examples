package week4_data_structures;

import java.util.LinkedList;

/**
 * Browser history as a stack
 */
public class WebsiteHistory {

    public static void main(String[] args) {

        LinkedList<String> history = new LinkedList();

        //Visit google then buzzfeed then youtube then minneapolis.edu
        history.push("www.google.com");
        history.push("www.buzzfeed.com");
        history.push("www.youtube.com");
        history.push("www.minneapolis.edu");

        // Which sites will you see, in order, when the back button is pressed?
        while (! history.isEmpty() ) {
            System.out.println(history.pop());
        }

    }
}
