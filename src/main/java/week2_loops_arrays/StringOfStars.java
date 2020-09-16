package week2_loops_arrays;

public class StringOfStars {
    public static void main(String[] args) {
        // Make a string of 100 stars
        String stars = "";
        for (int s = 0; s < 100; s++) {
            stars = stars + "*";
        }
        System.out.println(stars);
    }
}
