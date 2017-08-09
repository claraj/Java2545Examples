package week3_methods;

public class Scope {

    public static void main(String[] args) {

        // This doesn't do anything useful, it's only to demonstrate scope

        for (int x = 1 ; x < 5 ; x++) {
            //The scope of timesTwo is just this for loop
            int timesTwo = x * 2;
            // every time the for loop repeats, timesTwo goes out of scope, and then is created again
        }

        //  System.out.println(timesTwo);  // Uncommenting this line produces an error! timesTwo only exists inside the for loop


        // This version works (if you fix the error on the line above)
        // the timesThree variable is defined outside the loop, and inside the main() method
        // so the scope of timesThree is the whole of the main method, after the line that it is declared on

        int timesThree = 0;

        for (int x = 1 ; x < 5 ; x++ ) {
            timesThree = x * 3;
        }

        System.out.println(timesThree);

        //Notice the String someData defines inside myMethod?

        myMethod();

        // someData only exists inside myMethod. So we can't refer to it from main()

        // Uncommenting this line creates an error
        // System.out.println(someData);   //error - someData variable doesn't exist here

    }

    public static void myMethod() {
        // Variables declared inside methods are only in scope inside that method.
        String someData = "hello";
        //the someData variable disappears as soon as this method ends. It is not accessible from other parts of the code
        System.out.println(someData);
    }
}
