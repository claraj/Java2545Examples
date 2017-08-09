package week2_loops_arrays;


public class MoreForLoops {

    public static void main(String[] args) {

        //Count from 0, by 2. What's the highest number this loop prints?
        for (int x = 0 ; x < 10 ; x = x + 2) {
            System.out.println(x);
        }

        System.out.println();  //blank line, to see the output of the different loops more easily


        //Count from 0, by 2. What's the highest number this loop prints?
        //Hint - look at the condition. < is different to <=
        for (int x = 0 ; x <= 10 ; x = x + 2) {
            System.out.println(x);
        }


        System.out.println();

        //Count from 10 to 100, by 5s
        for (int x = 10 ; x <= 100 ; x = x + 5) {
            System.out.println(x);
        }

        System.out.println();


        //Count backwards - every time the loop repeats, x is decreased by 1
        for (int x = 5 ; x >= 0 ; x = x - 1) {
            System.out.println(x);
        }

        System.out.println();


        //This loop is the same as the one above. x-- is shorthand for x=x-1
        for (int x = 5 ; x >= 0 ; x-- ) {
            System.out.println(x);
        }




    }

}
