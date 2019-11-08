package week11_database_and_gui.elevation;

import java.util.List;

/**
 * Created by clara on 4/16/18.
 */

public class Controller {
    
    private PlaceGUI gui;
    private PlaceDB db;
    
    public static void main(String[] args) {
        new Controller().startApp();
    }
    
    private void startApp() {
        db = new PlaceDB();
        
        List<Place> allData = db.fetchAllRecords();
        
        gui = new PlaceGUI(this);
        gui.setListData(allData);
    }
    
    List<Place> getAllData() {
        return db.fetchAllRecords();
    }
    
    String addPlaceToDatabase(Place place) {
        return db.addRecord(place);
    }
    
    void deletePlace(Place place) {
        db.delete(place);
    }
}




