package week12_database_and_gui_jtable.bird_default_table.ide_jtable.ide_jtable_default;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by clara on 4/18/18.
 */
public class Main {
    public static void main(String[] args) {
    
        Map<String, String> languages = new HashMap<>();
        languages.put("Swift", "XCode");
        languages.put("Java", "IntelliJ");
        languages.put("Python", "PyCharm");
        
        IdeTableGUI gui = new IdeTableGUI(languages);
    }
}

