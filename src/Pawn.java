/**
 * Created by test on 7/29/2015.
 */
public class Pawn extends ChessPiece {
    boolean isMoveValid(int xFinal, int yFinal){
        if (y == yFinal) {
            return true;
        }
        else{
            return false;
        }
    }
}
