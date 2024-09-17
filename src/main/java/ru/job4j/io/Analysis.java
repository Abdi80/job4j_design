package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public void unavailable(String source, String target) {
        List<String> list = read(source);
        write(list, target);
    }

    public List<String> read(String source) {
        List<String> listTime = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String start = null;
            String finish = null;
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (line.startsWith("#") || line.isEmpty()) {
                    continue;
                }
                String[] result = line.split(" ");
                if ("400".equals(result[0]) || "500".equals(result[0])) {
                    start = start == null ? result[1] : start;
                    finish = null;
                } else if ("200".equals(result[0]) || "300".equals(result[0])) {
                    finish = result[1];
                }
                if (start != null && finish != null) {
                    StringBuilder time = new StringBuilder();
                    time.append(start).append(";").append(finish).append(";\n");
                    listTime.add(time.toString());
                    start = null;
                    finish = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listTime;
    }

    public void write(List<String> list, String target) {
        try (PrintWriter output = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
            for (String string : list) {
                output.print(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
