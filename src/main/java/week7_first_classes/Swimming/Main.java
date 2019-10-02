package week7_first_classes.Swimming;

public class Main {

    public static void main(String[] args) {

        Pool como = new Pool("Como Park", 25);
        Pool ymca = new Pool("YMCA Downtown", 20);

        // TODO create a new pool with name "Edina", length 50

        double totalDistance = como.distanceForLaps(5);
        System.out.println(totalDistance);

        // TODO What's the total distance for swimming
        //  12 laps in the Edina pool?

        System.out.println(ymca);

        // TODO print Edina pool info
    }

}


