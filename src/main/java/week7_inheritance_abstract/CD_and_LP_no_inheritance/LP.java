package week7_inheritance_abstract.CD_and_LP_no_inheritance;

/**
 * Represents one LP sold at our second hand record store
 */
public class LP {

    private String artist;
    private String title;
    private int condition;   //1 = barely playable, 5 = mint
    private double price;

    public LP(String artist, String title, int condition, double price) {
        this.artist = artist;
        this.title = title;
        this.condition = condition;
        this.price = price;
    }

    @Override
    public String toString(){
        return "Format = LP, Artist = " + artist + ", Title = " + title + ", " +
                "Condition = " + condition  + ", Price $" + price;
    }
}


