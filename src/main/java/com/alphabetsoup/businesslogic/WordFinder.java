package com.alphabetsoup.businesslogic;

import com.alphabetsoup.interfaces.IWord;

import java.util.ArrayList;
import java.io.*;
import java.util.Collections;

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
                if(r >= 0)
                {
                    results.addAll(this.searchNorth(words, r, c));
                    results.addAll(this.searchSouth(words, r, c));
                }
                if(c >= 0)
                {
                    results.addAll(this.searchEast(words, r, c));
                    results.addAll(this.searchWest(words, r, c));
                }
                if(c >= 0  && r > 0 )
                {
                    results.addAll(this.searchSouthEast(words, r, c));
                    results.addAll(this.searchNorthWest(words, r, c));
                }
                if(r >= 0 && c < columns)
                {
                    results.addAll(this.searchNorthEast(words, r, c));
                    results.addAll(this.searchSouthWest(words, r, c));
                }
            }
        }
        return results;
    }


    private ArrayList<IWord> searchEast(ArrayList<String> words, int row, int column)
    {
        ArrayList<IWord> wordsFound = new ArrayList<IWord>();
        StringBuilder wordBuilder = new StringBuilder();

        for( int c = column; c >= 0 && c < columns; c++ )
        {
            wordBuilder.append(grid[row][c]);
            String newWord = wordBuilder.toString();
            if(words.contains(newWord))
            {
                IWord thisWord = new Word(newWord, row, c, row, column);
                wordsFound.add(thisWord);
            }
        }

        return wordsFound;
    }

    private ArrayList<IWord> searchWest(ArrayList<String> words, int row, int column)
    {
        ArrayList<IWord> wordsFound = new ArrayList<IWord>();
        StringBuilder wordBuilder = new StringBuilder();

        for( int c = column; c >= 0 && c < columns; c-- )
        {
            wordBuilder.append(grid[row][c]);
            if(words.contains(wordBuilder.toString()))
            {
                IWord thisWord = new Word(wordBuilder.toString(), row, column, row, c);
                wordsFound.add(thisWord);
            }
        }

        return wordsFound;
    }

    private ArrayList<IWord> searchNorth(ArrayList<String> words, int row, int column)
    {
        ArrayList<IWord> wordsFound = new ArrayList<IWord>();
        StringBuilder wordBuilder = new StringBuilder();

        for( int r = row; r >= 0 && r < rows; r-- )
        {
            wordBuilder.append(grid[r][column]);
            if(words.contains(wordBuilder.toString()))
            {
                IWord thisWord = new Word(wordBuilder.toString(), row, column, r, column);
                wordsFound.add(thisWord);
            }
        }

        return wordsFound;
    }

    private ArrayList<IWord> searchSouth(ArrayList<String> words, int row, int column)
    {
        ArrayList<IWord> wordsFound = new ArrayList<IWord>();
        StringBuilder wordBuilder = new StringBuilder();

        for( int r = row; r >= 0 && r < rows; r++)
        {
            wordBuilder.append(grid[r][column]);
            if(words.contains(wordBuilder.toString()))
            {
                IWord thisWord = new Word(wordBuilder.toString(), row, column, r, column);
                wordsFound.add(thisWord);
            }
        }

        return wordsFound;
    }

    private ArrayList<IWord> searchNorthEast(ArrayList<String> words, int row, int column)
    {
        ArrayList<IWord> wordsFound = new ArrayList<IWord>();
        StringBuilder wordBuilder = new StringBuilder();

        for( int r = row, c = column; r >= 0 && c >= 0 && r < rows && c < columns; r--, c++ )
        {
            wordBuilder.append(grid[r][c]);
            String newWord = wordBuilder.toString();
            if (words.contains(newWord)) //Index of the word is 0 or higher. It exists in the list.
            {
                IWord thisWord = new Word(newWord, row, column, r, c);
                wordsFound.add(thisWord);
            }
        }

        return wordsFound;
    }

    private ArrayList<IWord> searchNorthWest(ArrayList<String> words, int row, int column)
    {
        ArrayList<IWord> wordsFound = new ArrayList<IWord>();
        StringBuilder wordBuilder = new StringBuilder();

        for( int r = row, c = column; r >= 0 && c >= 0 && r < rows && c < columns; r--, c-- )
        {
            wordBuilder.append(grid[r][c]);
            String newWord = wordBuilder.toString();
            if (words.contains(newWord)) //Index of the word is 0 or higher. It exists in the list.
            {
                IWord thisWord = new Word(newWord, row, column, r, c);
                wordsFound.add(thisWord);
            }
        }

        return wordsFound;
    }

    private ArrayList<IWord> searchSouthEast(ArrayList<String> words, int row, int column)
    {
        ArrayList<IWord> wordsFound = new ArrayList<IWord>();
        StringBuilder wordBuilder = new StringBuilder();

        for( int r = row, c = column; r >= 0 && c >= 0 && r < rows && c < columns; r++, c++ )
        {
            wordBuilder.append(grid[r][c]);
            String newWord = wordBuilder.toString();
            if (words.contains(wordBuilder.toString())) //Index of the word is 0 or higher. It exists in the list.
            {
                IWord thisWord = new Word(newWord, row, column, r, c);
                wordsFound.add(thisWord);
            }
        }

        return wordsFound;
    }

    private ArrayList<IWord> searchSouthWest(ArrayList<String> words, int row, int column)
    {
        ArrayList<IWord> wordsFound = new ArrayList<IWord>();
        StringBuilder wordBuilder = new StringBuilder();

        for( int r = row, c = column; r >= 0 && c >= 0 && r < rows && c < columns; r++, c-- )
        {
            wordBuilder.append(grid[r][c]);
            String newWord = wordBuilder.toString();
            if (words.contains(newWord)) //Index of the word is 0 or higher. It exists in the list.
            {
                IWord thisWord = new Word(newWord, row, column, r, c);
                wordsFound.add(thisWord);
            }
        }

        return wordsFound;
    }


}


