/**
 * Created by test on 7/29/2015.
 */
public class Rook extends ChessPiece {

    boolean isMoveValid(int xFinal, int yFinal){
        if ((x == xFinal) || (y == yFinal)) {
            return true;
        }
        else{
            return false;
        }
    }
}
