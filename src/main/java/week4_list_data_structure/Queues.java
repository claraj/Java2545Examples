package week4_list_data_structure;

import java.util.LinkedList;
import java.util.Queue;

import static input.InputUtils.stringInput;

/**
 * LinkedList as a Queue - tech support issues queue
 */
public class Queues {


    public static void main(String[] args) {

        Queue<String> techSupportIssuesQueue = new LinkedList<>();

        //Add some issues, in the order received

        techSupportIssuesQueue.add("Jamie needs help changing screen saver");
        techSupportIssuesQueue.add("Alex can't open Microsoft Word");
        techSupportIssuesQueue.add("Sam deleted the entire filesystem");

        // Deal with issues in order received

        while (! techSupportIssuesQueue.isEmpty() ) {
            String issue = techSupportIssuesQueue.remove();
            System.out.println("Description of issue: " + issue);
            stringInput("Press Enter when you have resolved this issue");  //Ignore input, let loop repeat

        }

        System.out.println("All issues have been fixed!");

    }
}
