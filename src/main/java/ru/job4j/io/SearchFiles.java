package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.nio.file.Path;

public class SearchFiles extends SimpleFileVisitor<Path> {
    private Predicate predicate;
    private List<Path> paths = new ArrayList<>();

    public SearchFiles(Predicate predicate) {
        this.predicate = predicate;
    }

    public List<Path> getPaths() {
        return paths;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (Files.isRegularFile(file) && predicate.test(file)) {
            paths.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

}
