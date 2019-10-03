package week7_first_classes.tires_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static input.InputUtils.*;

/**
 * Created by clara on 2019-08-23.
 */
public class TireComparison {
    
    public static void main(String[] args) {
        
        System.out.println("Welcome to the Tire Price Comparison Calculator");
        
        List<Tire> tireReports = new ArrayList<>();
        
        do {
            Tire tire = getTireInfo();
            tireReports.add(tire);
        } while (yesNoInput("More tires to add to comparison?"));
        
        Collections.sort(tireReports);
        printReportTable(tireReports);
        
    }
    
    private static Tire getTireInfo() {
        String name = stringInput("What is the name of the tire?");
        double price = positiveDoubleInput("Enter the price of " + name);
        int mileWarranty = positiveIntInput("Enter the number of miles warranty");
        
        return new Tire(name, price, mileWarranty);
    }
    
    private static void printReportTable(List<Tire> tireReports) {
        for (Tire tire: tireReports) {
            System.out.println(tire);
        }
    }
}





