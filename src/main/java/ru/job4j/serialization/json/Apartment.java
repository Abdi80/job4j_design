package ru.job4j.serialization.json;

import java.util.Arrays;

public class Apartment {
    private final boolean finished;
    private final int square;
    private final String houseName;
    private final String[] rooms;
    private final Contact contact;

    public Apartment(int square, String houseName, String[] rooms, Contact contact, boolean finished) {
        this.square = square;
        this.houseName = houseName;
        this.rooms = rooms;
        this.contact = contact;
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "Apartment{"
                + "finished=" + finished
                + ", square=" + square
                + ", houseName='" + houseName + '\''
                + ", rooms=" + Arrays.toString(rooms)
                + ", contact=" + contact
                + '}';
    }
}
