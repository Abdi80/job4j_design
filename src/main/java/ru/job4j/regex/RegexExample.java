package ru.job4j.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Я учусь на Job4j");

        String textOne = "Я учусь на курсе Job4j";
        Matcher matcherOne = pattern.matcher(textOne);
        boolean isPresentOne = matcherOne.matches();
        System.out.println(isPresentOne);

        String textTwo = "Я учусь на Job4j";
        Matcher matcherTwo = pattern.matcher(textTwo);
        boolean isPresentTwo = matcherTwo.matches();
        System.out.println(isPresentTwo);

        Pattern patternTwo = Pattern.compile("Job4j", Pattern.CASE_INSENSITIVE);

        String textThree = "Job4j";
        Matcher matcherThree = patternTwo.matcher(textThree);
        boolean isPresentThree = matcherThree.matches();
        System.out.println(isPresentThree);

        String textFour = "job4j";
        Matcher matcherFour = patternTwo.matcher(textFour);
        boolean isPresentFour = matcherFour.matches();
        System.out.println(isPresentFour);

        Pattern patternThree = Pattern.compile("Job4j");
        String text = "Job4j и Job4j и Job4j";
        Matcher matcher = patternThree.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение. iStart: " + matcher.start()
                    + " iEnd: " + matcher.end());
        }

        Pattern patternFour = Pattern.compile("123");
        String textFive = "1231 и 1232 и 1233";
        Matcher matcherFive = patternFour.matcher(textFive);
        String result = matcherFive.replaceAll("Job4j");
        System.out.println(result);
    }
}
