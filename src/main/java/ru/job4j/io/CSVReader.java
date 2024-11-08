package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String source = argsName.get("path");
        String receiver = argsName.get("out");
        String delimiter = argsName.get("delimiter");
        String[] filters = argsName.get("filter").split(",");
        StringJoiner joiner = new StringJoiner(System.lineSeparator());

        try (Scanner scanner = new Scanner(new FileInputStream(source))
                .useDelimiter(System.lineSeparator())) {
            String[] headers = scanner.next().split(delimiter);
            List<Integer> filterOrder = getFilterOrder(headers, filters);

            joiner.add(getFilteredRow(headers, filterOrder, delimiter));

            while (scanner.hasNext()) {
                String[] row = scanner.next().split(delimiter);
                joiner.add(getFilteredRow(row, filterOrder, delimiter));
            }
        }

        if ("stdout".equals(receiver)) {
            System.out.println(joiner);
        } else {
            try (PrintStream output = new PrintStream(new FileOutputStream(receiver))) {
                output.println(joiner);
            }
        }
    }

    private static String getFilteredRow(String[] row, List<Integer> order, String delimiter) {
        StringJoiner joiner = new StringJoiner(delimiter);
        for (int i : order) {
            joiner.add(row[i]);
        }
        return joiner.toString();
    }

    private static List<Integer> getFilterOrder(String[] headers, String[] filters) {
        List<Integer> filterOrder = new ArrayList<>();
        for (String f : filters) {
            for (int i = 0; i < headers.length; i++) {
                if (f.equals(headers[i])) {
                    filterOrder.add(i);
                    break;
                }
            }
        }
        return filterOrder;
    }

    private static ArgsName checkArguments(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Four arguments required");
        }
        ArgsName argsName = ArgsName.of(args);
        String[] requiredKeys = {"path", "delimiter", "out", "filter"};
        for (String key : requiredKeys) {
            argsName.get(key);
        }
        return argsName;
    }

    public static void main(String[] args) {
        ArgsName argsName = checkArguments(args);
        try {
            handle(argsName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
