package week7_inheritance_abstract.CD_and_LP_and_Album_Constructors;

/**
 * Represents one LP sold at our second hand record store
 */
public class LP extends Album {

   private int condition;   //1 = barely playable, 5 = mint

    public LP(String artist, String title, int condition, double price) {
        super(artist, title, price);   //Call superclass constructor to set these variables
        this.condition = condition;    //Only need to set the LP-specific condition
    }

    @Override
    public String toString(){
        return "Format = LP, Artist = " + artist + ", Title = " + title + ", " +
                "Condition = " + condition  + ", Price $" + price;
    }
}


