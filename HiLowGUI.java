package HighLow;

import HighLow.Deck;
import HighLow.Hand;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;

public class HiLowGUI extends JFrame{
    private JRadioButton HighRadioButton;
    private JRadioButton InBetwenRadioButton;
    private JRadioButton lowRadioButton;
    private JLabel Result;
    private JLabel HighCard;
    private JLabel LowCard;
    private JButton newCardButton;
    private JPanel Main_Panel;

    private Deck deck=new Deck();
    private Card highCard;
    private Card lowCard;


    public HiLowGUI() {
        setContentPane(Main_Panel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        newCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deck.refill();
                highCard=deck.drawCard();
                lowCard=deck.drawCard();
                if (lowCard.value>highCard.value){
                    lowCard=deck.drawCard();
                }

                HighCard.setText(highCard.toString());
                LowCard.setText(lowCard.toString());


            }
        });
        JRadioButton HighRadioButton=new JRadioButton();
        JRadioButton lowRadioButton=new JRadioButton();
        JRadioButton InBetwenRadioButton=new JRadioButton();





    }


}


