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
    private String inputFileNameNorth =  "";
    private String inputFileNameSouth =  "";
    private String inputFileNameEast =  "";
    private String inputFileNameWest =  "";

    private String inputFileNameNortheast =  "";
    private String inputFileNameSoutheast =  "";
    private String inputFileNameNorthwest =  "";
    private String inputFileNameSouthwest =  "";

    private ArrayList<String> wordList = null;

    public WordFinderTest()
    {
        this.wordList = new ArrayList<String>();
        this.inputFileNameAndPath =  currentPath + "/InputFiles/test/WordFinder_2.txt";
        this.inputFileNameNorth =  currentPath + "/InputFiles/test/WordFinder_North.txt";
        this.inputFileNameSouth =  currentPath + "/InputFiles/test/WordFinder_South.txt";
        this.inputFileNameEast =  currentPath + "/InputFiles/test/WordFinder_East.txt";
        this.inputFileNameWest =  currentPath + "/InputFiles/test/WordFinder_West.txt";
        this.inputFileNameNortheast =  currentPath + "/InputFiles/test/WordFinder_Northeast.txt";
        this.inputFileNameSoutheast =  currentPath + "/InputFiles/test/WordFinder_Southeast.txt";
        this.inputFileNameNorthwest =  currentPath + "/InputFiles/test/WordFinder_Northwest.txt";
        this.inputFileNameSouthwest =  currentPath + "/InputFiles/test/WordFinder_Southwest.txt";

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

    @Test
    public void getNorthWordsTest()
    {
        WordFinder thisWordFinder = new WordFinder();
        try
        {
            this.wordList = thisWordFinder.loadPuzzle(inputFileNameNorth);
        }
        catch(IOException e)
        {

        }

        ArrayList<IWord> foundWordsList = thisWordFinder.searchForWords(this.wordList);
        for(IWord thisWord : foundWordsList)
        {
            assertTrue(this.wordList.contains(thisWord.getWord()));
        }
    }

    @Test
    public void getSouthWordsTest()
    {
        WordFinder thisWordFinder = new WordFinder();
        try
        {
            this.wordList = thisWordFinder.loadPuzzle(inputFileNameSouth);
        }
        catch(IOException e)
        {

        }

        ArrayList<IWord> foundWordsList = thisWordFinder.searchForWords(this.wordList);
        for(IWord thisWord : foundWordsList)
        {
            assertTrue(this.wordList.contains(thisWord.getWord()));
        }
    }

    @Test
    public void getEastWordsTest()
    {
        WordFinder thisWordFinder = new WordFinder();
        try
        {
            this.wordList = thisWordFinder.loadPuzzle(inputFileNameEast);
        }
        catch(IOException e)
        {

        }

        ArrayList<IWord> foundWordsList = thisWordFinder.searchForWords(this.wordList);
        for(IWord thisWord : foundWordsList)
        {
            assertTrue(this.wordList.contains(thisWord.getWord()));
        }
    }

    @Test
    public void getWestWordsTest()
    {
        WordFinder thisWordFinder = new WordFinder();
        try
        {
            this.wordList = thisWordFinder.loadPuzzle(inputFileNameWest);
        }
        catch(IOException e)
        {

        }

        ArrayList<IWord> foundWordsList = thisWordFinder.searchForWords(this.wordList);
        for(IWord thisWord : foundWordsList)
        {
            assertTrue(this.wordList.contains(thisWord.getWord()));
        }
    }

    @Test
    public void getNortheastWordsTest()
    {
        WordFinder thisWordFinder = new WordFinder();
        try
        {
            this.wordList = thisWordFinder.loadPuzzle(inputFileNameNortheast);
        }
        catch(IOException e)
        {

        }

        ArrayList<IWord> foundWordsList = thisWordFinder.searchForWords(this.wordList);
        for(IWord thisWord : foundWordsList)
        {
            assertTrue(this.wordList.contains(thisWord.getWord()));
        }
    }

    @Test
    public void getSoutheastWordsTest()
    {
        WordFinder thisWordFinder = new WordFinder();
        try
        {
            this.wordList = thisWordFinder.loadPuzzle(inputFileNameSoutheast);
        }
        catch(IOException e)
        {

        }

        ArrayList<IWord> foundWordsList = thisWordFinder.searchForWords(this.wordList);
        for(IWord thisWord : foundWordsList)
        {
            assertTrue(this.wordList.contains(thisWord.getWord()));
        }
    }

    @Test
    public void getNorthwestWordsTest()
    {
        WordFinder thisWordFinder = new WordFinder();
        try
        {
            this.wordList = thisWordFinder.loadPuzzle(inputFileNameNorthwest);
        }
        catch(IOException e)
        {

        }

        ArrayList<IWord> foundWordsList = thisWordFinder.searchForWords(this.wordList);
        for(IWord thisWord : foundWordsList)
        {
            assertTrue(this.wordList.contains(thisWord.getWord()));
        }
    }


    @Test
    public void getSouthwestWordsTest()
    {
        WordFinder thisWordFinder = new WordFinder();
        try
        {
            this.wordList = thisWordFinder.loadPuzzle(inputFileNameSouthwest);
        }
        catch(IOException e)
        {

        }

        ArrayList<IWord> foundWordsList = thisWordFinder.searchForWords(this.wordList);
        for(IWord thisWord : foundWordsList)
        {
            assertTrue(this.wordList.contains(thisWord.getWord()));
        }
    }

}
