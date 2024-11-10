package ru.job4j.assertj;

public class Some {
    public static void main(String[] args) {
        separate(36);
    }
    public static void separate(int number) {
        int num1, num2;
        num1 = (number - number % 10) / 10;
        num2 = number % 10;
        System.out.printf("%d %d", num1, num2);
    }
}
