package singleton;

import java.util.*;

public class Singleton {

    private int ticket;
    private Singleton(int ticket){
        this.ticket = ticket;
    }

    private static Singleton instance;

    public static Singleton getInstance(int number){
        if(instance == null) {
            instance = new Singleton(number);
        }

        return instance;
    }

    public int getNumber(){
        return ticket;
    }

}
