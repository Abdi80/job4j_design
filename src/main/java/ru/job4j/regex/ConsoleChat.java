package ru.job4j.regex;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> botAnswers = readPhrases();
        List<String> answers = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean pause = false;
            String word = scanner.nextLine();
            while (!OUT.equals(word)) {
                String answer = "";
                if (STOP.equals(word)) {
                    pause = true;
                } else if (CONTINUE.equals(word)) {
                    pause = false;
                }
                if (!pause) {
                    int randomInt = (int) Math.floor(Math.random() * (botAnswers.size() - 1));
                    answer = botAnswers.get(randomInt);
                    System.out.println(answer);
                }
                String line = String.format("%s - %s", word, answer);
                answers.add(line);
                word = scanner.nextLine();
            }
            answers.add(String.format("%s - ", word));
        }
        saveLog(answers);
    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            reader.lines()
                    .forEach(line -> phrases.add(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path,
                Charset.forName("UTF-8"), true))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("data/answersLog.txt", "data/botAnswers.txt");
        consoleChat.run();
    }
}
