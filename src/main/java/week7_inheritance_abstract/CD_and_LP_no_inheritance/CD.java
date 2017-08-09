package week7_inheritance_abstract.CD_and_LP_no_inheritance;

/**
 * Represents a second-hand CD sold by our record store
 */
public class CD {
    private String artist;
    private String title;
    private double price;

    public CD(String artist, String title, double price) {
        this.artist = artist;
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Format = CD, Artist = " + artist + ", Title = " + title + ", Price $" + price;
    }
}

