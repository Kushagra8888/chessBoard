import java.util.ArrayList;

/**
 * Created by test on 7/29/2015.
 */
public class Knight extends ChessPiece{

	Knight(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.isAlive = true;
	}
	
	public boolean isMoveValid(int x, int y, ArrayList<int[]> positionsOccupied)
	{
		int diffInX = Math.abs(x - this.x);
		int diffInY = Math.abs(x - this.y);
		boolean isMoveValid = (diffInX < 3) && (diffInY < 3) && (diffInX + diffInY == 3);
		return isMoveValid;
	}
}
