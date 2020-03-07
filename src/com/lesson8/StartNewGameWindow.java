package com.lesson8;

import javax.swing.*;
import java.awt.*;

public class StartNewGameWindow extends JFrame {
    private final GameWindow gameWindow;

    private static final int WINDOW_POS_X = 550;
    private static final int WINDOW_POS_Y = 350;
    private static final int WINDOW_HEIGHT = 455;
    private static final int WINDOW_WIDTH = 407;

    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final int MIN_WIN_LINE = 3;
    private static final int MAX_WIN_LINE = 10;

    private static final String STR_FIELD_SIZE = "Размер поля: ";
    private static final String STR_WIN_LENGTH = "Кол-во ячеек для победы: ";


    private JRadioButton jrbHumVsAi;
    private JRadioButton jrbHumVsHum;
    private ButtonGroup gameMode;

    private JSlider slFieldSize;
    private JSlider slWinLength;


    public StartNewGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setTitle("Настройки игры");
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setLayout(new GridLayout(10, 1));

        jrbHumVsAi = new JRadioButton("Игрок vs ИИ", true);
        jrbHumVsHum = new JRadioButton("Игрок vs Игрок");
        gameMode = new ButtonGroup();
        gameMode.add(jrbHumVsAi);
        gameMode.add(jrbHumVsHum);

        add(new JLabel("Режим игры:"));
        add(jrbHumVsAi);
        add(jrbHumVsHum);

        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slWinLength = new JSlider(MIN_WIN_LINE, MIN_WIN_LINE, MIN_WIN_LINE);
        slFieldSize.setMajorTickSpacing(1);
        slFieldSize.setPaintTicks(true);
        slFieldSize.setPaintLabels(true);

        slWinLength.setMajorTickSpacing(1);
        slWinLength.setPaintTicks(true);
        slWinLength.setPaintLabels(true);

        add(new JLabel("Выберите размер поля:"));
        JLabel jlFieldSize = new JLabel(STR_FIELD_SIZE + MIN_FIELD_SIZE);
        add(jlFieldSize);
        add(slFieldSize);

        add(new JLabel("Выберите кол-во ячеек для победы:"));
        JLabel jlWinLength = new JLabel(STR_WIN_LENGTH + MIN_WIN_LINE);
        add(jlWinLength);
        add(slWinLength);


        slFieldSize.addChangeListener(e -> {
            int currentFieldSize = slFieldSize.getValue();
            jlFieldSize.setText(STR_FIELD_SIZE + currentFieldSize);
            slWinLength.setMaximum(currentFieldSize);
        });

        slWinLength.addChangeListener(e -> {
            jlWinLength.setText(STR_WIN_LENGTH + slWinLength.getValue());
        });

        JButton btnStartGame = new JButton("Начать игру");
        add(btnStartGame);

        btnStartGame.addActionListener(e -> {
            int gameMode;
            if (jrbHumVsAi.isSelected()) {
                gameMode = BattleMap.H_VS_A;
            } else {
                gameMode = BattleMap.H_VS_H;
            }
            int fieldSize = slFieldSize.getValue();
            int winLength = slWinLength.getValue();

            Logic.SIZE = fieldSize;
            Logic.DOTS_TO_WIN = winLength;
            Logic.initMap();
            Logic.gameFinish = false;


            gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLength);
            setVisible(false);
        });

        setVisible(false);
    }
}
