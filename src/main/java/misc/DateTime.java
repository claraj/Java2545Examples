package misc;

import java.util.Date;

public class DateTime {
    public static void main(String[] args) {

        Date now = new Date();

        // do this when writing to the DB
        long timestamp = now.getTime();
        System.out.println(timestamp);

        Date fromTimeStamp = new Date(1619044517020L);
        System.out.println(fromTimeStamp);


    }
}
