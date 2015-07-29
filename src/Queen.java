/**
 * Created by test on 7/29/2015.
 */
public class Queen extends ChessPiece {

    Queen(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.isAlive = true;
    }
    boolean isMoveValid(int xFinal, int yFinal){
        if (((x == xFinal) || (y == yFinal)) || (Math.abs(x - xFinal) == Math.abs(y - yFinal))) {
            return true;
        }
        else{
            return false;
        }
    }
}
