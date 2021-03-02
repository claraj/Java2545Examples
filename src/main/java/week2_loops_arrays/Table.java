package week2_loops_arrays;

/*
 * Using string formatting to display data in a table */

public class Table {
    public static void main(String[] args) {

        String[] classCodes = {"ITEC 2545", "ITEC 2560", "ITEC 2505", "ITEC 2905"};
        String[] names = {"Java", "Web", "C#", "Capstone"};
        int[] credits = {6, 6, 6, 4};

        String headerFormatTemplate = "%-20s %-20s %-20s\n";

        System.out.printf(headerFormatTemplate, "Class Code", "Class Name", "Credits");

        for (int x = 0; x < classCodes.length; x++) {
            String classCode = classCodes[x];
            String name = names[x];
            int credit = credits[x];

            // %-20s means replace with a String, left-aligned within 20 spaces
            // %20d means replace with an integer, right-aligned within 20 spaces
            // if you omit the - for example %20s then the data will be right-aligned

            String formatTemplate = "%-20s %-20s %-20d\n";
            System.out.printf(formatTemplate, classCode, name, credit);
        }

    }
}
