package chess;

import java.util.ArrayList;

/* Author: Kedree Anthony Proffitt of Davison Michigan USA */

public abstract class Tile 
{

    char color;
    char pieceName;
    char number;
    String initials = "";

    public void setInitials() 
    {
        initials += color;
        initials += pieceName;
        initials += number;
    }

    public String getInitials() 
    {
        return initials;
    }
    
    public ArrayList<String> getLegalMoves(int[] coords, Board gameBoard)
    {
        return null;
    }
}