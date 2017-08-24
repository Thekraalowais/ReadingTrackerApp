package com.example.thekra.readingtrackerapp;

/**
 * Created by Thekra on 8/24/2017.
 */

public class Book  {
    private String bName;
    private int bPage;
    private int bRate;

    public Book(String name, int page, int rate) {
        bName = name;
        bPage=page;
        bRate=rate;
    }
    public String getName(){
    return bName;
    }
    public int getPages(){
        return bPage;
    }
    public int getRate(){
        return bRate;
    }
}
