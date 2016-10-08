#Ticy Tacy

Ticy Tacy is a variation on the classic game Tic-Tac-Toe. 

If you are not familiar with Tic-Tac-Toe it a game where two player take turns claiming cells in a square grid until one player has a complete row either horizontally, vertically or diagonally.

The problem with these rules is that in a standard 3x3 game board players run out of unclaimed board spaces before someone has won the game. 

Ticy Tacy attempts to solve this problem by making it so players can only claim three cells at a time. If a player already has three cells claimed then they must first release their claim on one of their cells before they can claim a new cell. 

###Running
To run Ticy Tacy just download the latest release from [here](https://github.com/flutterflies/TicyTacy/releases). 

Once you have downloaded a copy of Ticy Tacy, just double click the jar file to run it. If you want to run Ticy Tacy with any of the special initial board states you will need to open a terminal or Command Prompt and run Ticy Tacy using the following command:
 ```
 java -jar /path/to/TicyTacy/jar <initializer-type>
 ```
 There are four valid initializer types:
 * Blank - Creates a blank game board (Default)
 * Random - Randomly assigns each player 3 cells on the board.
 * Crossed - Initializes the board so that player 2 controls the top and bottom cells of row 1 and the middle cell of row 3 while player 1 controls the middle cell of row 1 and the top and bottom cells of row 3. Row 2 is left blank. (Screenshot below)
 * Opposite - Initializes the board so that player 1 controls the bottom cell of the third row and player 2 controls the top cell of the first row. (Screenshot below)

###Changelog
* Version 0.1.0 - Initial Release
    * The initial release of Ticy Tacy.
* Version 0.2.0 - Initializers
    * Added three new board initializers
    
###Screenshots

#####Example game play
![Ticy Tacy](http://i.imgur.com/Zbo7seH.png)

#####Crossed Initialization
![Crossed](http://i.imgur.com/Q9j5H5j.png)

#####Opposite Initialization
![Opposite](http://i.imgur.com/RqipEy9.png)

#####Winner!
![Winner](http://i.imgur.com/MYGkZxU.png)

#####Can't claim more than three cells
![Whoopsie](http://i.imgur.com/XvWGepq.png)