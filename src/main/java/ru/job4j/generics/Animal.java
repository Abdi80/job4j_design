package ru.job4j.generics;

public class Animal {
    private String name;
    private double weight;

    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Animal() {
    }

    @Override
    public String toString() {
        return "Animal{"
                + "name='" + name + '\''
                + ", weight=" + weight
                + '}';
    }
}
