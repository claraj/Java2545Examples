package week7_inheritance_abstract.CD_and_LP_and_Album_Constructors;

/**
 * Superclass for CD and LP.
 * And any other forms of media we might sell.
 */
public class Album {

    protected String artist;
    protected String title;
    protected double price;

    public Album(String artist, String title, double price) {
        this.artist = artist;
        this.title = title;
        this.price = price;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

