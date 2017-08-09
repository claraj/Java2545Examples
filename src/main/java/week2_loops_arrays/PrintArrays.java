package week2_loops_arrays;


import java.util.Arrays;

public class PrintArrays {

    public static void main(String[] args) {

        // Example int array
        int[] classroomNumbers = { 3010, 3020, 3030, 3040, 3050, 3080 };

        // Try to print array
        System.out.println(classroomNumbers);  // Oh no! What does this print?

        //If you want the array data, use this,
        System.out.println(Arrays.toString(classroomNumbers));

        // You can also use a loop to print all of an array

        for (int x = 0 ; x < classroomNumbers.length; x++) {
            System.out.println(classroomNumbers[x]);
        }

        // Example double array
        double[] quizScores = { 97.6, 86.3, 91.1 };

        //Print quizScores array
        System.out.println(Arrays.toString(quizScores));


        // Print with a loop
        for (int x = 0 ; x < quizScores.length; x++) {
            System.out.println(quizScores[x]);
        }


        // Example String array
        String[] rainbowColors = {"red", "orange", "yellow", "green", "blue", "indigo", "violet"};

        //Print rainbowColors array
        System.out.println(Arrays.toString(rainbowColors));

        for (int x = 0 ; x < rainbowColors.length; x++) {
            System.out.println(rainbowColors[x]);
        }



    }

}
