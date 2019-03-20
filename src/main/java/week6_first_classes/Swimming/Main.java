package week6_first_classes.Swimming;

public class Main {

    public static void main(String[] args) {

        Pool como = new Pool("Como Park", 25);
        Pool ymca = new Pool("YMCA Downtown", 20);

        // TODO create a new pool with name "Edina",
        //  length 50

        Pool edina = new Pool("Edina", 50);

        double totalDistance = como.distanceForLaps(5);
        System.out.println(totalDistance);

        // TODO What's the total distance for swimming
        //  12 laps in the Edina pool?

        double total12LapsEdina = edina.distanceForLaps(12);
        System.out.println(total12LapsEdina);

        System.out.println(ymca);
        System.out.println(edina);

    }

}