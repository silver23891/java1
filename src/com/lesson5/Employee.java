package com.lesson5;

public class Employee
{
    private String fio;
    private String position;
    private String email;
    private String phone;
    private float salary;
    private int age;

    public int getAge()
    {
        return age;
    }

    public Employee(String fio, String position, String email, String phone, float salary, int age)
    {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo()
    {
        System.out.printf(
                "Фамилия: %s\nДолжность: %s\nEmail: %s\nТелефон: %s\nЗарплата: %f\nВозраст: %d\n\n",
                fio, position, email, phone, salary, age
        );
    }
}