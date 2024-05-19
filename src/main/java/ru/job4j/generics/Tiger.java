package ru.job4j.generics;

public class Tiger extends Predator {
    private String name;
    private double weight;

    public Tiger(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Tiger{"
                + "name='" + name + '\''
                + ", weight=" + weight
                + '}';
    }
}
