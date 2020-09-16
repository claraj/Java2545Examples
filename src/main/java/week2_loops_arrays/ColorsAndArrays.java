package week2_loops_arrays;

public class ColorsAndArrays {

    public static void main(String[] args) {

        // Constants - used to access the element of the array with a specific color code
        // it's much easier to use GREEN than remember that element 2 is green
        final int BLACK = 0;
        final int RED = 1;
        final int GREEN = 2;
        final int YELLOW = 3;
        final int BLUE = 4;
        final int MAGENTA = 5;
        final int CYAN = 6;
        final int WHITE = 7;

        final String RESET = "\u001b[0m";

        // Color codes - printing one of these strings causes all the text after it to be in a color
        // These are ANSI color codes

        String[] colors = {
                "\u001b[30m",   // black
                "\u001b[31m",   // red
                "\u001b[32m",   // green
                "\u001b[33m",   // yellow
                "\u001b[34m",   // blue
                "\u001b[35m",   // magenta
                "\u001b[36m",   // cyan
                "\u001b[37m",   // white
        };

        System.out.println(colors[YELLOW] + "this is yellow!");
        System.out.println("This is still yellow");
        System.out.println(RESET);
        System.out.println("Default color");

        // As before, but print text in bold type, and in a color
        String[] boldColors = {
                "\u001b[30;1m",
                "\u001b[31;1m",
                "\u001b[32;1m",
                "\u001b[33;1m",
                "\u001b[34;1m",
                "\u001b[35;1m",
                "\u001b[36;1m",
                "\u001b[37;1m",
        };

        // Testing colors
        for (int x = 0; x < colors.length; x++) {
            System.out.println(colors[x] + "hello!");
        }

        // Testing bold colors
        for (int x = 0; x < boldColors.length; x++) {
            System.out.println(boldColors[x] + "hello!");
        }


        // Using an individual color code
        System.out.println(colors[RED] + "Hello in red!");

        // When a color is set, it will be used for all further output
        System.out.println("hello, still in red!");  // also red!
        // To return to the default color, print a RESET

        System.out.println(RESET + "This is in the default color");

    }
}
