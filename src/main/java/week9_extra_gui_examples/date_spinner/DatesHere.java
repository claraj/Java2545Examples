package week9_extra_gui_examples.date_spinner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by admin on 4/28/16.
 */
public class DatesHere extends JFrame {
    private JSpinner dateSpinner;
    private JPanel panel1;
    private JButton getDateButton;
    private JSpinner rangeOfDatesSpinner;
    private JButton getRestrictedRangeDateButton;

    DatesHere() {

        setContentPane(panel1);
        pack();
        setVisible(true);

        //This date spinner will let user pick any date.

        dateSpinner.setModel(new SpinnerDateModel());

        getDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Date d = (Date)dateSpinner.getModel().getValue();
                System.out.println(d);

            }
        });

        //This date spinner restricts the range of dates
        //Some random dates... Pick a date, between March 10th, 2010 and June 5th, 2015

        Calendar earliestDate = Calendar.getInstance();
        earliestDate.set(2010, Calendar.MARCH, 10);     //Note this is Year, Month, Day

        System.out.println(earliestDate.getTime());

        Calendar latestDate = Calendar.getInstance();
        latestDate.set(2015, Calendar.JUNE, 5);        //Also using constants from the Calendar class for month

        System.out.println(latestDate.getTime());

        rangeOfDatesSpinner.setModel(new SpinnerDateModel(latestDate.getTime(), earliestDate.getTime(), latestDate.getTime(), Calendar.DAY_OF_MONTH));

        getRestrictedRangeDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Date d = (Date)rangeOfDatesSpinner.getModel().getValue();
                System.out.println(d);

            }
        });

    }
}
