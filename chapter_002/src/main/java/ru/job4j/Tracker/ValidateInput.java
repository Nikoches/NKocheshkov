package ru.job4j.Tracker;

public class ValidateInput extends ConsoleInput {
    public int ask(String question,int [] ranges){
        boolean invalid = true;
        int value= -1;
        do{
            try{
            value=super.ask(question,ranges);
            invalid=false;

             } catch(NumberFormatException nfe){
            System.out.println("Please eneter valide Data");
        }catch(MenuOutException menu){
                System.out.println("You are out of menu range");
            }
    }while(invalid);
        return(value);
    }

}
