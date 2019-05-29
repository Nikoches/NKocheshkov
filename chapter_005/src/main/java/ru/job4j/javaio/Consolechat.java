package ru.job4j.javaio;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

public class Consolechat {
    private StringBuilder log = new StringBuilder();
    private LinkedList<String> answers = new LinkedList<>();

    public static void main(String[] args) {
        Consolechat cc = new Consolechat();
        cc.chating();
    }

    public void chating() {
        try (BufferedReader textreader = new BufferedReader(new FileReader("chat_text.txt"))) {
            String s;
            while ((s = textreader.readLine()) != null) {
                answers.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean stopper = false;
            Iterator<String> it = answers.iterator();
            String answ = reader.readLine();
            while (!answ.equals("конец")) {
                log.append(answ + System.lineSeparator());
                if (answ.equals("стоп")) {
                    stopper = true;
                    System.out.println();
                } else if (answ.equals("продолжить") || !stopper) {
                    stopper = false;
                    String ss = it.next();
                    System.out.println(ss);
                    log.append(ss + System.lineSeparator());
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

