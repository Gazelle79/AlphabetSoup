package com.alphabetsoup.businesslogic;

import com.alphabetsoup.interfaces.*;

public class Word implements IWord {
    private String word = "";
    private int startingRow = 0;
    private int startingColumn = 0;
    private int endingRow = 0;
    private int endingColumn = 0;


    @Override
    public String getWord()
    {
        return word;
    }

    @Override
    public int getStartingRow()
    {
        return startingRow;
    }

    @Override
    public int getStartingColumn()
    {
        return startingColumn;
    }

    @Override
    public int getEndingRow()
    {
        return endingRow;
    }

    @Override
    public int getEndingColumn()
    {
        return endingColumn;
    }


    /**
     Constructor.
     @param word A word hidden in the puzzle.
     @param startingRow The starting X coordinate of a word.
     @param startingColumn The starting Y coordinate of a word.
     @param endingRow The ending X coordinate of a word.
     @param endingColumn The ending Y coordinate of a word.
     @return A word, with its' start & end coordinates, on each axis.
     @see IWord
     */
    public Word(String word, int startingRow, int startingColumn, int endingRow, int endingColumn)
    {
        this.word = word;
        this.startingRow = startingRow;
        this.startingColumn = startingColumn;
        this.endingRow = endingRow;
        this.endingColumn = endingColumn;
    }


}
