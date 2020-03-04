package com.lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void printInfo() {
        System.out.println("Осталось еды: " + food);
    }

    public boolean decreaseFood(int appetite) {
        if (food >= appetite) {
            food -= appetite;
            printInfo();
            return true;
        } else {
            return false;
        }
    }

    public void addFood(int food) {
        this.food += food;
        printInfo();
    }
}
