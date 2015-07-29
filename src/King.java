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
	
	public boolean isMoveValid(int x, int y, ArrayList<int[]> positionsOccupied)
	{
		int diffInX = Math.abs(x - this.x);
		int diffInY = Math.abs(y - this.y);
		return  ((diffInX <= 1) && (diffInY <= 1) && (diffInX + diffInY <= 2));
	}
	
	public void castling(int xRook)
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
