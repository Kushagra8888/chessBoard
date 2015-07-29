/**
 * Created by test on 7/29/2015.
 */
public abstract class ChessPiece {
    int x, y;
    boolean isAlive;

    abstract boolean isMoveValid(int x, int y);

    boolean move(int x,int y) {
        if (isMoveValid(x, y)) {
            this.x = x;
            this.y = y;
            return true;
        }
        return false;
    }

}
