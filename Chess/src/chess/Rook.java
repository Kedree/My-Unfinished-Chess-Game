package chess;

import java.util.ArrayList;

/* Author: Kedree Anthony Proffitt of Davison Michigan USA */

public final class Rook extends Piece
{
    @Override
    public void setInitials()
    {
        super.setInitials();
    }
    Rook(char color, char number)
    {
        this.color = color;
        this.number = number;
        possibleMoves = new ArrayList();
        pieceName = 'R';
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