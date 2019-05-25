package com.davegreen;

public class Main
{

    public static void main(String[] args)
    {
        Printer printer = new Printer(15, 20,true);

        printer.printPages(50);

        InkCartridge inkCartridge = new InkCartridge("Black");

        printer.addInk();

        printer.printPages(30);

        printer.addPaper();

        printer.printPages(20);

        Printer notDuplex = new Printer(25, 90, false);

        notDuplex.printPages(30);

        notDuplex.addInk();

        notDuplex.printPages(70);

        notDuplex.addPaper();

        notDuplex.printPages(20);
    }
}
