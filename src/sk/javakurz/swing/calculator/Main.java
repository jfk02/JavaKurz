package sk.javakurz.swing.calculator;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

//        try {
//            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            // If Nimbus is not available, you can set the GUI to another look and feel.
//            System.err.println("Nimbus is not available");
//        }

        try {
            NimbusLookAndFeel nimbusLookAndFeel = new NimbusLookAndFeel();
            UIManager.setLookAndFeel(nimbusLookAndFeel);
            nimbusLookAndFeel.getDefaults().put("defaultFont", new Font("Arial Black", Font.PLAIN, 24));
        } catch (Exception e) {
            System.err.println("Nimbus is not available");
        }


        JFrame frame = new JFrame("MyCalculator");
        frame.setContentPane(new MyCalculator().getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setMinimumSize(new Dimension(400, 400));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
