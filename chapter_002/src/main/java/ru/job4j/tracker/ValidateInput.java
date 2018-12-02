package ru.job4j.tracker;

import java.util.*;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, List<Integer> ranges) {
      int value = 0;
      boolean exist = true;
        do {
            try {
                // value = Integer.valueOf(this.ask(question));
                value = this.input.ask(question, ranges);
                // exist = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
            exist = false;
        } while (exist);
        return  value;
    }
}
