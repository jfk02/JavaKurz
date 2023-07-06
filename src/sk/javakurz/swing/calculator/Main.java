package sk.javakurz.swing.calculator;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        try {
            NimbusLookAndFeel nimbusLookAndFeel = new NimbusLookAndFeel();
            UIManager.setLookAndFeel(nimbusLookAndFeel);
            nimbusLookAndFeel.getDefaults().put("defaultFont", new Font("Arial", Font.PLAIN, 24));
        } catch (Exception e) {
            System.err.println("Nimbus is not available");
        }

        JFrame frame = new JFrame("MyCalculator");
        frame.setContentPane(new MyCalculator().getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 450);
        frame.setMinimumSize(new Dimension(350, 450));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
