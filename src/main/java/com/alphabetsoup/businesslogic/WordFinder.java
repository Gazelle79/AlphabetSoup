package com.alphabetsoup.businesslogic;

import com.alphabetsoup.interfaces.IWord;

import java.util.ArrayList;
import java.io.*;

/**
 * Reads in a crossword puzzle, it's dimensions, and a list of words to find. Returns a list of all words found,
 * with start & end coordinates.
 */
public class WordFinder {
    private String fileNameAndPath = "";
    private int rows = 0;
    private int columns = 0;
    private char grid[][] = null;

    /***
     * Empty constructor.
     */
    public WordFinder()
    {

    }

    /**
     Reads the contents of the puzzle's words, dimensions, and the puzzle itself.

     @param filenameAndPath Path to a text file containing the puzzle, puzzle dimensions, and word list.
     @return ArrayList of words, with start and end coordinates, hidden in the puzzle.
     */
    public ArrayList<String> loadPuzzle(String filenameAndPath) throws IOException
    {
        ArrayList<String> wordList = new ArrayList<>();
        this.fileNameAndPath = filenameAndPath;

        BufferedReader reader = null;

        /*Not put in try / catch statement so error could be sent back to method caller.*/
        InputStream is = new FileInputStream(fileNameAndPath);
        reader = new BufferedReader(new InputStreamReader(is));

        //Load puzzle dimensions.
        String thisLine = reader.readLine();
        String[] dimensions = thisLine.split("x");
        this.rows = Integer.parseInt(dimensions[0]);
        this.columns = Integer.parseInt(dimensions[1]);
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

        //System.out.println("Grid, dimensions, & words loaded.");
        reader.close();

        return wordList;
    }

    /**
     Start searching for all words in the puzzle here.

     @param words ArrayList of all words hidden in the puzzle.
     @return ArrayList of all words, with start and end coordinates, found from searching in all directions.
     @see com.alphabetsoup.interfaces.IWord
     */
    public ArrayList<IWord> searchForWords(ArrayList<String> words)
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
                if(c >= 0  && r >= 0 )
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

    /**
     Search for words, East.

     @param  words ArrayList of all words hidden in the puzzle.
     @param  row the starting row to search on.
     @param  column the starting column to search on.
     @return  ArrayList of all words found, with start & end coordinates.
     @see com.alphabetsoup.interfaces.IWord
     */
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

    /**
     Search for words, West.

     @param words ArrayList of all words hidden in the puzzle.
     @param row the starting row to search on.
     @param column the starting column to search on.
     @return ArrayList of all words found, with start & end coordinates.
     @see com.alphabetsoup.interfaces.IWord
     */
    private ArrayList<IWord> searchWest(ArrayList<String> words, int row, int column)
    {
        ArrayList<IWord> wordsFound = new ArrayList<IWord>();
        StringBuilder wordBuilder = new StringBuilder();

        for( int c = column; c >= 0 && c < columns; c-- )
        {
            wordBuilder.append(grid[row][c]);
            String newWord = wordBuilder.toString();
            if(words.contains(newWord))
            {
                IWord thisWord = new Word(newWord, row, column, row, c);
                wordsFound.add(thisWord);
            }
        }

        return wordsFound;
    }

    /**
     Search for words, North.

     @param words ArrayList of all words hidden in the puzzle.
     @param row the starting row to search on.
     @param column the starting column to search on.
     @return ArrayList of all words found, with start & end coordinates.
     @see com.alphabetsoup.interfaces.IWord
     */
    private ArrayList<IWord> searchNorth(ArrayList<String> words, int row, int column)
    {
        ArrayList<IWord> wordsFound = new ArrayList<IWord>();
        StringBuilder wordBuilder = new StringBuilder();

        for( int r = row; r >= 0 && r < rows; r-- )
        {
            wordBuilder.append(grid[r][column]);
            String newWord = wordBuilder.toString();
            if(words.contains(newWord))
            {
                IWord thisWord = new Word(newWord, row, column, r, column);
                wordsFound.add(thisWord);
            }
        }

        return wordsFound;
    }

    /**
     Search for words, South.

     @param words ArrayList of all words hidden in the puzzle.
     @param row the starting row to search on.
     @param column the starting column to search on.
     @return ArrayList of all words found, with start & end coordinates.
     @see com.alphabetsoup.interfaces.IWord
     */
    private ArrayList<IWord> searchSouth(ArrayList<String> words, int row, int column)
    {
        ArrayList<IWord> wordsFound = new ArrayList<IWord>();
        StringBuilder wordBuilder = new StringBuilder();

        for( int r = row; r >= 0 && r < rows; r++)
        {
            wordBuilder.append(grid[r][column]);
            String newWord = wordBuilder.toString();
            if(words.contains(newWord))
            {
                IWord thisWord = new Word(newWord, row, column, r, column);
                wordsFound.add(thisWord);
            }
        }

        return wordsFound;
    }

    /**
     Search for words, Northeast.

     @param words ArrayList of all words hidden in the puzzle.
     @param row the starting row to search on.
     @param column the starting column to search on.
     @return ArrayList of all words found, with start & end coordinates.
     @see com.alphabetsoup.interfaces.IWord
     */
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

    /**
     Search for words, Northwest.

     @param words ArrayList of all words hidden in the puzzle.
     @param row the starting row to search on.
     @param column the starting column to search on.
     @return ArrayList of all words found, with start & end coordinates.
     @see com.alphabetsoup.interfaces.IWord
     */
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

    /**
     Search for words, Southeast.

     @param words ArrayList of all words hidden in the puzzle.
     @param row the starting row to search on.
     @param column the starting column to search on.
     @return ArrayList of all words found, with start & end coordinates.
     @see com.alphabetsoup.interfaces.IWord
     */
    private ArrayList<IWord> searchSouthEast(ArrayList<String> words, int row, int column)
    {
        ArrayList<IWord> wordsFound = new ArrayList<IWord>();
        StringBuilder wordBuilder = new StringBuilder();

        for( int r = row, c = column; r >= 0 && c >= 0 && r < rows && c < columns; r++, c++ )
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

    /**
     Search for words, Southwest.

     @param words ArrayList of all words hidden in the puzzle.
     @param row the starting row to search on.
     @param column the starting column to search on.
     @return ArrayList of all words found, with start & end coordinates.
     @see com.alphabetsoup.interfaces.IWord
     */
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


