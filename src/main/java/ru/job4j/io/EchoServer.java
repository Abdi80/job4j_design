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
                    for (String string = input.readLine(); string != null && !string.isEmpty();
                        string = input.readLine()) {
                        if (parseLine(string)) {
                            socket.close();
                            server.close();
                            return;
                        }
                        System.out.println(string);
                    }
                    output.flush();
                }
            }
        }
    }

    private static boolean parseLine(String string) {
        boolean result = false;
        String[] arguments = string.split(" ");
        if (arguments[1].contains("msg=")) {
            String[] msg = arguments[1].split("=", 2);
            result = "Bye".equals(msg[1]);
        }
        return result;
    }
}
