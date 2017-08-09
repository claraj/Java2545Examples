package week1_variables_if_else;

/**
 * Created by admin on 8/16/16.
 */
public class NumberStringConversions {

    public static void main(String[] args) {

        //To convert an int variable to a String

        int anInt = 6;

        String stringFromInt = Integer.toString(anInt);

        System.out.println("numberString = " + stringFromInt);

        //Or, a hack :)

        String stringFromIntAnotherWAy = "" + anInt;  //empty String plus number - Java will convert the int to a String and join the two together

        System.out.println("stringFromIntAnotherWAy = " + stringFromIntAnotherWAy);


        //To convert a String to an int

        String intString = "98765";  // A String that represents a int.

        int intFromString = Integer.parseInt(intString);
        // Warning! Your program will crash if the String can't be interpreted as an int number. So Strings like "123.45" or "Ten" will produce an error.

        System.out.println("intFromString = " + intFromString);


        //To convert double  variable to a String

        double aDouble = 12.34;

        String stringFromDouble = Double.toString(aDouble);

        System.out.println("stringFromDouble = " + stringFromDouble);

        //Or, a hack :)

        String stringFromDoubleAnotherWay = "" + aDouble;  //empty String plus number - Java will convert the double to a String and join the two together

        System.out.println("stringFromDoubleAnotherWay = " + stringFromDoubleAnotherWay);


        //To convert a String to a double

        String doubleString = "123.45";  // A String that represents a double.

        double doubleFromString = Double.parseDouble(doubleString);  // Warning! Your program will crash if the String can't be interpreted as a number.

        System.out.println("doubleFromString = " + doubleFromString);



    }

}
