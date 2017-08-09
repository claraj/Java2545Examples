package week7_inheritance_abstract.CD_and_LP_and_Album_Constructors;

/**
 * Represents a second-hand CD sold by our record store
 */
public class CD extends Album {


    public CD(String artist, String title, double price) {
       super(artist, title, price);    //Call the Album constructor
    }

    @Override
    public String toString() {
        return "Format = CD, Artist = " + artist + ", Title = " + title + ", Price $" + price;
    }
}

