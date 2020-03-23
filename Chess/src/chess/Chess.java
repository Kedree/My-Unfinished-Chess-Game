package chess;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Author: Kedree Anthony Proffitt of Davison Michigan USA */

public class Chess 
{
    private static int checkKings(Board gameBoard) // checks to see if both kings are alive
    { // TODO CONVERT CHECKKINGS TO RETURN AN INT, IF BLACK KING IS GONE RETURN 1 IF WHITE KING IS GONE RETURN 2 ELSE RETURN 0
        boolean blackKingAlive = true;// from here
        boolean whiteKingAlive = true;
        for (int r = 0; r < 8; r++) 
        {
            for (int c = 0; c < 8; c++) 
            {
                if (gameBoard.getBoard()[r][c].getInitials().equals("B+1")) 
                {
                    blackKingAlive = true;
                    c = 8;
                    r = 8;
                }
            }
        }
        for (int r = 0; r < 8; r++) 
        {
            for (int c = 0; c < 8; c++) 
            {
                if (gameBoard.getBoard()[r][c].getInitials().equals("W+1")) 
                {
                    whiteKingAlive = true;
                    c = 8;
                    r = 8;
                }
            }
        }
        if (whiteKingAlive == false) // to here make a method
            return 1;
        else if (blackKingAlive == false)
            return 2;
        else
            return 0;
    }

    private static void playerTurn(String playerColor, Board gameBoard) 
    {
        Scanner in = new Scanner(System.in);
        if (playerColor.equals("W")) 
            System.out.println("Player White, please select a piece to move by entering its name into the console.");
        else 
            System.out.println("Player Black, please select a piece to move by entering its name into the console.");
        
        String enteredInitials = in.nextLine();
        boolean hasMovedAPiece = false;
        boolean falseSelection = true;
        boolean endOfTurn = false;
        int[] coords = new int[2];
        int selectionNum = 0;
        int r = 0;
        int c = 0;
        while (endOfTurn == false) 
        {
            while (falseSelection == true) // if you have not selected a piece that is valid try again
            {
                r = 0;
                //System.out.println(!enteredInitials.substring(0, 1).equalsIgnoreCase(playerColor));
                if (!enteredInitials.substring(0, 1).equalsIgnoreCase(playerColor))
                {
                    System.out.println("Please pick a piece that is your color!");
                    r = 8;
                    c = 8;
                }
                for (; r < 8; r++) 
                {
                    for (c = 0; c < 8; c++) 
                    {
                        if (gameBoard.getBoard()[r][c].getInitials().equalsIgnoreCase(enteredInitials)) // goes through whole board looking for entered initials
                        {
                            falseSelection = false;
                            coords[0] = r;
                            coords[1] = c;
                            r = 8;
                            c = 8;
                        } 
                        else 
                            falseSelection = true;
                    }
                }
                if (falseSelection == true) // if you failed make you try again
                {
                    System.out.println("Please choose a correct piece.");
                    enteredInitials = in.nextLine();
                }
            }
            System.out.println(enteredInitials.substring(0, 2));
            while (hasMovedAPiece == false) // if you have not moved a piece for whatever reason, you have to keep trying
            {
                int n = 0;
                String enteredSelection = "";
                ArrayList<String> possibleMovesGiven = gameBoard.getBoard()[coords[0]][coords[1]].getLegalMoves(coords, gameBoard);
                
                for(String move : possibleMovesGiven)
                {
                    n++;
                    System.out.println(n + ": " + move);
                }
                if (possibleMovesGiven.size() <= 0)
                {
                    System.out.println("Sorry, there are no possible choices for this piece, please choose another.");
                    enteredSelection = "0";
                }
                else
                {
                    System.out.println("Please select one of the above choices by entering the number shown, enter 0 if you wish to select a different piece.");
                    enteredSelection = in.nextLine();
                }
                System.out.println(enteredSelection); // dude
                selectionNum = Integer.parseInt(enteredSelection);
                if (selectionNum == 0 || selectionNum > n)
                {
                    // do something that makes them choose another piece
                }
                else
                {
                    System.out.println(possibleMovesGiven.get(selectionNum - 1));
                    Matcher m = Pattern.compile("[^0-9]*([0-9]+).*").matcher(possibleMovesGiven.get(selectionNum));
                    if (m.matches()) 
                    {
                        System.out.println(m.group(1));
                    }
                    movePiece(-2, 0, "WP2", gameBoard);// temp
                }
                hasMovedAPiece = true;
                if(hasMovedAPiece == true)
                    endOfTurn = true;
            }
        }
        clearConsole();
        gameBoard.printBoard();
    }

    private static void clearConsole() // essentialy clears board by printing 40 blank lines 
    {
        for (int z = 0; z < 40; z++) 
            System.out.println();
    }
    
    private static void movePiece(int y, int x, String initials, Board board)
    {
        for(int yB = 0; yB <= 7; yB++)
        {
            System.out.println(yB);
            for(int xB = 0; xB <= 7; xB++)
            {
                System.out.println(xB);
                System.out.println(board.getBoard()[yB][xB].getInitials().equals(initials));
                if(board.getBoard()[yB][xB].getInitials().equals(initials))
                {
                    System.out.println(!board.getBoard()[yB + y][xB + x].getInitials().equals("   "));
                    if(!board.getBoard()[yB + y][xB + x].getInitials().equals("   "))
                        System.out.println("Piece " + board.getBoard()[yB][xB].getInitials() + " has taken " + board.getBoard()[yB + y][xB + x].getInitials() + ".");
                    board.getBoard()[yB + y][xB + x] = board.getBoard()[yB][xB];
                    board.getBoard()[yB][xB] = new Empty();
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Board gameBoard = new Board(); // create board
        gameBoard.setBoard(); // set board
        gameBoard.printBoard();
        //clearConsole(); // clear console
        int bothKingsAlive = 0;
        while (bothKingsAlive == 0) // while a king is not dead continue main gameplay loop
        {// this controls the whole game.
            playerTurn("W", gameBoard);
            playerTurn("B", gameBoard);
            bothKingsAlive = checkKings(gameBoard); // fix above
            switch(bothKingsAlive)
            {
                case 1:
                    System.out.println("White Won!");
                    return;
                case 2:
                    System.out.println("Black Won!");
                    return;
                default:
            }
        }
    }
}