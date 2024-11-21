package ru.job4j.serialization.json;

public class Contact {
    private final String name;
    private final String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "name='" + name + '\''
                + ", phone='" + phone + '\''
                + '}';
    }
}
