package com.lesson7;

import java.util.Random;

public class Cat {
    private String name;
    private int appetite;
    private boolean hungry;

    {
        hungry = true;
        appetite = 10 + new Random().nextInt(10);
    }

    public Cat(String name) {
        this.name = name;
    }

    public boolean eat(Plate plate) {
        if (plate.decreaseFood(appetite)) {
            hungry = false;
            System.out.println(name + " покушал");
        } else {
            System.out.println(name + " остался голодным..");
        }
        return !hungry;
    }

    public boolean isHungry() {
        return hungry;
    }
}
