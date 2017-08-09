package week1_variables_if_else;

public class StringFormattingExamples {
    
    public static void main(String[] args) {

        //Some example variables

        String eventName = "Minnesota State Fair";
        String slogan = "12 Days of Fun Ending Labor Day!";

        int numberOfRides = 48;
        int daysOfStateFair = 12;

        double stateFairAdmission = 12;
        double priceOfCornDog = 5.25;

        //Some math, to create a few more variables....

        //If I go to the fair every day, and eat a corn dog every day, what will that cost?
        double cornDogAndAdmissionCost = daysOfStateFair * (stateFairAdmission + priceOfCornDog);

        //So I go to the fair every day, and I want to go on all of the rides. How many rides do I need to go on per day?
        int ridesPerDay = numberOfRides / daysOfStateFair;


        //Output some data, using String formatting

        // %s is replaced with a String
        // %d is replaced with an int
        // %f is replaced with a double
        // %.2f is replaced with a double, displayed with 2 decimal places
        // %.5f is replaced with a double, displayed with 5 decimal places

        // Can use as many placeholders as you like. Make sure you have a variable for each placeholder.
        // IntelliJ will check that you've got the right number and types of variables.

        System.out.println(String.format("This program is looking forward to going to the %s", eventName));

        //Notice that the stateFairAdmission variable stores 12, but using %.2f causes it to be displayed as 12.00.
        System.out.println(String.format("It costs %.2f dollars to get into the %s. A corn dog costs %.2f dollars", stateFairAdmission, eventName, priceOfCornDog));

        System.out.println(String.format("If I go to the %s every day and eat a corn dog every day, it will cost a total of %.2f dollars", eventName, cornDogAndAdmissionCost));
        System.out.println(String.format("Or with a dollar sign: $%.2f", cornDogAndAdmissionCost));

        System.out.println(String.format("To go on all of the rides, I need to go on %d rides per day for %d days.", ridesPerDay, daysOfStateFair));

        System.out.println(String.format("\"%s\" is the slogan for the %s", slogan, eventName));

        System.out.println(String.format("According to my variables, the %s has %d days!", eventName, daysOfStateFair));

    }
}
