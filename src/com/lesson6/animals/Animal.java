package com.lesson6.animals;

import java.util.Random;

public abstract class Animal {
    /**
     * Максимальные дистанция бега, высота прыжка, дистанция плавания
     */
    int run;
    float jump;
    int sweem;

    static Random random = new Random();

    public Animal() {
        run = generateRun();
        jump = generateJump();
        sweem = generateSweem();
    }

    int generateRun() {
        return random.nextInt(200);
    }

    float generateJump() {
        return random.nextFloat()*10;
    }

    int generateSweem() {
        return random.nextInt(10);
    }

    public void run(float length) {
        System.out.println("RUN: " + (length <= run));
    }
    public void jump(float height) {
        System.out.println("JUMP: " + (height <= jump));
    }
    public void sweem(float length) {
        System.out.println("SWEEM: " + (length <= sweem));
    }

    @Override
    public String toString() {
        return getClass() + " {" +
                "run=" + run +
                ", jump=" + jump +
                ", sweem=" + sweem +
                '}';
    }
}
