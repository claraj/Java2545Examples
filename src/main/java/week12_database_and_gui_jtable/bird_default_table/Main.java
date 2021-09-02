package week12_database_and_gui_jtable.bird_default_table;


public class Main {

    private final static String DB_URL = "jdbc:sqlite:birds.sqlite";

    public static void main(String[] args) {

        BirdDatabase db = new BirdDatabase(DB_URL);
        BirdGUI gui = new BirdGUI(db);

    }
}


