package week10_and_more_gui_jlist_combobox.vehicles;

/**
 * Created by clara on 10/21/19.
 */


public class Vehicle {
    
    private String name;
    private String make;
    private String model;
    private boolean electric;
    
    public Vehicle(String name, String make, String model, boolean electric) {
        this.name = name;
        this.make = make;
        this.model = model;
        this.electric = electric;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getMake() {
        return make;
    }
    
    public void setMake(String make) {
        this.make = make;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public boolean isElectric() {
        return electric;
    }
    
    public void setElectric(boolean electric) {
        this.electric = electric;
    }
}

