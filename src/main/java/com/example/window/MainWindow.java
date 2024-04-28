package com.example.window;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    private JFrame frame;

    public MainWindow(MainPanel mainPanel) {
        EventQueue.invokeLater(() -> {
            frame = new JFrame("Clicker");
            frame.setSize(350, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.add(mainPanel);
            frame.setVisible(true);
        });
    }
}
