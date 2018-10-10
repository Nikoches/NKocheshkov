package ru.job4j.Tracker;
import java.util.*;
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
    public int ask (String question,ArrayList<Integer> ranges){
        int key = Integer.valueOf(this.ask(question));
        boolean exist= false;
        for (Integer value:ranges){
            if (value == key){
                exist=true;
                break;
            }
        }
        if (exist){
            return key;
        }else{
            throw new MenuOutException("You are out of menu range");
        }
    }
}
