package ui;

import javax.swing.*;

public class ShowMenu {
    public static void show(String title, JPanel panel){
        JFrame frame = new JFrame(title);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(900, 700);
        frame.setLocation(500, 60);
        frame.setVisible(true);
    }
}
