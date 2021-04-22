package ru.job4j.solidprinc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInput {
    public String ask;

    public String read() {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            ask = reader.readLine();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ask;
    }

}
