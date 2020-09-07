package week4_list_data_structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static input.InputUtils.*;

public class GuestList {
    public static void main(String[] args) {

        List<String> guestList = new ArrayList<>();

        // Collect names and add to guest list

        while (true) {
            String name = stringInput("Enter name of guest or enter to quit");

            if (name.isEmpty()) {  // if user presses enter, name will be an empty string
                break;
            }

            if (containsIgnoresCase(guestList, name)) {    // ignore duplicates
                System.out.println("You already added " + name);
            } else {
                System.out.println("Adding " + name + " to list.");
                guestList.add(name);
            }
        }

        Collections.sort(guestList); // sort alphabetically

        printGuestNames(guestList);

        // Remove guests from list if needed

        while (yesNoInput("Do you want to remove any guests?")) {
            System.out.println("Here are all the guests");
            printGuestNames(guestList);

            // Stop the loop if there are no more guests to remove
            if (guestList.isEmpty()) {
                System.out.println("There are no more guests to remove");
                break;
            }

            int index = positiveIntInput("Enter the number of the guest to remove");
            index--;   // the guests are printed in a 1-based list, so 1, 2, 3 for three guests. Subtract 1 to get 0-based index
            if (index < guestList.size()) {   // verify index is in range to avoid crash
                String removedGuest = guestList.remove(index);
                System.out.println("Removed guest " + removedGuest);
            } else {
                System.out.println("Error - please enter a valid number of a guest");
            }
        }

        printGuestNames(guestList);

        System.out.println("The number of guests in the guest list is " + guestList.size());

        selectPrizeWinner(guestList);
    }

    public static void selectPrizeWinner(List<String> guests) {

        if (guests.isEmpty()) {
            System.out.println("Warning - no guests - no-one to win the prize");
            return;
        }

        Random rng = new Random();
        int randomGuestIndex = rng.nextInt(guests.size());  // 0, 1, 2, 3

        String prizeWinner = guests.get(randomGuestIndex);

        System.out.println("Guest number " + (randomGuestIndex + 1) + " "
                + prizeWinner + " wins a prize!");
    }


    public static void printGuestNames(List<String> guests) {

        System.out.println("Your guest list is: \n");

        if (guests.isEmpty()) {
            System.out.println("There are no guests in the list.");
        } else {
            for (int i = 0; i < guests.size(); i++) {
                System.out.println((i + 1) + ": " + guests.get(i));
            }
        }
    }

    public static boolean containsIgnoresCase(List<String> list, String data) {
        for (String item : list) {
            if (item.equalsIgnoreCase(data)) {
                return true;
            }
        }
        return false;
    }
}
