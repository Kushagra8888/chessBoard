import java.util.ArrayList;

/**
 * Created byFinal test on 7/29/2015.
 */
public abstract class ChessPiece {
    int x, y;
    boolean isAlive;

    abstract boolean isMoveValid(int xFinal, int yFinal, ArrayList<int[]> positionsOccupied);

    boolean move(int xFinal,int yFinal, ArrayList<int[]> positionsOccupied) {
        if (isMoveValid(xFinal, yFinal, positionsOccupied)) {
            this.x = xFinal;
            this.y = yFinal;
            return true;
        }
        return false;
    }
    
    public void capture(){
        isAlive = false;
    }

    public int getXCoord(){
        return x;
    }

    public int getYCoord(){
        return y;
    }

    public String getPosition(){
        return (char) (x + 97 - 1) + "" + y;
    }

}
