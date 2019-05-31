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
        client.clientstart("127.0.0.1",5000);
    }

    public void clientstart(String ip, int port) {
        try( Socket socket = new Socket(InetAddress.getByName(ip), port);PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            Scanner console = new Scanner(System.in);
            do {
                String str = console.nextLine();
                out.println(str);

                while (!(str = in.readLine()).isEmpty()) {
                    System.out.println(str);
                }
            } while (!toString().equals("пока"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
