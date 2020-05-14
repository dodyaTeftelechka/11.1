package com.company;

public class NeedObject {
    private int x = 0;
    private int count = 0;

    NeedObject(){

    }

    public int getX(){
        return x;
    }

    public void incrementX() {
        x++;
    }
    public void incrementCount(){
        count++;
    }

    public int getCount(){
        return count;
    }
}
