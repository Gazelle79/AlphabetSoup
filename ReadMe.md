# ALPHABET SOUP  :camel:


SUMMARY
-------
**A java application that finds all words in a crossword puzzle.** It reads the following from a file: , , and a list of words to find, from a file. Please see the included problem statement for specific details.

 - Puzzle dimensions 
 - The puzzle itself
 - A list of words to search for

For all words found, their start & end coordinates are printed to the screen. 

**Alphabet Soup doesn't have a GUI. It's run from a command prompt.**

####  Input Parameters: 
 -  ``fileNameAndPath``  

    - STRING. Path to the input file containing the crossword puzzle, puzzle dimensions, and words to find. [Default value: "./InputFiles/WordFinderInput.txt"]  

####  Input:

Data is read in from:

- ``WordFinderInput.txt``

  Location:``.../AlphabetSoup/InputFiles/WordFinderInput.txt``

A user can optionally specify their own input file path.

REQUIREMENTS
------------
- [x] Java 14 or higher 
(https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html)


OPTIONAL
--------
- [x] JUnit 4.12 or higher
 

TO START
--------
 - Open a command prompt in Linux or Windows.
 - Change directories to the location of Alphabet Soup.
 - Compile the application.
 - Execute the application.

### COMPILING Alphabet Soup:
`` mvn clean compile ``


### EXECUTING AlphabetSoup:
#### without any arguments:
 - ``mvn exec:java ``

The default value for ``fileNameAndPath`` is used if no argument is provided.


#### with an argument (a path to an input file):
 - ``mvn exec:java -Dexec.args="../path/To/Your/File.txt" ``


