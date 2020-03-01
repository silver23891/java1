package com.lesson6.animals;

public class Cat extends Animal {

    /**
     * Сформировать максимальную дистанцию плавания
     * Коты не плавают, поэтому дистанция всегда 0
     *
     * @return int
     */
    @Override
    int generateSweem() {
        return 0;
    }

    /**
     * Сформировать максимальную высоту прыжка
     * Коты прыгают высоко
     *
     * @return float
     */
    @Override
    float generateJump() {
        return 5 + super.generateJump();
    }
}
