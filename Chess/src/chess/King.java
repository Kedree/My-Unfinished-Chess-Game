package chess;

import java.util.ArrayList;

/* Author: Kedree Anthony Proffitt of Davison Michigan USA */

public final class King extends Piece
{
    @Override
    public void setInitials()
    {
        super.setInitials();
    }
    King(char color, char number)
    {
        this.color = color;
        this.number = number;
        pieceName = '+';
        possibleMoves = new ArrayList();
        setInitials();
    }
    @Override
    public String getInitials()
    {
        super.getInitials();
        return initials;
    }

    @Override
    public ArrayList<String> getLegalMoves(int[] coords, Board gameBoard)  // finished(?) add more documentation
    {
        possibleMoves.clear();
        if (((coords[0] - 1 >= 0) && (coords[0] - 1 < 9)) && ((coords[1] - 1 >= 0) && coords[1] - 1 < 9) && gameBoard.getBoard()[coords[0] - 1][coords[1] - 1].getInitials().substring(0, 1).equals(color) == false)
        {
            if (gameBoard.getBoard()[coords[0] - 1][coords[1] - 1].getInitials().substring(0, 1).equals(" "))
                possibleMoves.add("Left 1 Up 1");
            else
                possibleMoves.add("Left 1 Up 1, take " + gameBoard.getBoard()[coords[0] - 1][coords[1] - 1].getInitials());
        }
        if ((coords[0] - 1 >= 0 && coords[0] - 1 < 9) && gameBoard.getBoard()[coords[0] - 1][coords[1]].getInitials().substring(0, 1).equals(color) == false)
        {
            if (gameBoard.getBoard()[coords[0] - 1][coords[1]].getInitials().substring(0, 1).equals(" "))
                possibleMoves.add("Up 1");
            else
                possibleMoves.add("Up 1, take " + gameBoard.getBoard()[coords[0] - 1][coords[1]].getInitials());
        }
        if (((coords[0] - 1 >= 0) && (coords[0] - 1 < 9)) && ((coords[1] + 1 >= 0) && coords[1] + 1 < 9) && gameBoard.getBoard()[coords[0] - 1][coords[1] + 1].getInitials().substring(0, 1).equals(color) == false)
        {
            if (gameBoard.getBoard()[coords[0] - 1][coords[1] + 1].getInitials().substring(0, 1).equals(" "))
                possibleMoves.add("Right 1 Up 1");
            else
                possibleMoves.add("Right 1 Up 1, take " + gameBoard.getBoard()[coords[0] - 1][coords[1] + 1].getInitials());
        }
        if ((coords[1] - 1 >= 0 && coords[1] - 1 < 9) && gameBoard.getBoard()[coords[0]][coords[1] - 1].getInitials().substring(0, 1).equals(color) == false)
        {
            if (gameBoard.getBoard()[coords[0]][coords[1] - 1].getInitials().substring(0, 1).equals(" "))
                possibleMoves.add("Left 1");
            else
                possibleMoves.add("Left 1, take " + gameBoard.getBoard()[coords[0]][coords[1] - 1].getInitials());
        }
        if ((coords[1] + 1 >= 0 && coords[1] + 1 < 9) && gameBoard.getBoard()[coords[0]][coords[1] + 1].getInitials().substring(0, 1).equals(color) == false)
        {
            if (gameBoard.getBoard()[coords[0]][coords[1] + 1].getInitials().substring(0, 1).equals(" "))
                possibleMoves.add("Right 1");
            else
                possibleMoves.add("Right 1, take " + gameBoard.getBoard()[coords[0]][coords[1] + 1].getInitials());
        }
        if (((coords[0] + 1 >= 0) && (coords[0] + 1 < 9)) && ((coords[1] - 1 >= 0) && coords[1] - 1 < 9) && gameBoard.getBoard()[coords[0] + 1][coords[1] - 1].getInitials().substring(0, 1).equals(color) == false)
        {
            if (gameBoard.getBoard()[coords[0] + 1][coords[1] - 1].getInitials().substring(0, 1).equals(" "))
                possibleMoves.add("Left 1 Down 1");
            else
                possibleMoves.add("Left 1 Down 1, take " + gameBoard.getBoard()[coords[0] + 1][coords[1] - 1].getInitials());
        }
        if ((coords[0] + 1 >= 0 && coords[0] + 1 < 9) && gameBoard.getBoard()[coords[0] + 1][coords[1]].getInitials().substring(0, 1).equals(color) == false)
        {
            if (gameBoard.getBoard()[coords[0] + 1][coords[1]].getInitials().substring(0, 1).equals(" "))
                possibleMoves.add("Down 1");
            else
                possibleMoves.add("Down 1, take " + gameBoard.getBoard()[coords[0] + 1][coords[1]].getInitials());
        }
        if (((coords[0] + 1 >= 0) && (coords[0] + 1 < 9)) && ((coords[1] + 1 >= 0) && coords[1] + 1 < 9) && gameBoard.getBoard()[coords[0] + 1][coords[1] + 1].getInitials().substring(0, 1).equals(color) == false)
        {
            if (gameBoard.getBoard()[coords[0] + 1][coords[1] + 1].getInitials().substring(0, 1).equals(" "))
                possibleMoves.add("Right 1 Down 1");
            else
                possibleMoves.add("Right 1 Down 1, take " + gameBoard.getBoard()[coords[0] + 1][coords[1] + 1].getInitials());
        }
        return possibleMoves;
    }
}
