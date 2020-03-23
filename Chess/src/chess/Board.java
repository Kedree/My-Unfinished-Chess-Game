package chess;

/* Author: Kedree Anthony Proffitt of Davison Michigan USA */

public class Board 
{

    Tile[][] board; // create board

    Board() 
    {
        // create interface/abstract that is named tile that extends empty tile and pieces, pieces extends pawn rook, etc
        board = new Tile[8][8];
    }

    public void setBoard() // set board
    {
        board[0][0] = new Rook('B', '1');
        board[0][1] = new Knight('B', '1');
        board[0][2] = new Bishop('B', '1');
        board[0][3] = new King('B', '1');
        board[0][4] = new Queen('B', '1');
        board[0][5] = new Bishop('B', '2');
        board[0][6] = new Knight('B', '2');
        board[0][7] = new Rook('B', '2');
        for (int n = 0; n < 8; n++) 
            board[1][n] = new Pawn('B', (char) ((char) n + 1 + '0'));
        for (int n = 0; n < 8; n++) 
            board[2][n] = new Empty();
        for (int n = 0; n < 8; n++) 
            board[3][n] = new Empty();
        for (int n = 0; n < 8; n++) 
            board[4][n] = new Empty();
        for (int n = 0; n < 8; n++) 
            board[5][n] = new Empty();
        for (int n = 0; n < 8; n++) 
            board[6][n] = new Pawn('W', (char) ((char) n + 1 + '0')); // finish
        board[7][0] = new Rook('W', '1');
        board[7][1] = new Knight('W', '1');
        board[7][2] = new Bishop('W', '1');
        board[7][3] = new Queen('W', '1');
        board[7][4] = new King('W', '1');
        board[7][5] = new Bishop('W', '2');
        board[7][6] = new Knight('W', '2');
        board[7][7] = new Rook('W', '2');
    }

    public Tile[][] getBoard() 
    {
        return board; // get board
    }

    public void printBoard() // print board
    {
        int i = 0;
        System.out.println("     A     B     C     D     E     F     G     H   ");
        for (int r = 0; r < board.length; r++) {
            System.out.println("  -------------------------------------------------");
            System.out.println("  |     |     |     |     |     |     |     |     |");
            System.out.println((r + 1) + " | " + board[r][0].getInitials() + " | " + board[r][1].getInitials() + " | " + board[r][2].getInitials() + " | " + board[r][3].getInitials() + " | " + board[r][4].getInitials() + " | " + board[r][5].getInitials() + " | " + board[r][6].getInitials() + " | " + board[r][7].getInitials() + " |");
            System.out.println("  |     |     |     |     |     |     |     |     |");
        }
        System.out.println("  -------------------------------------------------");
        System.out.println();
        System.out.println();
    }

    public boolean checkTileEmpty(Tile tile) 
    {
        return tile.getInitials().equals("   ");
    }
}