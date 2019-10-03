package week10_extra_gui_examples.image_in_jtable;

/**
 * Created by clara on 6/5/19.
 */
public class Animal {
    
    private String name;
    private String imageFile;
    
    public Animal(String name, String imageFile) {
        this.name = name;
        this.imageFile = imageFile;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getImageFile() {
        return imageFile;
    }
    
    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }
    
    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", imageFile='" + imageFile + '\'' +
                '}';
    }
}
