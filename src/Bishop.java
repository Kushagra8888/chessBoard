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
	
	public boolean isMoveValid(int x, int y, ArrayList<int[]> positionsOccupied)
	{
		boolean isMoveValid = x - this.x == y - this.y;
		boolean isPathFree = isPathFree(x, y, positionsOccupied);
		return isMoveValid && isPathFree;
	}
	
	boolean isPathFree(int x, int y, ArrayList<int[]> positionsOccupied) {
		if(x - this.x > 0){
			while (x > this.x && y > this.y) {
				for (int[] pos : positionsOccupied) {
					if((pos[0] == x) && (pos[1] == y))
					return false;
				}
				x--;
				y--;
			}
		}
		else
		if (x - this.x < 0) {
			while (x < this.x && y < this.y) {
				for (int[] pos : positionsOccupied) {
					if((pos[0] == x) && (pos[1] == y))
						return false;
				}
			x++;
			y++;
			}
		}
		return true;
	}
}
