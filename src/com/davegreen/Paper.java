package com.davegreen;

/**
 * Created by daveg on 24/06/2017.
 */
public class Paper
{
    private int amount;
    private String colour;
    private String size;


    public Paper(String colour, String size)
    {
        this.amount = 100;
        this.colour = colour;
        this.size = size;
    }

    public int getAmount()
    {
        return amount;
    }
}
