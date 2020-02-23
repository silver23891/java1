package com.lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int size;
    private static int cellsToWin;
    private static Scanner sc = new Scanner(System.in);
    private static char[][] map;
    private static int lastX;
    private static int lastY;

    private static final char X_SYM = 'X';
    private static final char O_SYM = 'O';
    private static final char EMPTY_SYM = 183;

    public static void main(String[] args)
    {
        size = getIntInput(3, 20, "Введите размер поля (от 3 до 20):");
        cellsToWin = getIntInput(3, size, "Введите кол-во ячеек для победы (от 3 до "+ size +"):");
        initMap();
        printMap();
        while (true) {
            makeTurn(0);
            if (isWin(lastX, lastY, X_SYM)) {
                System.out.println("Победа!");
                break;
            }
            if (isNoTurns()) {
                System.out.println("Ничья");
                break;
            }
            makeTurn(1);
            if (isWin(lastX, lastY, O_SYM)) {
                System.out.println("Поражение..");
                break;
            }
            if (isNoTurns()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    /**
     * Получить целое значение из консоли
     *
     * @param min     int    Минимальное значение
     * @param max     int    Максимальное значение
     * @param message String Строка-приглашение
     *
     * @return int
     */
    private static int getIntInput(int min, int max, String message)
    {
        int input;
        do {
            System.out.println(message);
            input = sc.nextInt();
        } while (input < min || input > max);
        return input;
    }

    /**
     * Создать массив массивов и заполнить его Пустыми символами
     *
     * @return char[][]
     */
    private static void initMap()
    {
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = EMPTY_SYM;
            }
        }
    }

    /**
     * Вывести на экран поле игры
     */
    private static void printMap()
    {
        System.out.print("\t");
        for (int i = 1; i < size+1; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print((i+1) + "\t");
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Проверить доступность ячейки
     *
     * @param x int Горизонталь
     * @param y int Вертикаль
     *
     * @return boolean
     */
    private static boolean isValidCell(int x, int y)
    {
        if (x < 0 || y < 0 || x > size || y > size) {
            return false;
        }
        return map[y][x] == EMPTY_SYM;
    }

    /**
     * Выполнить ход
     *
     * @param who int 0-человек; 1-ии
     */
    private static void makeTurn(int who)
    {
        if (who == 0) {
            makeHumanTurn();
        } else {
            makeAiTurn();
        }
        printMap();
    }

    /**
     * Ход человека
     */
    private static void makeHumanTurn()
    {
        do {
            System.out.println("Введите координаты в формате x y");
            lastX = sc.nextInt()-1;
            lastY = sc.nextInt()-1;
        } while (!isValidCell(lastX, lastY));
        map[lastY][lastX] = X_SYM;
    }

    /**
     * Ход ИИ
     */
    private static void makeAiTurn()
    {
        System.out.println("Ход ИИ:");
        if (makeWinTurn()) {
            return;
        } else if (makeBlockTurn()) {
            return;
        } else {
            makeRandomTurn();
        }
    }

    /**
     * Выполнить ход ИИ, нацеленный на победу
     *
     * @return boolean
     */
    private static boolean makeWinTurn()
    {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isValidCell(j, i)) {
                    map[i][j] = O_SYM;
                    if (isWin(j, i, O_SYM)) {
                        lastY = i;
                        lastX = j;
                        return true;
                    } else {
                        map[i][j] = EMPTY_SYM;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Выполнить ход ИИ, нацеленный на блокирование человека
     *
     * @return boolean
     */
    private static boolean makeBlockTurn()
    {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isValidCell(j, i)) {
                    map[i][j] = X_SYM;
                    if (isWin(j, i, X_SYM)) {
                        map[i][j] = O_SYM;
                        lastY = i;
                        lastX = j;
                        return true;
                    } else {
                        map[i][j] = EMPTY_SYM;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Выполнить рандомный ход ИИ
     */
    private static void makeRandomTurn()
    {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        } while (!isValidCell(x, y));
        lastY = y;
        lastX = x;
        map[y][x] = O_SYM;
    }

    /**
     * Проверить ничью
     *
     * @return boolean
     */
    private static boolean isNoTurns()
    {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == EMPTY_SYM) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Проверить победу
     *
     * @param x int Координаты ячейки
     * @param y int
     *
     * @return boolean
     */
    private static boolean isWin(int x, int y, char sym)
    {
        if (isHorizontalWin(y, sym)) {
            return true;
        } else if (isVerticalWin(x, sym)) {
            return true;
        }
        return isDiagonalWin(x, y, sym);
    }

    /**
     * Проверить горизонтальные ячейки на победу
     *
     * @param y   int  Внутренний массив
     * @param sym char Крестик или нолик
     *
     * @return boolean
     */
    private static boolean isHorizontalWin(int y, char sym)
    {
        int count = 0;
        for (char value : map[y]) {
            if (value == sym) {
                count++;
            } else {
                count = 0;
            }
            if (count == cellsToWin) {
                return true;
            }
        }
        return false;
    }

    /**
     * Проверить вертикальные ячейки на победу
     *
     * @param x   int  Элемент массива
     * @param sym char Крестик или нолик
     *
     * @return boolean
     */
    private static boolean isVerticalWin(int x, char sym)
    {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (map[i][x] == sym) {
                count++;
            } else {
                count = 0;
            }
            if (count == cellsToWin) {
                return true;
            }
        }
        return false;
    }

    /**
     * Проверить диагонали на победу
     *
     * @param x   int  Координаты ячейки
     * @param y   int  Координаты ячейки
     * @param sym char Крестик или нолик
     *
     * @return boolean
     */
    private static boolean isDiagonalWin(int x, int y, char sym)
    {
        int count = 0;
        int leftX = x;
        int leftY = y;
        //получаем левое верхнее начало диагонали, чтобы оттуда начать проверку
        while (leftX > 0 && leftY > 0) {
            leftX--;
            leftY--;
        }
        while (leftY < size && leftX < size) {
            if (map[leftY][leftX] == sym) {
                count++;
            } else {
                count = 0;
            }
            if (count == cellsToWin) {
                return true;
            }
            leftY++;
            leftX++;
        }
        count = 0;
        int rightX = x;
        int rightY = y;
        //получаем правое верхнее начало диагонали, чтобы оттуда начать проверку
        while (rightX < size-1 && rightY > 0) {
            rightX++;
            rightY--;
        }
        while (rightY < size && rightX >= 0) {
            if (map[rightY][rightX] == sym) {
                count++;
            } else {
                count = 0;
            }
            if (count == cellsToWin) {
                return true;
            }
            rightY++;
            rightX--;
        }
        return false;
    }
}
