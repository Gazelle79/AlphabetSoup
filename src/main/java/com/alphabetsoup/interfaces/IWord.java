package com.alphabetsoup.interfaces;


/**
 * Stores a word, and all information relevant to it, from the wordList in "WordFinder.txt" when its' found in
 * the crossword puzzle.
 */
public interface IWord {

    /**
     Returns the word found in the wordList.

     @return The word found in the crossword puzzle, as a String.
     */
    String getWord();

    /**
     Returns the starting X coordinate for this word.

     @return The starting X coordinate for this word.
     */
    int getStartingRow();

    /**
     Returns the starting Y coordinate for this word.

     @return The starting Y coordinate for this word.
     */
    int getStartingColumn();

    /**
     Returns the ending X coordinate for this word.

     @return The ending X coordinate for this word.
     */
    int getEndingRow();

    /**
     Returns the ending Y coordinate for this word.

     @return Returns the ending X coordinate for this word.
     */
    int getEndingColumn();
}
