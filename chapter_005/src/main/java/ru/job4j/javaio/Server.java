package ru.job4j.javaio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final Socket sock;

    public Server(Socket sock) {
        this.sock = sock;
    }

    public static void main(String[] args) {
        try (Socket socket = new ServerSocket(5000).accept()) {
            new Server(socket);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void startserv() {
        try (PrintWriter out = new PrintWriter(this.sock.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(this.sock.getInputStream()))) {
            System.out.println("wait command ...");
            String ask;
            do {
                ask = in.readLine();
                System.out.println(ask);
                if ("hello".equals(ask)) {
                    out.println("Hello, dear friend, I'm a oracle.");
                } else if(!"пока".equals(ask)){
                    out.println("not understand");
                }
            } while (!"пока".equals(ask));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

