package chess;

import java.util.ArrayList;

/* Author: Kedree Anthony Proffitt of Davison Michigan USA */

public final class Pawn extends Piece
{
    @Override
    public void setInitials()
    {
        super.setInitials();
    }
    Pawn(char color, char number)
    {
        this.color = color;
        this.number = number;
        possibleMoves = new ArrayList();
        pieceName = 'P';
        setInitials();
    }
    @Override
    public String getInitials() // return 
    {
        return initials;
    }
    
    @Override
    public ArrayList<String> getLegalMoves(int[] coords, Board gameBoard) // finished(?) add more documentaion
    {
        possibleMoves.clear();
        if (color == 'W')
        {
            if (coords[0] == 6 && gameBoard.getBoard()[coords[0] - 2][coords[1]].getInitials().substring(0, 1).equals("W") == false) // go up 2
            {
                if (gameBoard.getBoard()[coords[0] - 2][coords[1]].getInitials().substring(0, 1).equals("B"))
                    possibleMoves.add("Up 2, take " + gameBoard.getBoard()[coords[0] - 2][coords[1]].getInitials());
                else
                    possibleMoves.add("Up 2");
            }
            if (coords[0] - 1 >= 0 && gameBoard.getBoard()[coords[0] - 1][coords[1]].getInitials().substring(0, 1).equals("W") == false) // go up 1
            {
                if (gameBoard.getBoard()[coords[0] - 1][coords[1]].getInitials().substring(0, 1).equals("B"))
                    possibleMoves.add("Up 1, take " + gameBoard.getBoard()[coords[0] - 1][coords[1]].getInitials());
                else
                    possibleMoves.add("Up 1");
            }
            if (coords[0] - 1 >= 0 && gameBoard.getBoard()[coords[0] - 1][coords[1] + 1].getInitials().substring(0, 1).equals("B")) // go up 1 right 1
            {
                possibleMoves.add("Up 1 Right 1, take" + gameBoard.getBoard()[coords[0] - 1][coords[1] + 1].getInitials());
            }
            if (coords[0] - 1 >= 0 && gameBoard.getBoard()[coords[0] - 1][coords[1] - 1].getInitials().substring(0, 1).equals("B")) // go up 1 left 1
            {
                possibleMoves.add("Up 1 Left 1, take" + gameBoard.getBoard()[coords[0] - 1][coords[1] + 1].getInitials());
            }
        }
        if (color == 'B')
        {
            if (coords[0] == 1 && gameBoard.getBoard()[coords[0] + 2][coords[1]].getInitials().substring(0, 1).equals("B") == false) // go down 2
            {
                if (gameBoard.getBoard()[coords[0] + 2][coords[1]].getInitials().substring(0, 1).equals("W"))
                    possibleMoves.add("Up 2, take " + gameBoard.getBoard()[coords[0] + 2][coords[1]].getInitials());
                else
                    possibleMoves.add("Up 2");
            }
            if (coords[0] + 1 < 9 && gameBoard.getBoard()[coords[0] + 1][coords[1]].getInitials().substring(0, 1).equals("B") == false) // go down 1
            {
                if (gameBoard.getBoard()[coords[0] + 1][coords[1]].getInitials().substring(0, 1).equals("W"))
                    possibleMoves.add("Up 1, take " + gameBoard.getBoard()[coords[0] + 1][coords[1]].getInitials());
                else
                    possibleMoves.add("Up 1");
            }
            if (coords[0] + 1 < 9 && gameBoard.getBoard()[coords[0] + 1][coords[1] + 1].getInitials().substring(0, 1).equals("B")) // go down 1 right 1
            {
                possibleMoves.add("Up 1 Right 1, take" + gameBoard.getBoard()[coords[0] + 1][coords[1] + 1].getInitials());
            }
            if (coords[0] + 1 < 9 && gameBoard.getBoard()[coords[0] + 1][coords[1] - 1].getInitials().substring(0, 1).equals("B")) // go down 1 left 1
            {
                possibleMoves.add("Up 1 Right 1, take" + gameBoard.getBoard()[coords[0] + 1][coords[1] - 1].getInitials());
            }
        }
        return possibleMoves;
    }
}
