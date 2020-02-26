package com.lesson5;

public class Main
{
    public static void main(String[] args) {
        Employee[] team = new Employee[] {
                new Employee("Петров Петр Петрович", "Junior Java Developer", "petrov@com.ru", "1111111", 30000, 20),
                new Employee("Иванов Иван Иванович", "Middle Java Developer", "ivanov@com.ru", "2222222", 40000, 30),
                new Employee("Степанов Степан Степанович", "Senior Java Developer", "stepanov@com.ru", "3333333", 50000, 41),
                new Employee("Захаров Захар Захарович", "DevOps", "zakharov@com.ru", "4444444", 40000, 30),
                new Employee("Алексеев Алексей Алексеевич", "Product owner", "alexeev@com.ru", "5555555", 60000, 50),
        };

        for (Employee emp : team) {
            if (emp.getAge() > 40) {
                emp.printInfo();
            }
        }
    }
}
