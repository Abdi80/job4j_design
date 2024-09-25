package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./"), visitor);
        printDuplicates(visitor);
    }

    public static void printDuplicates(DuplicatesVisitor visitor) {
        Map<FileProperty, List<Path>> map = visitor.getFiles();
        map.entrySet()
                .stream()
                .filter(pair -> pair.getValue().size() > 1)
                .forEach(pair -> {
                    System.out.printf("%s - %s%n", pair.getKey().getName(), pair.getKey().getSize());
                    pair.getValue().forEach(System.out::println);
                });
    }
}
