package com.lesson7;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Мурзик1"),
                new Cat("Мурзик2"),
                new Cat("Мурзик3"),
                new Cat("Мурзик4"),
                new Cat("Мурзик5"),
        };
        Plate plate = new Plate(50);

        //кормим, пока не накормим всех котов
        int hungryCats = cats.length;
        while (hungryCats > 0) {
            for (Cat cat : cats) {
                if (cat.isHungry()) {
                    if (cat.eat(plate)) {
                        hungryCats--;
                    }
                }
            }
            if (hungryCats == 0) {
                break;
            }
            plate.addFood(50);
        }
        System.out.println("Все коты накормлены!");
    }
}
