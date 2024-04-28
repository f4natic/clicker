package com.example.listener;

import com.example.clicker.Clicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickerAction implements ActionListener {
    private final Clicker clicker;

    public ClickerAction(Clicker clicker) {
        this.clicker = clicker;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource().getClass().equals(JButton.class)) {
            JButton button = (JButton) actionEvent.getSource();
            if(button.getText().equals("start")) {
                clicker.start();
            }else {
                clicker.stop();
            }
        }
    }
}
