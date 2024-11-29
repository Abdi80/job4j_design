package ru.job4j.io.serialization.xml;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "engine")
public class Engine {
    @XmlAttribute
    private double volume;

    public Engine() {

    }

    public Engine(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "volume=" + volume
                + '}';
    }
}
