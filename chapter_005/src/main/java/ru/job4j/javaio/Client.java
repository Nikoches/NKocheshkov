package ru.job4j.javaio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.clientstart("127.0.0.1", 5000);
    }

    public void clientstart(String ip, int port) {
        try (Socket socket = new Socket(InetAddress.getByName(ip), port); PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            Scanner console = new Scanner(System.in);
            String str;
            do {
                str = console.nextLine();
                out.println(str);
                String str1 = in.readLine();
                if (!str1.isEmpty()) {
                    System.out.println(str1);
                }
            } while (!str.equals("пока"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
