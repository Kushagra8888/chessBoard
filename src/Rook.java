/**
 * Created by test on 7/29/2015.
 */
public class Rook extends ChessPiece {

	Rook(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.isAlive = true;
	}
	
    boolean isMoveValid(int xFinal, int yFinal){
        if ((x == xFinal) || (y == yFinal)) {
            return true;
        }
        else{
            return false;
        }
    }
	
	boolean castle()
	{
		boolean isCastlingPossible = true;
		if (this.x == 8){
			this.x -= 2;
		} else
		if (this.x == 1){
			this.x += 3;
		} else
		isCastlingPossible = false;
		return isCastlingPossible;
	}
}
