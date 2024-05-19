package ru.job4j.generics;

public class Predator extends Animal {
    private String name;
    private double weight;

    public Predator(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Predator() {
    }

    @Override
    public String toString() {
        return "Predator{"
                + "name='" + name + '\''
                + ", weight=" + weight
                + '}';
    }
}
