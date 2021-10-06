package com.alphabetsoup.businesslogic;

import com.alphabetsoup.interfaces.*;

public class Word implements IWord {
    private String word = "";
    private int startingRow = 0;
    private int startingColumn = 0;
    private int endingRow = 0;
    private int endingColumn = 0;


    @Override
    /**
     *The word we're searching for.
     **/
    public String getWord()
    {
        return word;
    }

    @Override
    /**
    The starting X coordinate of this word.
    */
    public int getStartingRow()
    {
        return startingRow;
    }

    @Override
    /**
     The starting Y coordinate of this word.
     */
    public int getStartingColumn()
    {
        return startingColumn;
    }

    @Override
    /**
     The ending X coordinate of this word.
     */
    public int getEndingRow()
    {
        return endingRow;
    }

    @Override
    /**
     The ending Y coordinate of this word.
     */
    public int getEndingColumn()
    {
        return endingColumn;
    }


    /**
     Constructor.
     Returns: A word, with its' start & end coordinates, on each axis.
     @param word - A word hidden in the puzzle.
     @param startingRow - The starting X coordinate of this word.
     @param startingColumn - The starting Y coordinate of this word.
     @param endingRow - The ending X coordinate of this word.
     @param endingColumn - The ending Y coordinate of this word.
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
