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
                    String request = parseLine(input.readLine());
                    switch (request) {
                        case "Exit":
                            socket.close();
                            server.close();
                            break;
                        case "Hello":
                            output.write("Hello, dear friend.".getBytes());
                            break;
                        default:
                            output.write(request.getBytes());
                    }
                    output.flush();
                }
            }
        }
    }

    private static String parseLine(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("Error: the line is missing");
        }
        String[] arguments = string.split(" ");
        if (arguments.length < 2 || arguments[1] == null || !arguments[1].contains("msg=")) {
            throw new IllegalArgumentException("Error: the second argument is missing or wrong");
        }
        String[] msg = arguments[1].split("=", 2);
        return msg[1];
    }
}
