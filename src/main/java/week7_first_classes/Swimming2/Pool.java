package week7_first_classes.Swimming2;

/**
 * Created by clara on 10/22/19.
 */
public class Pool {
    
    // Variables - every Pool has a copy of these variables
    // Often refer to these class variables as fields
    private String name;
    private double length;
    private boolean isInside;
    
    // Constructor, with extra isInside argument
    public Pool(String name, double length, boolean isInside) {
        this.name = name;
        this.length = length;
        this.isInside = isInside;
    }
    
    public double distanceForLaps(int laps) {
        return laps * length;
    }
    
    public boolean canSwimInWinter() {
        //  if pool is inside, return true, otherwise return false
        return isInside;
    }
    
    @Override  // @Override is an annotation
    public String toString() {
        // Java ternary operator
        String insideString = isInside ? "inside" : "outside";
        return name + " pool is " + length + " meters long. This pool is " + insideString;
    }
    
}
