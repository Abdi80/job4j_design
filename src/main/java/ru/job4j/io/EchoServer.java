package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String stringFirst = input.readLine();
                    if (parseLine(stringFirst)) {
                        socket.close();
                        server.close();
                        return;
                    } else {
                        System.out.println(stringFirst);
                    }
                    for (String string = input.readLine(); string != null && !string.isEmpty();
                        string = input.readLine()) {
                        System.out.println(string);
                    }
                    output.flush();
                }
            }
        }
    }

    private static boolean parseLine(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("Error: the line is missing");
        }
        String[] arguments = string.split(" ");
        if (arguments.length < 2 || arguments[1] == null || !arguments[1].contains("msg=")) {
            throw new IllegalArgumentException("Error: the second argument is missing or wrong");
        }
        String[] msg = arguments[1].split("=", 2);
        return "Bye".equals(msg[1]);
    }
}