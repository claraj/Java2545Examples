package week9_and_more_gui_jlist_combobox.lake_run_gui;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

/**
 * This class provides data for the JTable of best times for each lake.
 */
public class BestTimesTableModel extends AbstractTableModel{

    private Vector<Lake> allLakes;

    // Column names, displayed as table headers in the JTable.
    private String[] columnsNames = { "Lake Name", "Best Time" } ;

    BestTimesTableModel(Vector<Lake> lakes) {
        allLakes = lakes;
    }


    @Override
    public int getRowCount() {

        //How many lakeVector? This gives the number of rows.
        return allLakes.size();
    }

    @Override
    public int getColumnCount() {
        //Two columns - one for name, one for best time.
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        //Column 0 is for the lake's name

        if (columnIndex == 0) {
            return allLakes.get(rowIndex).getName();
        }

        // Column 1 is for that lake's best time, if there is one.
        // Check to make sure there are times for that lake, if not, return a "No times" message.

        if (columnIndex == 1) {
            double time = allLakes.get(rowIndex).getFastestTime();

            if (time == Lake.NO_TIMES) {
                return "No times";
            } else {
                return time;
            }
        }

        return null;
    }


    @Override
    public String getColumnName(int col) {

        return columnsNames[col];

    }
}
