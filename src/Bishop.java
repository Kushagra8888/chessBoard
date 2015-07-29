/**
 * Created by test on 7/29/2015.
 */
public class Bishop extends ChessPiece{
	Bishop(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.isAlive = true;
	}
	
	public bool isMoveValid(int x, int y)
	{
		bool isMoveValid = x - this.x == y - this.y;
		return isMoveValid;
	}
}
