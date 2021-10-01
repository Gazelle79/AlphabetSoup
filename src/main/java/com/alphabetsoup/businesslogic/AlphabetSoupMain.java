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

        if(args.length > 1)
        {
            inputFileNameAndPath =  args[0];
        }

        //Load grid dimensions, grid letters, and grid words.
        WordFinder finder = new WordFinder();
        try
        {
            ArrayList<String> wordsToSearch = null;
            wordsToSearch = finder.LoadPuzzle(inputFileNameAndPath);
            ArrayList<IWord> wordsFound = finder.SearchForWords(wordsToSearch);

            for(IWord thisWord: wordsFound)
            {
                System.out.println("Word found: "
                        + thisWord.getWord() + " " + "[" + thisWord.getStartingRow() + ", " + thisWord.getStartingColumn() + "] "
                        + "[" + thisWord.getEndingRow() + ", " + thisWord.getEndingColumn() + "] "
                );
            }

        }
        catch(Exception e)
        {
            System.out.println("Something went wrong: " + e.getMessage());
        }

    }

}