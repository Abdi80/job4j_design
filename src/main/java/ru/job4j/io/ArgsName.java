package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (values.get(key) == null) {
            throw new IllegalArgumentException(String.format("This key: '%s' is missing", key));
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String element : args) {
            String[] result = checkArguments(element);
            values.put(result[0], result[1]);
        }
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    private String[] checkArguments(String string) {
        if (!string.contains("=")) {
            throw new IllegalArgumentException(String.format(
                    "Error: This argument '%s' does not contain an equal sign", string));
        }
        if (!string.startsWith("-")) {
            throw new IllegalArgumentException(String.format(
                    "Error: This argument '%s' does not start with a '-' character", string));
        }
        String[] result = string.split("=", 2);
        String key = result[0].substring(1);
        String value = result[1];
        if (key.isEmpty()) {
            throw new IllegalArgumentException(String.format(
                    "Error: This argument '%s' does not contain a key", string));
        }
        if (value.isEmpty()) {
            throw new IllegalArgumentException(String.format(
                    "Error: This argument '%s' does not contain a value", string));
        }
        return new String[] {key, value};
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
