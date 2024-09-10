package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("data/even.txt")) {
            int read;
            StringBuilder text = new StringBuilder();
            while ((read = input.read()) != -1) {
                text.append((char) read);
            }
            printNumber(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void printNumber(StringBuilder text) {
    String[] lines = text.toString().split(System.lineSeparator());
    for (String line : lines) {
        try {
            int number = Integer.parseInt(line);
            if (number % 2 == 0) {
                System.out.println(line + " is even");
            } else {
                System.out.println(line + " is odd");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    }
}
