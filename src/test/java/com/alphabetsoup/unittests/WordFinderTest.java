package com.alphabetsoup.unittests;

import com.alphabetsoup.businesslogic.WordFinder;
import com.alphabetsoup.interfaces.IWord;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class WordFinderTest
{
    private String currentPath = new File("").getAbsolutePath();
    private String inputFileNameAndPath =  "";
    private ArrayList<String> wordList = null;

    public WordFinderTest()
    {
        this.wordList = new ArrayList<String>();
        this.inputFileNameAndPath =  currentPath + "/InputFiles/WordFinderInput_2.txt";
    }

    @Test
    public void getWordListTest()
    {
        WordFinder thisWordFinder = new WordFinder();
        try
        {
            this.wordList = thisWordFinder.loadPuzzle(inputFileNameAndPath);
        }
        catch(IOException e)
        {

        }

        for(String thisWord : wordList)
        {
            assertTrue(this.wordList.contains(thisWord));
        }
    }

    @Test
    public void getWordsTest()
    {
        WordFinder thisWordFinder = new WordFinder();
        try
        {
            this.wordList = thisWordFinder.loadPuzzle(inputFileNameAndPath);
        }
        catch(IOException e)
        {

        }

        ArrayList<IWord> foundWordsList = thisWordFinder.searchForWords(this.wordList);
        for(IWord thisWord : foundWordsList)
        {
            assertTrue(foundWordsList.contains(thisWord));
        }
    }



}
