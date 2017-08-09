package week7_inheritance_abstract.Static_Variables_Assignment;

public class Assignment {

    //All assignments are scored out of 50
    //A static variable belongs to the class it is defined in
    //All Assignment objects will share this variable
    protected static double scoredOutOf = 50;

    //Compare to this non-static variable
    //non-static variables are called instance variables
    //each Assignment object has its own copy of each instance variable
    //so each Assignment object has its own points variable, and its own name variable.
    private double points;
    private String name;

    public Assignment(String name, double points) {
        this.name = name;
        this.points = points;
    }

    public double getPercentScore() {
        double percent = points / scoredOutOf * 100;
        return percent;
    }

    public String getName() {
        return name;
    }

    //Also note that this method is static - again, it belongs to the Assignment class
    public static double getScoredOutOf() {
        return scoredOutOf;
    }
}

