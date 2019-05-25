package com.davegreen;

/**
 * Created by daveg on 24/06/2017.
 */
public class InkCartridge
{
    private int inkCartridgeSize;
    private String colour;


    public InkCartridge(String colour)
    {
        this.inkCartridgeSize = 70;
        this.colour = colour;
    }

    public int getInkCartridgeSize()
    {
        return inkCartridgeSize;
    }
}
