package week9_and_more_gui_jlist_combobox.lake_run_gui;

import java.util.ArrayList;
import java.util.Collections;

public class Lake {

    public static final double NO_TIMES = -1;
    private String name;
    private ArrayList<Double> times = new ArrayList<Double>();


    public Lake(String name) {
        this.name = name;
    }

    public void addTime(double newTime) {
        times.add(newTime);
    }

    /** Returns fastest time so far, or -1 (NO_TIMES) if no times added */
    public double getFastestTime() {

        if (times == null || times.size() == 0) {
            return NO_TIMES;   //placeholder for no time.
        }
        //Assume the first time is the fastest, compare the others to it
        double fastest = times.get(0);
        for (double t : times) {
            if (t < fastest) {
                fastest = t;
            }
        }
        return fastest;

    }
    
    public String getName() {
        return name;
    }


    /** Convenience method, used by JList to display a list of times.
     Convert LinkedList to array and return it.  */
    public double[] getTimes() {

        Collections.sort(times);    //Sort - best - or lowest - first

        double[] arrayTimes = new double[times.size()];
        for (int t = 0 ; t < times.size() ; t++) {
            arrayTimes[t] = times.get(t);
        }
        return arrayTimes;
    }


    @Override
    public String toString(){
        return getName();
    }
}
