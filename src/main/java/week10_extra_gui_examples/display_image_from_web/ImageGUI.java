package week10_extra_gui_examples.display_image_from_web;

import javax.swing.*;
import java.net.URL;

/**
 * Created by admin on 4/25/17.
 */
public class ImageGUI extends JFrame {

    private JPanel containerPanel;
    private JLabel imageLabel;

    ImageGUI() {

        setContentPane(containerPanel);


        try {
            String javaImgPath = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Java_Topography.png/640px-Java_Topography.png";

            // Create an URL object from your String url
            URL url = new URL(javaImgPath);
            // Create an ImageIcon from this URL
            ImageIcon imgIcon = new ImageIcon(url);
            // And set the label's icon to this image.
            imageLabel.setIcon(imgIcon);

        } catch (Exception e) {
            e.printStackTrace();   // TODO more useful exception handling
        }

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }


}
