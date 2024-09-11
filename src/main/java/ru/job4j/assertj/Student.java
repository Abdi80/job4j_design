package ru.job4j.assertj;

import java.util.Objects;

public class Student {
    private String name;
    private int corse;
    private int id;

    public Student(String name, int corse, int id) {
        this.name = name;
        this.corse = corse;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }



    public static void main(String[] args) {
        long number1 = 18000;
        long number2 = 0xf000ffff;
        long number3 = number1 & number2;
        System.out.println(number3 | 0x8000000);
    }
}
