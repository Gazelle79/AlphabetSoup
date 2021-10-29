package com.alphabetsoup.unittests;

import com.alphabetsoup.interfaces.IWord;
import com.alphabetsoup.businesslogic.Word;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class WordTest
{
    private Integer startingX = 0;
    private Integer startingY = 0;
    private Integer endingX = 0;
    private Integer endingY = 0;
    private String testWord1 = "";
    private String testWord2 = "";


    public WordTest()
    {
        this.startingX = 0;
        this.startingY = 0;
        this.endingX = 4;
        this.endingY = 4;
        this.testWord1 = "SPACE";
        this.testWord2 = "CONCENTRATE";
    }

    @Test
    public void CreateWordTest_1()
    {
        IWord thisWord = new Word(testWord1, startingX, startingY, endingX, endingY);

        assertEquals(thisWord.getStartingRow(), 0);
        assertEquals(thisWord.getStartingColumn(), 0);
        assertEquals(thisWord.getEndingRow(), 4);
        assertEquals(thisWord.getEndingColumn(), 4);
        assertEquals(thisWord.getWord(), "SPACE");
    }

    @Test
    public void CreateWordTest_2()
    {
        this.startingX = 0;
        this.startingY = 0;
        this.endingX = 10;
        this.endingY = 10;

        IWord thisWord = new Word(testWord2, startingX, startingY, endingX, endingY);

        assertEquals(thisWord.getStartingRow(), 0);
        assertEquals(thisWord.getStartingColumn(), 0);
        assertEquals(thisWord.getEndingRow(), 10);
        assertEquals(thisWord.getEndingColumn(), 10);
        assertEquals(thisWord.getWord(), "CONCENTRATE");
    }

}
