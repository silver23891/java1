package com.lesson8;

import javax.swing.*;
import java.awt.*;

public class VictoryWindow extends JFrame {
    private static final int WINDOW_POS_X = 653;
    private static final int WINDOW_POS_Y = 425;
    private static final int WINDOW_HEIGHT = 100;
    private static final int WINDOW_WIDTH = 200;

    public VictoryWindow(String message) {
        setTitle("Игра завершена");
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(true);

        JLabel label = new JLabel();
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setText(message);

        add(label);
    }
}
