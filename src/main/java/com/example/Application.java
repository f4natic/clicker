package com.example;

import com.example.clicker.Clicker;
import com.example.clicker.KeySequence;
import com.example.listener.ClickerAction;
import com.example.window.MainPanel;
import com.example.window.MainWindow;

public class Application {
    public static void main(String[] args) {
        Clicker clicker = new Clicker(new KeySequence());
        ClickerAction clickerAction = new ClickerAction(clicker);
        MainPanel mainPanel = new MainPanel(clickerAction);
        clicker.setMainPanel(mainPanel);
        new MainWindow(mainPanel);
    }
}
