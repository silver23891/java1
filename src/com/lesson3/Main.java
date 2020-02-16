package com.lesson3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int game = getIntInDiap(
                "Выберите игру:\n1. Угадывание числа;\n2. Угадывание слова.",
                1,
                2
        );
        beginGame(game);
    }

    /**
     * Управление играми
     */
    public static void beginGame(int game)
    {
        do {
            if (game == 1) {
                gameGuessNumber();
            } else {
                gameGuessString();
            }
        } while (isGameContinue());
    }

    /**
     * 1. Игра Угадай число
     */
    public static void gameGuessNumber()
    {
        Random random = new Random();
        int number = random.nextInt(10);
        for (int i = 3; i > 0; i--) {
            System.out.printf("Угадайте число от 0 до 9. Осталось попыток: %d\n", i);
            int userNumber = sc.nextInt();
            if (userNumber > number) {
                System.out.println("Введенное число больше загаданного.");
            } else if (userNumber < number) {
                System.out.println("Введенное число меньше загаданного.");
            } else {
                System.out.println("Вы выиграли!");
                return;
            }
        }
        System.out.println("Вы проиграли..");
    }

    /**
     * 2. Игра Угадай слово
     */
    public static void gameGuessString()
    {
        String[] words = {
                "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"
        };
        Random random = new Random();
        String word = words[random.nextInt(words.length)];
        while (true) {
            System.out.println("Угадайте слово:");
            String userWord = sc.next();
            if (word.equals(userWord)) {
                System.out.println("Вы выиграли");
                return;
            }

            System.out.println("Не угадали..");

            char[] hint = getCharArray(15, '#');
            for (int i = 0; i < word.length(); i++) {
                if (i < userWord.length()) {
                    hint[i] = word.charAt(i) == userWord.charAt(i) ? word.charAt(i):'#';
                }
            }
            printArray(hint);
        }
    }

    /**
     * Вывести на экран все элементы массива
     *
     * @param arr char[]
     */
    public static void printArray(char[] arr)
    {
        for (char value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * Сформировать заполненный массив символов
     *
     * @param size   int  Размер массива
     * @param symbol char Символ, которым заполнить массив
     *
     * @return char[]
     */
    public static char[] getCharArray(int size, char symbol)
    {
        char[] arr = new char[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = symbol;
        }
        return arr;
    }

    /**
     * Получить от пользователя решение продолжить или закончить игру
     *
     * @return boolean True - продолжить; false - завершить
     */
    public static boolean isGameContinue()
    {
        return getIntInDiap("Повторить игру?\n1. Да;\n0. Нет.", 0, 1) > 0;
    }

    /**
     * Получить введенное число в заданном диапазоне
     *
     * @param message String Приграшение к вводу
     * @param min     Int    Минимальное значение числа
     * @param max     Int    Максимальное значение числа
     *
     * @return int Введенное число
     */
    public static int getIntInDiap(String message, int min, int max)
    {
        int input;
        do {
            System.out.println(message);
            input = sc.nextInt();
        } while (!(input >= min && input <= max));
        return input;
    }
}
