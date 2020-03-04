package com.lesson6.animals;

public class Dog extends Animal {
    /**
     * Сформировать максимальную дистанцию бега
     *
     * @return int
     */
    @Override
    int generateRun() {
        return 300 + super.generateRun();
    }
}
