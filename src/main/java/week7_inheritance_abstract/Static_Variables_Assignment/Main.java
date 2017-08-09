package week7_inheritance_abstract.Static_Variables_Assignment;

public class Main {

    public static void main(String args[]) {

        //Call the static method getScoredOutOf
        //You don't need an Assignment object to call this method because it belongs to the Assignment class
        System.out.println("All assignments are scored out of" + Assignment.getScoredOutOf() );

        Assignment asgt1 = new Assignment("Assignment 1", 45);

        //Call an instance method for asgt1, an Assignment object
        double percentGrade = asgt1.getPercentScore();

        //Call an instance method and a static method - note the difference
        System.out.println("Assignment name + " + asgt1.getName() + " scored out of " + Assignment.getScoredOutOf());

        System.out.println("Percent grade for " + asgt1.getName() + " is " + percentGrade);

        Assignment asgt2 = new Assignment("Assignment 2", 42);
        double percentGrade2 = asgt2.getPercentScore();

        System.out.println("Assignment 2 scored out of " + Assignment.getScoredOutOf());
        System.out.println("Percent grade for Assignment 2 is " + percentGrade2);
    }
}
