package com.alphabetsoup.businesslogic;

import com.alphabetsoup.interfaces.IWord;

import java.util.ArrayList;
import java.io.*;

public class WordFinder {
    private String fileNameAndPath = "";
    private int rows = 0;
    private int columns = 0;
    private char grid[][] = null;



    //search in all directions for a word.
    private static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

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
    public void SearchForWords(ArrayList<String> words)
    {
        ArrayList<IWord> results = new ArrayList<>();

        for(int r = 0; r < rows; r++)
        {
            for(int c = 0; c < columns; c++)
            {
                for(String word : words)
                {
                    this.searchGrid(r, c, word);
                }
            }
        }

        //return results <-- Work toward this.
    }

    private void searchGrid(int row, int column, String word)
    {
        //Is this grid char the same as the first char of the word we want?
        if(this.grid[row][column] == word.charAt(0))
        {
            //Yes: Look in all 8 directions.
            //The index(es) of the next matching char tells us the direction we need to search in.

            for(int direction=0; direction < 8; direction++)
            {
                int rowDirection = row + x[direction];
                int columnDirection = column + y[direction];

                //Don't go outside of grid bounds while looking in all 8 directions!
                if(rowDirection <= row && rowDirection > 0 && columnDirection <= column && columnDirection > 0)
                {
                    rowDirection += x[direction];
                    columnDirection += y[direction];

                    if (grid[rowDirection][columnDirection] == word.charAt(1))
                    {
                        System.out.println("We got a next character!: " + word.charAt(1));
                    }
                }

            }
        }


    }

    private void serachEast()
    {
        //Move forward in the grid.
    }

    private void serachWest()
    {
        //Move backward in the grid.
    }

    private void serachNorth()
    {
        //Move up in the grid.
    }

    private void serachSouth()
    {
        //Move down in the grid.
    }

    private void serachNorthEast()
    {
        //Move NorthEast in the grid.
    }

    private void serachNorthWest()
    {
        //Move NorthWest in the grid.
    }

    private void serachSouthEast()
    {
        //Move SouthEast in the grid.
    }

    private void serachSouthWest()
    {
        //Move SouthWest in the grid.
    }


}


