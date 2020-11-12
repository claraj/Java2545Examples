package week11_database_and_gui.elevation;

import java.util.List;

/**
 * Manages interactions between GUI and DB
 */

public class Controller {

    private static final String DB_CONNECTION_URL = "jdbc:sqlite:places.sqlite";     //Connection string – where's the database?

    // Fields to represent the GUI and Database Objects
    private PlaceGUI gui;
    private PlaceDB db;

    public static void main(String[] args) {
        new Controller().startApp();
    }

    private void startApp() {

        db = new PlaceDB(DB_CONNECTION_URL);

        List<Place> allData = db.fetchAllRecords();

        gui = new PlaceGUI(this);

    }
    
    List<Place> getAllData() {
        return db.fetchAllRecords();
    }

    boolean addPlaceToDatabase(Place place) {
        return db.addRecord(place);
    }
    
    void deletePlace(Place place) {
        db.deleteRecord(place);
    }

}




