package week4_data_structures;


import java.util.ArrayList;

public class PrintArrayList {

    public static void main(String[] args) {

        ArrayList myList = new ArrayList();
        myList.add("Hello");
        myList.add("World");
        myList.add("Says");
        myList.add("This");
        myList.add("List");

        //Print the whole list on one line

        System.out.println(myList);  // prints [Hello, World, Says, This, List]

        //Print list, item by item, one per line
        //Useful if you also need to know which element you are currently working with in the list

        for (int i = 0 ; i < myList.size() ; i++) {
            System.out.println("Item number " + i + " in the ArrayList is " + myList.get(i));
        }

        //Another loop - often a nicer way - the enhanced for loop!

        for (Object ob : myList) {
            System.out.println(ob);
        }




    }

}
