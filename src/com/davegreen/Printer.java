package com.davegreen;

/**
 * Created by daveg on 23/06/2017.
 */
public class Printer
{
    InkCartridge inkCartridge = new InkCartridge("Black");
    Paper paper = new Paper("Black", "A4");
    private int currentInkLevel;
    private int pagesRequired;
    private int paperRemaining;
    private boolean duplex;

    public Printer()
    {

    }

    public Printer(int currentInkLevel, int paperRemaining, boolean duplex)
    {
        if(currentInkLevel < 0 || currentInkLevel > 100)
        {
            System.out.println("You have input an incorrect value for ink level, please try a number between 0 - 100");
            System.exit(0);
        }
        else
        {
            this.currentInkLevel = currentInkLevel;
        }
        this.pagesRequired = 0;
        this.paperRemaining = paperRemaining;
        this.duplex = duplex;
    }

    public int getCurrentInkLevel()
    {
        return currentInkLevel;
    }

    public int getPaperRemaining()
    {
        return paperRemaining;
    }

    public int addInk()
    {
        int oldInkLevel = getCurrentInkLevel();
        int inkCartridgeSize = inkCartridge.getInkCartridgeSize();      // This gets the ink cartridge size from the InkCartridge classes getter.
        int newInkLevel = oldInkLevel + inkCartridgeSize;

        System.out.println("Your current ink level is " + oldInkLevel);

        if(inkCartridgeSize > 0 && inkCartridgeSize <= 100)
        {
            if(oldInkLevel + inkCartridgeSize <= 100)
            {
                System.out.println("You have replaced the ink cartridge with a cartridge size of " + inkCartridgeSize + " and your new ink level is " + newInkLevel);
                System.out.println("Continue to print?");
                this.currentInkLevel = newInkLevel;
                return newInkLevel;
            }
            else
            {
                System.out.println("You cannot add more than 100% ink");
            }
        }
        else
        {
            System.out.println("Please enter an ink cartridge amount between 1 - 100");
        }

        return -1;
    }

    public int addPaper()
    {
        int paperRemaining = getPaperRemaining();
        int replaceAmount = paper.getAmount();       // This get the paper amount from the Paper classes getter.
        int newPaperRemaining = paperRemaining + replaceAmount;

        System.out.println("You have " + paperRemaining + " sheets of paper remaining in the printer");

        if (replaceAmount > 0 && replaceAmount <= 100)
        {
            if (paperRemaining + replaceAmount <= 100)
            {
                System.out.println("You have replaced paper and the remaining paper is now " + newPaperRemaining);
                System.out.println("Continue to print?");
                this.paperRemaining = newPaperRemaining;
                return newPaperRemaining;
            }
            else
            {
                System.out.println("You cannot add more than 100% ink");
            }
        }
        else
        {
            System.out.println("Please enter an amount of paper between 1 - 100");
        }

        return -1;
    }


    public void isDuplex()
    {
        System.out.println("You are now printing in Duplex mode and your ink level is " + this.currentInkLevel + " and you have " + this.paperRemaining + " sheets of paper remaining");

        this.pagesRequired = pagesRequired / 2;     // Because this is duplex mode this takes the pages required and halves it.

        // This cycles through a loop reducing the ink by 2 each time and the paper by 1.

        for(int i = 1; i <= this.pagesRequired; i ++)
        {
            this.currentInkLevel -= 2;
            this.paperRemaining --;

            // This cycles though a short loop informing the user of which side is currently printing, 1 or 2.

            for(int j = 1; j < 3; j ++)
            {
                if(i % 2 == 0)
                {
                    System.out.println("Printing side " + j);
                }
                else
                {
                    System.out.println("Printing side " + j);
                }

            }

            System.out.println("Ink level percentage remaining is " + this.currentInkLevel + " you have " + this.paperRemaining + " sheets of paper left in the printer");

            // These check the current ink and paper levels.

            if(currentInkLevel <= 1)
            {
                System.out.println("You are low on ink please replace cartridge");
                break;
                //addInk();
            }
            else if(this.paperRemaining <= 0)
            {
                System.out.println("You are low on paper, please add more to the tray");
                break;
                //addPaper();
            }
        }
    }

    public void printPages(int pagesRequired)
    {
        this.pagesRequired = pagesRequired;

        if(this.duplex == true)
        {
            isDuplex();
        }
        else
        {
            System.out.println("You are now printing in Normal mode and your ink level is " + this.currentInkLevel + " and you have " + this.paperRemaining + " sheets of paper remaining");

            // This cycles through a loop reducing the ink and paper by 1 each iteration.

            for(int i = 1; i < this.pagesRequired; i++)
            {
                this.currentInkLevel --;
                this.paperRemaining --;

                // These check the current ink and paper levels.

                if(this.currentInkLevel <= 0)
                {
                    System.out.println("You are low on ink please replace cartridge");
                    break;
                    //addInk();  // This is for adding the ink automatically.
                }
                else if(this.paperRemaining <= 0)
                {
                    System.out.println("You are low on paper, please add more to the tray");
                    break;
                    //addPaper();   // This is for adding the paper automatically.
                }

                System.out.println("Page number " + i + " printing");

                System.out.println("Ink level percentage remaining is " + this.currentInkLevel + " you have " + this.paperRemaining + " sheets of paper left in the printer");
            }
        }
    }
}
