package week7_first_classes;

import java.util.Date;

/**
 * Created by clara on 10/23/19.
 */
public class DateObjects {
    
    public static void main(String[] args) {
        
        // A Date objects represents a point in time
        
        // Date is a class, so can create date objects like this,
        Date now = new Date();   // Defaults to representing right now
        System.out.println(now);  // Example format: "Wed Oct 23 10:41:28 CDT 2019"
    
        // Creating objects that have a Date field
    
        ToDoItem waterPlants = new ToDoItem("Water Plants");
        ToDoItem feedCat = new ToDoItem("Feed Cat");
    
        System.out.println("Here are your to do items:");
        System.out.println(waterPlants);
        System.out.println(feedCat);
    }
}


class ToDoItem {
    
    private String text;
    private Date dateCreated;
    
    ToDoItem(String text) {
        this.text = text;
        this.dateCreated = new Date();  // Right now - when the object is created
    }
    
    @Override
    public String toString() {
        return "ToDoItem: " +
                text + ", created at " + dateCreated;
    }
}
