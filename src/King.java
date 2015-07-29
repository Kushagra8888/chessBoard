/**
 * Created by test on 7/29/2015.
 */
public class King extends ChessPiece {
    boolean isMoveValid(int xFinal, int yFinal){
        if ((Math.abs(y - yFinal) == 1) || (Math.abs(x - xFinal) == 1)) {
            return true;
        }
        else{
            return false;
        }
    }
}
