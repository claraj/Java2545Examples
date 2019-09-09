package week4_list_data_structure;
import java.util.*;

public class Speed {

    public static void main(String[] args) {

        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList2 = new LinkedList<>();
        List<Integer> arrayList2 = new ArrayList<>();

        System.out.print("Generating 1 million random numbers...");
        Random rnd = new Random();

        int size = 100000;

        for (int x = 0 ; x < size ; x++) {
            int random = rnd.nextInt(1000);
            linkedList.add(random);
            arrayList.add(random);
            linkedList2.add(random);
            arrayList2.add(random);

            if (x % 100000 == 0) {
                System.out.print(".");   //progress monitor :)
            }
        }

        System.out.println("...done. Created LinkedList and ArrayList containing same data");


        /* An example of LinkedList being faster than ArrayList */

        System.out.println();

        System.out.println("Testing ArrayList. Please wait...");

        long start = System.currentTimeMillis();

        for (int x = 0 ; x < arrayList.size() ; x++) {
            arrayList.remove(0);
        }


        long end = System.currentTimeMillis();

        System.out.println("time taken to remove items one by one from start of ArrayList  = " + (end - start) + "ms");

        // About 7 seconds on my computer.

        System.out.println("Testing LinkedList. Please wait...");

        start = System.currentTimeMillis();

        for (int x = 0 ; x < linkedList.size() ; x++) {
            linkedList.remove(0);
        }

        end = System.currentTimeMillis();

        System.out.println("time taken to remove items one by one from start of LinkedList  = " + (end - start) + "ms");

        // About 10 milliseconds.  Almost a thousand times as fast!




        // Remember that this compares one of the slowest operations on ArrayList vs. one of the fastest operations LinkedList can do.


        System.out.println();


        /* An example of ArrayList being slower than LinkedList - adding data at the start */

        System.out.println("Testing ArrayList. Please wait...");

        int additions = 100000;

        start = System.currentTimeMillis();

        for (int x = 0 ; x < additions ; x++) {
            arrayList.add(7, 8);  //add near the start
        }

        end = System.currentTimeMillis();

        System.out.println("Time taken to add elements to the start of ArrayList  = " + (end - start) + "ms");

        // 2 seconds on my computer.

        System.out.println("Testing LinkedList. Please wait...");

        start = System.currentTimeMillis();

        for (int x = 0 ; x < additions ; x++) {
            linkedList.add(8, 8);  // add near the start
        }

        end = System.currentTimeMillis();

        System.out.println("Time taken to add elements to the start of LinkedList  = " + (end - start) + "ms");

        // 5 milliseconds on my computer. Much faster!

        System.out.println();



        /* An example of ArrayList being faster than LinkedList - getting data  */

        System.out.println("Testing ArrayList. Please wait...");

        start = System.currentTimeMillis();

        long total = 0;
        for (int x = 0 ; x < arrayList2.size() ; x++) {
            total += arrayList2.get(x);
        }

        System.out.println("Total of all numbers in ArrayList = " + total);

        end = System.currentTimeMillis();

        System.out.println("time taken to sum elements in ArrayList with a regular for loop = " + (end - start) + "ms");

        // 2 milliseconds on my computer.

        System.out.println("Testing LinkedList. Please wait...");

        start = System.currentTimeMillis();

        total = 0;
        for (int x = 0 ; x < linkedList2.size() ; x++) {
            total += linkedList2.get(x);
        }

        end = System.currentTimeMillis();

        System.out.println("time taken to sum elements in LinkedList with a regular for loop = " + (end - start) + "ms");

        // 13 seconds on my computer; each element has to be fetched by counting along list nodes.

        System.out.println();


        /* Not the last word on looping over lists! Replace the regular for with a for each */

        System.out.println("Testing ArrayList. Please wait...");

        start = System.currentTimeMillis();

        total = 0;
        for (Integer anArrayList2 : arrayList2) {
            total += anArrayList2;
        }

        System.out.println("Total of all numbers in ArrayList = " + total);

        end = System.currentTimeMillis();

        System.out.println("time taken to sum elements in ArrayList with a for each loop = " + (end - start) + "ms");

        // 17 milliseconds on my computer - why slower?

        System.out.println("Testing LinkedList. Please wait...");

        start = System.currentTimeMillis();

        total = 0;
        for (Integer aLinkedList2 : linkedList2) {
            total += aLinkedList2;
        }

        end = System.currentTimeMillis();

        System.out.println("time taken to sum elements in LinkedList with a for each loop = " + (end - start) + "ms");

        // 3 ms seconds on my computer; comparable to regular for sum over ArrayList.



        System.out.println();


        /* An example of ArrayList being faster than LinkedList - adding data at the end */

        System.out.println("Testing ArrayList. Please wait...");

        additions = 10000000;

        start = System.currentTimeMillis();

        for (int x = 0 ; x < additions ; x++) {
            arrayList.add(9);  //add at the end
        }

        end = System.currentTimeMillis();

        System.out.println("Time taken to add elements to the end of ArrayList  = " + (end - start) + "ms");

        // 200 milliseconds on my computer.

        System.out.println("Testing LinkedList. Please wait...");

        start = System.currentTimeMillis();

        for (int x = 0 ; x < additions ; x++) {
            linkedList.add(9);  // add at the end
        }

        end = System.currentTimeMillis();

        System.out.println("Time taken to add elements to the end of LinkedList  = " + (end - start) + "ms");

        // 4 seconds on my computer. Overhead of creating new node for new item.


    }
}