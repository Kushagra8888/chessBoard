//package chessgame;

import java.util.ArrayList;

public class Pawn extends ChessPiece {
    Pawn(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.isAlive = true;
    }

    boolean isMoveValid(int xFinal, int yFinal, ArrayList<int[]> positionsOccupied) {
        if (y == 2 || y == 7) {
            return ((Math.abs(xFinal - x) <= 2) && (Math.abs(yFinal - y) <= 2));
        }
        else{
            return ((Math.abs(xFinal - x) == 1) && (Math.abs(yFinal - y) == 1));
        }
    }

}
