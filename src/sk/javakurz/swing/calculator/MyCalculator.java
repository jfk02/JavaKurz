package sk.javakurz.swing.calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalculator {

    private JPanel panel1;
    private JTextField display;
    private JButton a4Button;
    private JButton a7Button;
    private JButton a1Button;
    private JButton periodButton;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton a0Button;
    private JButton a9Button;
    private JButton plusButton;
    private JButton a6Button;
    private JButton minusButton;
    private JButton a3Button;
    private JButton multiplicationButton;
    private JButton equalButton;
    private JButton divideButton;
    private JButton cButton;

    private String displayText = "";

    public JPanel getPanel1() {
        return panel1;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public MyCalculator() {

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!e.getActionCommand().equals("C")){
                    displayText += displayText.length() < 15 ? e.getActionCommand() : "";
                }else {
                    displayText = "";
                }

                display.setText(displayText);
            }
        };

        a4Button.addActionListener(listener);
        a7Button.addActionListener(listener);
        a1Button.addActionListener(listener);
        periodButton.addActionListener(listener);
        a8Button.addActionListener(listener);
        a5Button.addActionListener(listener);
        a2Button.addActionListener(listener);
        a0Button.addActionListener(listener);
        a9Button.addActionListener(listener);
        plusButton.addActionListener(listener);
        a6Button.addActionListener(listener);
        minusButton.addActionListener(listener);
        a3Button.addActionListener(listener);
        multiplicationButton.addActionListener(listener);
        equalButton.addActionListener(listener);
        divideButton.addActionListener(listener);
        cButton.addActionListener(listener);
    }
}
