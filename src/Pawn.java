/**
 * Created by test on 7/29/2015.
 */
public class Pawn extends ChessPiece {
    Pawn(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.isAlive = true;
    }

    boolean isMoveValid(int xFinal, int yFinal){
        if (y == yFinal) {
            return true;
        }
        else{
            return false;
        }
    }
}
