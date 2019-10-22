package week7_first_classes.Swimming2;

/**
 * Created by clara on 10/22/19.
 */
public class Main {
    
    public static void main(String[] args) {
        
        Pool ymca = new Pool("YMCA Downtown Minneapolis", 25, true);
        System.out.println(ymca);
        
        System.out.println("" + ymca.distanceForLaps(6));
        
        Pool edina = new Pool("Edina", 50, true);
        System.out.println("Can swim in Edina pool in winter? " + edina.canSwimInWinter());
        
        double totalFor12Laps = edina.distanceForLaps(12);
        System.out.println("Swimming 12 laps of the Edina pool is this distance:" + totalFor12Laps);
        
        Pool comoPark = new Pool("Como Park", 25, false);
        System.out.println("Can swim at como in winter? " + comoPark.canSwimInWinter());
        System.out.println(comoPark);
        
        
    }
    
}
