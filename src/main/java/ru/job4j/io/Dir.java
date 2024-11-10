package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage  ROOT_FOLDER.");
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Директория не существует: %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Это не директория: %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("Имя директории: %s", file.getName()));
        System.out.println(String.format("Размер директории: %s", file.getTotalSpace()));
        printFileNameSize(file);
    }
    private static void printFileNameSize(File directory) {
        for (File subfile : directory.listFiles()) {
            if (subfile.isFile()) {
                System.out.println(String.format("Имя файла: %s, размер файла: %d",
                        subfile.getName(), subfile.length()));
            } else if (subfile.isDirectory()) {
                System.out.println(String.format("Имя директории: %s", subfile.getName()));
                printFileNameSize(subfile);
            }
        }
    }
}
