package week10_extra_gui_examples.display_image_from_file;

import javax.swing.*;

/**
 * Created by clara on 4/25/17.
 * Display an image in a JLabel, read from a local file.
 */

public class ImageGUI extends JFrame{
    private JLabel catImage;
    private JPanel containerPanel;

    ImageGUI() {

        setContentPane(containerPanel);

        // Create an ImageIcon from local file. This file is in the root directory of the project.
        // Use *relative* file paths if images will be stored somewhere else.

        ImageIcon catIcon = new ImageIcon("cat.png");   // TODO exception handling for file not found
        catImage.setIcon(catIcon);

        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }



}
