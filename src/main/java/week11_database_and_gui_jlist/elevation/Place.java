package week11_database_and_gui_jlist.elevation;

public class Place {
    
    private String name;
    private double elevation;
    
    Place(String n, double e) {
        name = n;
        elevation = e;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getElevation() {
        return elevation;
    }
    
    public void setElevation(double elevation) {
        this.elevation = elevation;
    }
    
    @Override
    public String toString() {
        return "Place: " + name + " is at elevation " + elevation + " meters";
    }
    
}

