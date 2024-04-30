package com.example.clicker;

import com.example.window.MainPanel;

import java.awt.*;
import java.util.Map;

public class Clicker {
    private final KeySequence keySequence;
    private final Robot robot;
    private MainPanel mainPanel;
    private Thread thread;
    private boolean running;

    public Clicker(KeySequence keySequence) {
        this.keySequence = keySequence;

        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

    }

    public void start() {
        mainPanel.appendLog("Running Clicker in 10s");
        running = true;
        thread = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                mainPanel.appendLog("Clicker was stopped");
                return;
            }

            mainPanel.appendLog("Clicker is running...");
            while(running) {
                PointerInfo pointerInfo = MouseInfo.getPointerInfo();
                // Получаем координаты курсора
                int x = pointerInfo.getLocation().x;
                int y = pointerInfo.getLocation().y;

                if(x < 50 && y < 50) {
                    running = false;
                    mainPanel.appendLog("Clicker was stopped");
                    return;
                }

                for(Map.Entry<Integer, Integer> keyDelay : keySequence.getKeySequence().entrySet()) {
                    robot.keyPress(keyDelay.getKey());
                    robot.delay(keyDelay.getValue() + keySequence.timeShift());
                    robot.keyRelease(keyDelay.getKey());
                }
                robot.delay(200 + keySequence.timeShift());
            }
        });
        thread.start();
    }

    public void stop() {
        running = false;
        thread.interrupt();
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}
