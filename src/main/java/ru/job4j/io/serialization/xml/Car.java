package ru.job4j.io.serialization.xml;

import jakarta.xml.bind.annotation.*;

import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlAttribute
    private boolean newCar;
    @XmlAttribute
    private double price;
    private Engine engine;
    @XmlElementWrapper(name = "owners")
    @XmlElement(name = "owner")
    private String[] owners;

    public Car() {

    }

    public Car(boolean newCar, double price, Engine engine, String[] owners) {
        this.newCar = newCar;
        this.price = price;
        this.engine = engine;
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "Car{"
                + "newCar=" + newCar
                + ", price=" + price
                + ", engine=" + engine
                + ", owners=" + Arrays.toString(owners)
                + '}';
    }
}
