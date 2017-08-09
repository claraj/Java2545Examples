package week7_inheritance_abstract.CD_and_LP_and_Album_Constructors;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Record Store admin class - testing our CD and LP classes
 */
public class RecordStore {

    static Scanner stringScanner = new Scanner(System.in);

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

        //SEARCHING
        //Create a master inventory list with all Albums in
        ArrayList<Album> allInventory = new ArrayList<Album>();
        allInventory.addAll(lpInventory);
        allInventory.addAll(cdInventory);

        //Search inventory for any CD or LP that matches a search term
        System.out.println("Enter artist or title to search for. Works for partial artists/titles.");
        String searchString = stringScanner.nextLine();
        searchForAlbum(allInventory, searchString);

        stringScanner.close();
    }



    private static void searchForAlbum(ArrayList<Album> albums, String searchTerm){
        searchTerm = searchTerm.toLowerCase();  //Work in lowercase
        boolean found = false;
        for (Album a : albums) {
            //Check both artist and title for the searchTerm
            if (a.getTitle().toLowerCase().contains(searchTerm) || 	a.getArtist().toLowerCase().contains(searchTerm)){
                found = true;
                System.out.println(a);
            }
        }
        if (!found) {
            System.out.println("No matching albums found that match " + searchTerm);
        }
    }

}
