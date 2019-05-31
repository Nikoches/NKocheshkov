package ru.job4j.javaio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args){
        Server serv = new Server(5000);
        serv.startserv();
    }
    private int port;
    public Server(int port) {
       this.port = port;
    }

    public void startserv() {
        try(ServerSocket serverSocket = new ServerSocket(port); Socket socket = serverSocket.accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("wait command ...");
            String ask;
            do {
                ask = in.readLine();
                System.out.println(ask);
                if ("hello".equals(ask)) {
                    out.println("Hello, dear friend, I'm a oracle.");
                    out.println();
                }
            } while (!"exit".equals(ask));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

