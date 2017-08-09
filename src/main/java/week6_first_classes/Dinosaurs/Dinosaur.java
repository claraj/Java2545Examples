package week6_first_classes.Dinosaurs;


public class Dinosaur {

    String name;

    int oldestFossils; //in millions of years old, so 65 means 65 million years old
    int mostRecentFossils;

    void roar() {
        System.out.println("GRRRR!!!");
    }

    int lifespan() {
        return oldestFossils - mostRecentFossils;
    }


    //Right-click on your class, select 'Generate', select toString to create
    // this method. Edit the String that is returned if desired.
    @Override
    public String toString() {
        return "Dinosaur{" +
                "name='" + name + '\'' +
                ", oldestFossils=" + oldestFossils +
                ", mostRecentFossils=" + mostRecentFossils +
                '}';
    }
}
