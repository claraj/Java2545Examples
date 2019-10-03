package week10_and_more_gui_jlist_combobox.dog;


public class Dog {
    private String name;
    private double age;       // Age in years
    private boolean isPuppy;

    public Dog(String name, double age, boolean isPuppy) {
        this.name = name;
        this.age = age;
        this.isPuppy = isPuppy;
    }

    @Override
    public String toString(){

        if (isPuppy) {
            return "Puppy's name is " + name + " and age is " + age;
        }

        return "Dog's name is " + name + " and age is " + age;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public boolean isPuppy() {
        return isPuppy;
    }

    public void setPuppy(boolean isPuppy) {
        this.isPuppy = isPuppy;
    }
}

