/**
 * Created by test on 7/29/2015.
 */
public class King extends ChessPiece{

	King(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.isAlive = true;
	}
	
	public boolean isMoveValid(int x, int y)
	{
		int diffInX = Math.abs(x - this.x);
		int diffInY = Math.abs(x - this.y);
		boolean isMoveValid = (diffInX <= 1) && (diffInY <= 1) && (diffInX + diffInY == 1);
		return isMoveValid;
	}
	
	public castling(int xRook)
	{
		if (xRook == 8)
		{
			this.x += 2;
		}
		else
		if (xRook == 1)
		{
			this.x -= 2;
		}
	}
}
