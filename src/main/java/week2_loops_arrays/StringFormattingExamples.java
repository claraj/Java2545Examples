package week2_loops_arrays;

/**
 * Created by clara on 2019-08-22.
 */
public class StringFormattingExamples {
    
    public static void main(String[] args) {
        
        // Just a lot of examples of string formatting vs. string concatenation
        
        // Some variables containing data about Java, and this class (2018)
        
        String college = "Minneapolis College";
        String className = "Java Programming";
        String department = "ITEC";
        int classCode = 2545;
        double credits = 6;   // A class can be a non-integer number of credits
        
        double averageGrade = 84.32721;
        
        int students = 24;
        boolean isOnline = false;
        
        // These both print the same message. Which one is easier to write? To read?
        // The Java Programming class has 24 students, average grade of 84.327210. Is it online? false.
        
        System.out.printf("The %s class has %d students, average grade of %f. Is it online? %b.\n",
                className, students, averageGrade, isOnline);
    
        System.out.println("The " + className + " class has " + students + " students, " +
                        "average grade of " + averageGrade + ". Is it online? " + isOnline+ ".");
    
        // Each pair of statements prints the same thing. This program compares using concatenation, using +
        // vs String formatting, using System.out.printf() and % placeholders.
        // Sometimes concatenation is simpler, sometimes string formatting is easier.
    
        
        
        // Minneapolis College has a Java class called Java Programming
        System.out.println(college + " has a Java class called " + className + ".");
        // String formatting. Notice you need the \n at the end of the string if you want the next thing printed on a new line
        System.out.printf("%s has a Java class called %s.\n", college, className);
        
        // Details of the Java class: ITEC 2454: Java Programming. The class is 6.0 credits.
        System.out.println("Details of the Java class: " + department + " " + classCode + ": " + className + ". The class is " + credits + " credits.");
        // Notice the %.1f syntax for the floating point double variable. This prints 6.0
        System.out.printf("Details of the Java class: %s %d: %s. The class is %.1f credits.\n", department, classCode, className, credits);
    
        // In 2018, 24 students took the Java Programming class. Their average grade was 84.32721 percent.
        System.out.println("In 2018, " + students + " students took the " + className + " class. Their average grade was " + averageGrade + " percent.");
        // In this example, %.2f is used to format the averageGrade variable to 2 decimal places.
        
        // In 2018, 24 took the Java Programming class. Their average grade was 84.33 percent
        System.out.printf("In 2018, %s students took the %s class. Their average grade was %.2f percent\n",
                students, className, averageGrade);
        
    
    
    
    }
}
