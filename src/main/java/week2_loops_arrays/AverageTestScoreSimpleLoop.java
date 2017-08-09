package week2_loops_arrays;


import java.util.Scanner;

public class AverageTestScoreSimpleLoop {

    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);


    public static void main(String[] args) {
        int numberOfTests = 5;
        double testScore;
        double testScoreSum = 0.0;
        double testScoreAverage;
        Scanner numberScanner = new Scanner(System.in);

        for (int test = 1 ; test <= numberOfTests ; test++) {
            System.out.println("Enter test score #" + test );
            testScore = numberScanner.nextDouble();
            testScoreSum = testScoreSum + testScore;
        }

        testScoreAverage = testScoreSum / numberOfTests;
        System.out.println("Average score = " + testScoreAverage);


        numberScanner.close();
        stringScanner.close();

    }

}
