package com.example.window;

import com.example.listener.ClickerAction;

import javax.swing.*;

public class MainPanel extends JPanel {
    private GroupLayout layout;
    private JButton start;
    private JButton stop;
    private JTextArea logTextArea;
    private JScrollPane scrollPane;

    public MainPanel(ClickerAction clickerAction) {
        this.layout = new GroupLayout(this);
        setLayout(layout);
        start = new JButton("start");
        start.addActionListener(clickerAction);
        stop = new JButton("stop");
        stop.addActionListener(clickerAction);
        logTextArea = new JTextArea();
        logTextArea.setEditable(false); // Запрещаем редактирование текста

        // Добавляем JTextArea в JScrollPane, чтобы обеспечить прокрутку, если логи будут большими
        scrollPane = new JScrollPane(logTextArea);

        batch();
    }

    // Метод для добавления логов в текстовое поле
    public void appendLog(String log) {
        if(logTextArea.getText().split("\n").length > 100) {
            logTextArea.setText("");
        }
        logTextArea.append(log + "\n"); // Добавляем новый лог и переход на новую строку
    }

    private void batch() {
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                        .addComponent(scrollPane)
                        .addGroup(layout.createParallelGroup()
                                .addComponent(start)
                                .addComponent(stop)
                        )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(scrollPane)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(start)
                                .addComponent(stop)
                        )
                )
        );

        layout.linkSize(SwingConstants.HORIZONTAL, start, stop);
    }
}
