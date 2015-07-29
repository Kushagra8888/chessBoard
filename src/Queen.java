/**
 * Created by test on 7/29/2015.
 */
public class Queen extends ChessPiece {
    boolean isMoveValid(int xFinal, int yFinal){
        if (((x == xFinal) || (y == yFinal)) || (Math.abs(x - xFinal) == Math.abs(y - yFinal))) {
            return true;
        }
        else{
            return false;
        }
    }
}
