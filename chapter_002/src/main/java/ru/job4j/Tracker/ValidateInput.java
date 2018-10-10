package ru.job4j.Tracker;

import java.util.ArrayList;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, ArrayList<Integer> ranges){
      int value=Integer.valueOf(this.ask(question));
      boolean exist= false;
      for(Integer i: ranges){
          System.out.println(i);
          if(value==(int)i){
                exist=true;
          }
      }
      if(exist){
          return value;
      }else throw new MenuOutException ("Please select key from menu.");
    }
}
