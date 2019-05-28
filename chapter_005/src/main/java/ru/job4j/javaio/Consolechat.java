package ru.job4j.javaio;

import java.io.*;

public class Consolechat {
    StringBuilder log = new StringBuilder();
    String[] answers = new String[25];

    public static void main(String[] args) {
        Consolechat cc = new Consolechat();
        cc.chating();
    }

    public void chating() {
        try (BufferedReader textreader = new BufferedReader(new FileReader("chat_text.txt"))) {
            String s;
            int i = 0;
            while ((s = textreader.readLine()) != null) {
                answers[i++] = s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean stopper = false;
            int i = 0;
            String answ = reader.readLine();
            while (!answ.equals("конец")) {
                log.append(answ).append("\n");
                if (answ.equals("стоп")) {
                    stopper = true;
                    System.out.println();
                } else if (answ.equals("продолжить") || !stopper) {
                    stopper = false;
                    System.out.println(answers[i++]);
                }
                answ = reader.readLine();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream("log_chat.log"))) {
            out.println(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

