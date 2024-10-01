package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.List;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(
                new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toString()));
                try (BufferedInputStream output = new BufferedInputStream(
                        new FileInputStream(path.toFile()))) {
                    zip.write(output.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ArgsName checkArguments(String[] args) {
        ArgsName jvm = ArgsName.of(args);
        jvm.get("d");
        if (!jvm.get("e").startsWith(".")) {
            throw new IllegalArgumentException("Parameter should starts with \".\"");
        }
        if (!jvm.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException("Extension \".zip\" is required");
        }
        return jvm;
    }

    public static void main(String[] args) throws IOException {
        ArgsName arguments = checkArguments(args);
        List<Path> paths = Search.search(Path.of(arguments.get("d")),
                path -> !path.toFile().getName().endsWith(arguments.get("e"))
        );
        Zip zip = new Zip();
        zip.packFiles(paths, new File(arguments.get("o")));
    }
}
