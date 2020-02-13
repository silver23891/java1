package com.lesson2;

import java.lang.reflect.Array;
import java.util.Arrays;

import static java.lang.Math.abs;

public class Main
{
    public static void main(String[] args) {
        int[] binArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Задание 1: " + Arrays.toString(invertArray(binArray)));
        int[] empty = new int[8];
        System.out.println("Задание 2: " + Arrays.toString(fillEmptyArray(empty)));
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Задание 3: " + Arrays.toString(multiplyArray(array)));
        double[][] table = {
                {2,2,2,2,2},
                {2,2,2,2,2},
                {2,2,2,2,2},
                {2,2,2,2,2}
        };
        table = fillTable(table);
        System.out.println("Задание 4:");
        for (double[] row : table) {
            System.out.println(Arrays.toString(row));
        }
        double arr[] = {1, 1, 2, 4};
        printMinMax(arr);
        System.out.println("Задание 6: " + isLeftRight(arr));
        System.out.println("Задание 7: " + Arrays.toString(shiftArray(arr, 3)));
    }

    /**
     * 1. Заменить 0 на 1, 1 на 0 в массиве
     *
     * @param arr int[]
     *
     * @return int[]
     */
    private static int[] invertArray(int[] arr)
    {
        if (arr.length == 0) {
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        return arr;
    }

    /**
     * 2. Заполнить пустой массив
     *
     * @param arr int[]
     *
     * @return int[]
     */
    private static int[] fillEmptyArray(int[] arr)
    {
        if (arr.length == 0) {
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i*3;
        }
        return arr;
    }

    /**
     * 3. Умножить элементы массива, значение которых < 6, на 2
     *
     * @param arr int[]
     *
     * @return int[]
     */
    private static int[] multiplyArray(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        return arr;
    }

    /**
     * 4. Заполнить диагональ элементы двумерного массива
     *
     * @param table double[][]
     *
     * @return double[][]
     */
    private static double[][] fillTable(double[][] table)
    {
        if (table.length == 0) {
            return table;
        }

        for (int i = 0; i < table.length; i++) {
            table[i][i] = 1;
            table[i][table.length-i] = 1;
        }
        return table;
    }

    /**
     * 5. Вывести min, max массива
     *
     * @param arr double[] Массив для поиска min, max
     */
    private static void printMinMax(double arr[])
    {
        double[] minMax = getMinMax(arr);
        System.out.println("Задание 5: MIN = " + minMax[0] + "; MAX = " + minMax[1]);
    }

    /**
     * 5. Найти min, max в массиве
     *
     * @param arr double[] Массив для поиска min, max
     *
     * @return double[] 0 - min; 1 - max
     */
    private static double[] getMinMax(double arr[])
    {
        double[] res = {-1, -1};
        if (arr.length == 0) {
            return res;
        }
        res[0] = arr[0];
        res[1] = arr[0];

        for (double value : arr) {
            if (value > res[1]) {
                res[1] = value;
            } else if (value < res[0]) {
                res[0] = value;
            }
        }
        return res;
    }

    /**
     * 6. Проверить есть ли баланс в массиве
     *
     * @param arr double[]
     *
     * @return boolean
     */
    private static boolean isLeftRight(double arr[])
    {
        double sum = 0;
        for (double value : arr) {
            sum += value;
        }
        double currentSum = 0;
        for (double val : arr) {
            currentSum += val;
            if (currentSum == sum) {
                return true;
            }
        }
        return false;
    }

    /**
     * 7. Сдвинуть элементы массива
     * @param arr int[]
     * @param n   int
     *
     * @return int[]
     */
    private static double[] shiftArray(double arr[], int n)
    {
        if (n == 0 || arr.length == 0 || n == arr.length) {
            return arr;
        }

        while (abs(n) >= arr.length) {
            if (n > 0) {
                n -= arr.length;
            } else {
                n += arr.length;
            }
        }
        int i = 0;
        double bufCurrent = arr[i];
        double bufNext = arr[i];
        for (int count = arr.length; count > 0; count--) {
            int newIdx = i+n;
            if (newIdx >= arr.length) {
                newIdx -= arr.length;
            }
            while (newIdx < 0) {
                newIdx += arr.length;
            }

            bufCurrent = bufNext;
            bufNext = arr[newIdx];
            arr[newIdx] = bufCurrent;
            i = newIdx;
        }
        return arr;
    }
}