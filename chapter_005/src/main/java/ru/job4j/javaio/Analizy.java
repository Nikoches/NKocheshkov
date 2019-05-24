package ru.job4j.javaio;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        StringBuffer bufer = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(source))) {
            String s;
            String b="";
            int checker = 0;
            while ((s = br.readLine()) != null) {
                if(s.contains("500")||s.contains("400") && !s.equals("")){
                    checker++;
                    b = checker == 1 ? s : b;
                    if(checker >= 2){
                        if(checker == 2){
                            bufer.append(b + "\n").append(s + "\n");
                        }else bufer.append(s + "\n");
                    }
                }else if (!s.equals("")) checker = 0;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            out.println(bufer);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Analizy ss = new Analizy();
        ss.unavailable("server.log","unavailable.csv");

    }
}