package ru.job4j.io.objectstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStream {
    public static void main(String[] args) {
        Car car = new Car("Firm", "Model", 2000);
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("data/serialized.dat"));
             ObjectInputStream in = new ObjectInputStream(
                     new FileInputStream("data/serialized.dat"))) {
            out.writeObject(car);
            Car deserialized = (Car) in.readObject();
            System.out.println(deserialized);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
