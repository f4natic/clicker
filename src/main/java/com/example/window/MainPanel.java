package com.example.window;

import com.example.listener.ClickerAction;

import javax.swing.*;

public class MainPanel extends JPanel {
    private GroupLayout layout;
    private JButton start;
    private JButton stop;
    private JTextField logField;

    public MainPanel(ClickerAction clickerAction) {
        this.layout = new GroupLayout(this);
        setLayout(layout);
        start = new JButton("start");
        start.addActionListener(clickerAction);
        stop = new JButton("stop");
        stop.addActionListener(clickerAction);
        logField = new JTextField();
        logField.setEditable(false); // Запрещаем редактирование текста

        batch();
    }

    // Метод для добавления логов в текстовое поле
    public void appendLog(String log) {
        logField.setText(log); // Добавляем новый лог и переход на новую строку
    }

    private void batch() {
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                        .addComponent(logField)
                        .addGroup(layout.createParallelGroup()
                                .addComponent(start)
                                .addComponent(stop)
                        )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(logField)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(start)
                                .addComponent(stop)
                        )
                )
        );

        layout.linkSize(SwingConstants.VERTICAL, logField, start);
        layout.linkSize(SwingConstants.HORIZONTAL, start, stop);
    }
}
