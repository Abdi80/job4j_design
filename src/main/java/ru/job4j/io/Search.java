package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        checkArguments(args);
        search(Paths.get(args[0]), path -> path.toFile().getName().endsWith(args[1]))
                .forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void checkArguments(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Two arguments required");
        }
        Path start = Paths.get(args[0]);
        if (!Files.exists(start)) {
            throw new IllegalArgumentException(String.format("Not exist %s",
                    start.toAbsolutePath()));
        }
        if (!Files.isDirectory(start)) {
            throw new IllegalArgumentException(String.format("Not directory %s",
                    start.toAbsolutePath()));
        }
        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException(String.format("%s - should start with a dot",
                    args[1]));
        }
        if (args[1].length() < 3) {
            throw new IllegalArgumentException(String.format("%s - too short", args[1]));
        }
    }
}
