package week7_first_classes.Swimming;

public class Pool {

    private String name;
    private double length;

    Pool(String name, double length) {
        this.name = name;
        this.length = length;
    }

    public double distanceForLaps(int laps) {
        return laps * length;
    }

    @Override
    public String toString(){
        return name + " pool is " + length + " meters long.";
    }
}



