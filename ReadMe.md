# ALPHABET SOUP  :spaghetti:


SUMMARY
-------
**A java application that finds all words in a crossword puzzle.** It reads the following from a file:

 - Puzzle dimensions 
 - The puzzle itself
 - A list of words to search for

For all words found, the following is printed as output:

 - The word
 - Starting X & Y coordinates of that word
 - Ending X & Y coordinates of that word

**Alphabet Soup doesn't have a GUI. It's run from a command prompt.**

####  Input Parameters: 
 -  ``fileNameAndPath``  

    - STRING. Path to the input file containing the crossword puzzle, puzzle dimensions, and words to find. [Default value: "./InputFiles/WordFinderInput.txt"]  

####  Input:

Data is read in from:

- ``.../AlphabetSoup/InputFiles/WordFinderInput.txt``

- ``.../AlphabetSoup/InputFiles/WordFinderInput_2.txt`` (For unit tests only.)

#### OPTIONAL: A user can specify their own input file path.

REQUIREMENTS
------------
- [x] Java 14 or higher 
(https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html)
- [x] Apache Maven 3.6.2 or higher
(https://maven.apache.org/download.cgi)


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


