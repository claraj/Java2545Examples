package week7_inheritance_abstract.CD_and_LP_no_inheritance;

import java.util.ArrayList;

/**
 * Record Store admin class - testing our CD and LP classes
 */
public class RecordStore {

    public static void main(String[] args) {

        //Create some example CDs and add them to an inventory list
        ArrayList<CD> cdInventory = new ArrayList<CD>();
        CD testCD1 = new CD("Beyonce", "Lemonade", 9.99);
        CD testCD2 = new CD("Bob Dylan", "Basement Tapes", 6.99);

        cdInventory.add(testCD1);
        cdInventory.add(testCD2);

        //And some example LPs and add them to an inventory list
        ArrayList<LP> lpInventory = new ArrayList<LP>();
        LP testLP1 = new LP("Michael Jackson", "Thriller", 4, 9.99);
        LP testLP2 = new LP("Replacements", "Hootenanny", 3, 7.99);

        lpInventory.add(testLP1);
        lpInventory.add(testLP2);

        System.out.println("All LPs in the inventory:");
        for (LP lp : lpInventory) {
            System.out.println(lp);
        }

        System.out.println("All CDs in the inventory");
        for (CD cd : cdInventory) {
            System.out.println(cd);
        }

        //TODO – add code to search for an album in all of the inventory, both CDs and LPs

    }
}
