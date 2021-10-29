package com.alphabetsoup.businesslogic;

import com.alphabetsoup.interfaces.IWord;

import java.io.*;
import java.util.ArrayList;

public class AlphabetSoupMain
{

    public static void main(String[] args)
    {
        String currentPath = new File("").getAbsolutePath();
        String inputFileNameAndPath =  currentPath + "/InputFiles/WordFinderInput.txt";

        if(args.length >= 1)
        {
            inputFileNameAndPath =  args[0];
        }
        //else, no args provided. inputFileNameAndPath is already set.

        //Load grid dimensions, grid letters, and words.
        WordFinder finder = new WordFinder();
        try
        {
            ArrayList<String> wordsToSearch = null;
            wordsToSearch = finder.loadPuzzle(inputFileNameAndPath);
            ArrayList<IWord> wordsFound = finder.searchForWords(wordsToSearch);

            if(wordsFound.size() > 0)
            {
                //System.out.println("Words found: ");

                System.out.println("\n");
                for (IWord thisWord : wordsFound)
                {
                    System.out.println(thisWord.getWord() + " " + thisWord.getStartingRow() + ":" + thisWord.getStartingColumn()
                            + " " + thisWord.getEndingRow() + ":" + thisWord.getEndingColumn()
                    );
                }
                System.out.println("\n");
            }
            else
            {
                System.out.println("No words found.");
            }

        }
        catch(Exception e)
        {
            System.out.println("Something went wrong: " + e.getMessage());
        }

    }

}
