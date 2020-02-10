package com.company;

public class Main {

    public static void main(String[] args) {
        byte a = 1;
        short b = 2;
        int c = 3;
        long d = 4L;
        float e = 5.0f;
        double f = 6.0;
        char g = 7;
        String h = "8";
        boolean i = true;

        System.out.println("Задание 3: " + calculateExpression(a, b, c, d));
        System.out.println("Задание 4: " + isInDiap(e, f));
        printIsPositive(a);
        System.out.println("Задание 6: " + isNegative(a));
        printHello("Боб");
        printIsLeap(2020);
    }

    /**
     * 3. Вычислить выражение a * (b + (c / d))
     *
     * @param a double
     * @param b double
     * @param c double
     * @param d double
     *
     * @return double
     */
    private static double calculateExpression(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    /**
     * 4. Проверить входит ли сумма в диапазон
     *
     * @param a double
     * @param b double
     *
     * @return boolean
     */
    private static boolean isInDiap(double a, double b) {
        return ((a+b) >= 10 && (a+b) <= 20);
    }

    /**
     * 5. Проверить и вывести на экран положительное или отрицательное число
     *
     * @param a int
     */
    private static void printIsPositive(int a) {
        if (a >= 0) {
            System.out.println("Задание 5: Число положительное");
        } else {
            System.out.println("Задание 5: Число отрицательное");
        }
    }

    /**
     * 6. Проверить отрицательное ли число
     *
     * @param a int
     *
     * @return boolean
     */
    private static boolean isNegative(int a) {
        return a < 0;
    }

    /**
     * 7. Вывести фразу
     *
     * @param name String
     */
    private static void printHello(String name) {
        System.out.println("Задание 7: Привет, " + name + "!");
    }

    /**
     * 8. Вывести результат проверки високосный ли год
     *
     * @param year int
     */
    private static void printIsLeap(int year) {
        if ((year % 4 == 0 && (year % 100 > 0 || year % 400 == 0))) {
            System.out.println("Задание 8: " + year + " - високосный год");
        } else {
            System.out.println("Задание 8: " + year + " - не високосный год");
        }
    }
}
