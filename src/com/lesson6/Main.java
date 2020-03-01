package com.lesson6;

import com.lesson6.animals.Cat;
import com.lesson6.animals.Dog;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog);
        dog.run(100);
        dog.jump(5);
        dog.sweem(7);

        Dog dog2 = new Dog();
        System.out.println(dog2);
        dog2.run(200);
        dog2.jump(3);
        dog2.sweem(4);

        Cat cat = new Cat();
        System.out.println(cat);
        cat.run(200);
        cat.jump(3);
        cat.sweem(10);

        Cat cat2 = new Cat();
        System.out.println(cat2);
        cat2.run(100);
        cat2.jump(2);
        cat2.sweem(12);
    }
}
