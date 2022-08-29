package com.alphabetsoup.businesslogic;

import com.alphabetsoup.interfaces.IWord;

import java.io.*;
import java.util.ArrayList;

/***
 * @author Frederick Boyd Jr.
 */

public class AlphabetSoupMain
{

    /**
     Reads in a crossword puzzle, dimensions of that crossword puzzle, and a list of words to find in that crossword
     puzzle, from a directory. If a word from the word list if found, it's printed as output, with its' starting &
     ending crossword puzzle coordinates.

     @param args a filename and path to "WordFinder.txt", where all properly formatted information for WordFinder lives.
     @return None. text is output to the screen.

     */
    public static void main(String[] args)
    {
        String currentPath = new File("").getAbsolutePath();
        String inputFileNameAndPath =  currentPath + "/InputFiles/main/WordFinder.txt";

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
