package chessgame;

public class Pawn extends ChessPiece {
    Pawn(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.isAlive = true;
    }

    boolean isMoveValid(int xFinal, int yFinal){
        return y == yFinal;
    }
}
