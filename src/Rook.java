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
	
	boolean isPositionFree(int x, int y, ArrayList<int[]> positionsOccupied) {
		for (int[] pos : positionsOccupied) {
					if((pos[0] == x) && (pos[1] == y))
					return false;
		}
		return true;
	}
	boolean isPathClear(int x, int y, ArrayList<int[]> positionsOccupied){
	
		if (x > this.x) {
			while (x > this.x) {
				if (!isPositionFree(x, y, positionsOccupied))
					return false;
				x--;
			}
		}
		else
		if (x < this.x) {
			while (x < this.x) {
				if (!isPositionFree(x, y, positionsOccupied))
					return false;
				x++;
			}
		}
		else
		if (y > this.y) {
			while (y > this.y) {
				if (!isPositionFree(x, y, positionsOccupied))
					return false;
				y--;
			}
		}
		else
		if (y < this.y) {
			while (y < this.y) {
				if (!isPositionFree(x, y, positionsOccupied))
					return false;
				y++;
			}
		}
		
		return true;
	}
	
    boolean isMoveValid(int xFinal, int yFinal, ArrayList<int[]> positionsOccupied){
        boolean isValidPosition = (x == xFinal) || (y == yFinal);
        boolean isPathClear = isPathClear(x, y, positionsOccupied);
	if (isValidPosition && isPathClear)
	{
		if(xFinal == -1 && yFinal == -1)
			return (castle())
	}
	
	return isValidPosition && isPathClear;
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
