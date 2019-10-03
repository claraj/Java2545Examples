package week10_extra_gui_examples.open_web_browser_from_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;

/**
 * Created by Clara on 5/10/17.
 */
public class LinksGUI extends JFrame {

    private JPanel mainPanel;
    private JLabel urlText;

    public static void main(String[] args) {
        LinksGUI gui = new LinksGUI();
    }


    LinksGUI() {
        setContentPane(mainPanel);
        pack();
        setSize(new Dimension(350, 100));
        this.setVisible(true);

        urlText.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                String url = urlText.getText();

                try{
                    URI uri = new URI(url);
                    if (Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().browse(uri);
                    } else {
                        JOptionPane.showMessageDialog(LinksGUI.this, "Sorry, can't figure out your web browser");
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(LinksGUI.this, "That doesn't seem to be a valid URL.");
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
