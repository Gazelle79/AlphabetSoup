package com.alphabetsoup.businesslogic;

import com.alphabetsoup.interfaces.IWord;

import java.util.ArrayList;
import java.io.*;

public class WordFinder {
    private String fileNameAndPath = "";
    private int rows = 0;
    private int columns = 0;
    private char grid[][] = null;


    public WordFinder()
    {

    }

    public ArrayList<String> LoadPuzzle(String filenameAndPath) throws IOException
    {
        ArrayList<String> wordList = new ArrayList<>();

        this.grid = new char[0][0];
        this.fileNameAndPath = filenameAndPath;

        BufferedReader reader = null;

        /*Not put in try / catch statement so error could be sent back to method caller.*/
        InputStream is = new FileInputStream(fileNameAndPath);
        reader = new BufferedReader(new InputStreamReader(is));

        //Load puzzle dimensions.
        String thisLine = reader.readLine();
        this.rows = Integer.parseInt(thisLine.split("x")[0]);
        this.columns = Integer.parseInt(thisLine.split("x")[1]);
        this.grid = new char[rows][columns];

        int rowNumber = 0;
        int columnNumber = 0;

        //Load grid letters first.
        while ((thisLine = reader.readLine()) != null)
        {
            columnNumber = 0;
            String[] characters = thisLine.split(" ");
            for(int i = 0; i < characters.length; i++)
            {
                grid[rowNumber][columnNumber] = characters[i].charAt(0);
                columnNumber++;
            }
            rowNumber++;

            if( rowNumber ==  rows)
            {
                break;
            }
        }

        // Load the list of words.
        while((thisLine = reader.readLine()) != null)
        {
            String thisWord = thisLine.trim();
            wordList.add(thisWord);
        }

        System.out.println("Grid, dimensions, & words loaded.");
        reader.close();

        return wordList;
    }

    //Start searching for words here.
    public ArrayList<IWord> SearchForWords(ArrayList<String> words)
    {
        ArrayList<IWord> results = new ArrayList<IWord>();

        for(int r = 0; r < rows; r++)
        {
            for(int c = 0; c < columns; c++)
            {
                for(String word : words)
                {
                    IWord thisWord = this.searchGrid(r, c, word);
                    if(thisWord != null)
                    {
                        results.add(thisWord);
                    }
                }
            }
        }

        return results;
    }

    private IWord searchGrid(int row, int column, String word)
    {
        IWord thisWord = this.searchSouthEast(word, row, column);
        //IWord thisWord = this.searchEast(word, row, column);
        return thisWord;

    }

    private IWord searchEast(String word, int row, int column)
    {
        IWord wordToReturn = null;
        StringBuilder wordBuilder = new StringBuilder();

        for( int c = column; c >= 0 && c < columns; c++ )
        {
            wordBuilder.append(grid[row][c]);

            if(wordBuilder.length() == word.length() && word.equals(wordBuilder.toString()) )
            {
                wordToReturn = new Word(wordBuilder.toString(), row, c, row, column);
                break;
            }
        }

        return wordToReturn;
    }

    private void searchWest()
    {
        //Move backward in the grid.
    }

    private void searchNorth()
    {
        //Move up in the grid.
    }

    private void searchSouth()
    {
        //Move down in the grid.
    }

    private void searchNorthEast()
    {
        //Move NorthEast in the grid.
    }

    private void searchNorthWest()
    {
        //Move NorthWest in the grid.
    }

    private IWord searchSouthEast(String word, int row, int column)
    {
        IWord wordToReturn = null;
        StringBuilder wordBuilder = new StringBuilder();

        for( int r = row, c = column; r >= 0 && c >= 0 && r < rows && c < columns; r++, c++ )
        {
            wordBuilder.append(grid[r][c]);
            if (wordBuilder.length() == word.length() && word.equals(wordBuilder.toString()))
            {
                wordToReturn = new Word(wordBuilder.toString(), row, column, r, c);
                break;
            }
        }

        return wordToReturn;
    }

    private void searchSouthWest()
    {
        //Move SouthWest in the grid.
    }


}


