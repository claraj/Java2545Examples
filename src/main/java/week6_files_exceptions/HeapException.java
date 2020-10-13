package week6_files_exceptions;

import java.util.ArrayList;
import java.util.List;

public class HeapException {
    public static void main(String[] args) {

        // This program will crash after a 10-30 seconds with an OutOfMemory error,
        // HeapException. Eventually the ArrayList gets so large the storage
        // space allocated to run this program in is used up.
        List<String> lotsOfStrings = new ArrayList<>();
        while (true) {
            lotsOfStrings.add("Hello!");
        }
    }
}
