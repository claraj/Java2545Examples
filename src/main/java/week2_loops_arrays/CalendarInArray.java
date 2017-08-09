package week2_loops_arrays;


public class CalendarInArray {

    public static void main(String[] args) {

        // An array with the names of the months in

        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };

        // An array with the names of days of the week in

        String[] daysOfWeek = { "Monday", "Tuesday",  "Wednesday",  "Thursday",  "Friday",  "Saturday", "Sunday" };



        String sentence = "A quick brown fox jumps over the lazy dog";
        char[] characters = sentence.toCharArray();

        //Can loop over the character array and examine each value...

        for (int x = 0 ; x < characters.length ; x++) {
            System.out.println(characters[x]);
            if (characters[x] == 97) {
                System.out.println("This character is an 'a'");
            }
        }

    }
}
