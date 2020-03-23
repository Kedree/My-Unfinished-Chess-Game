package chess;

/* Author: Kedree Anthony Proffitt of Davison Michigan USA */

public final class Empty extends Tile 
{

    @Override
    public void setInitials() 
    {
        super.setInitials();
    }

    Empty() 
    {
        super.color = ' ';
        super.pieceName = ' ';
        super.number = ' ';
        setInitials();
    }
}