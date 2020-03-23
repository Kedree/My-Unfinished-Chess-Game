package chess;

import java.util.ArrayList;

/* Author: Kedree Anthony Proffitt of Davison Michigan USA */

public final class Bishop extends Piece
{
    @Override
    public void setInitials()
    {
        super.setInitials();
    }
    Bishop(char color, char number)
    {
        this.color = color;
        this.number = number;
        possibleMoves = new ArrayList();
        pieceName = 'B';
        setInitials();
    }
    @Override
    public String getInitials()
    {
        super.getInitials();
        return initials;
    }
    
    @Override
    public ArrayList<String> getLegalMoves(int[] coords, Board gameBoard) // unfinished
    {
        return null;
    }
}
