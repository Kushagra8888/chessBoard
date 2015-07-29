/**
 * Created byFinal test on 7/29/2015.
 */
public abstract class ChessPiece {
    int x, y;
    boolean isAlive;

    abstract boolean isMoveValid(int xFinal, int yFinal);

    boolean move(int xFinal,int yFinal) {
        if (isMoveValid(xFinal, yFinal)) {
            this.x = xFinal;
            this.y = yFinal;
            return true;
        }
        return false;
    }

}
