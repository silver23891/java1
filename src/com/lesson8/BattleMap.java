package com.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {
    public static final int H_VS_A = 0;
    public static final int H_VS_H = 1;

    int fieldSizeX;
    int fieldSizeY;
    int winLength;

    int cellHeight;
    int cellWidth;

    boolean isInitialized = false;

    public BattleMap() {
        setBackground(Color.DARK_GRAY);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    void render(Graphics g) {
        if (!isInitialized) {
            return;
        }
        if (Logic.gameFinish) {
            drawMessage(g, Logic.winnerName);
            return;
        }
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.setColor(Color.WHITE);
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.setColor(Color.WHITE);
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);
                }
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }
            }
        }

    }

    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;

        isInitialized = true;
        repaint();
    }

    private void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if (!Logic.gameFinish) {
            Logic.setHumanXY(cellX, cellY);
//            if (Logic.gameFinish) {
//                VictoryWindow victoryWindow = new VictoryWindow(Logic.winnerName);
//                victoryWindow.setVisible(true);
//            }
        }
        repaint();
    }

    private void drawX(Graphics g, int cellX, int cellY) {
        g.setColor(new Color(0, 255, 37));

        g.drawLine(cellX * cellWidth + 5, cellY * cellHeight + 5,
                (cellX + 1) * cellWidth - 5, (cellY + 1) * cellHeight - 5);
        g.drawLine((cellX + 1) * cellWidth - 5, cellY * cellHeight + 5,
                cellX * cellWidth + 5, (cellY + 1) * cellHeight - 5);
    }

    private void drawO(Graphics g, int cellX, int cellY) {
        g.setColor(new Color(255, 0, 30));
        g.drawOval(cellX * cellWidth + 5, cellY * cellHeight + 5, cellWidth - 10, cellHeight - 10);
    }

    private void drawMessage(Graphics g, String message) {
        g.setColor(new Color(0));
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.WHITE);
        g.drawString(message, getWidth()/4, getHeight()/2);
    }
}
