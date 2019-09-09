package week4_list_data_structure;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Browser history as a stack
 */
public class WebsiteHistory {

    public static void main(String[] args) {

        Deque<String> history = new LinkedList<>();

        //Visit google then Buzzfeed then Youtube then minneapolis.edu
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
