package chessgame;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by test on 7/29/2015.
 */
public class ChessGame {

	static HashMap<String, int[]> coordinateMap = new HashMap<String, int[]>();
	private HashMap<String, ArrayList<ChessPiece>> chessPieces = new HashMap<String, ArrayList<ChessPiece>>();
	
	public void move (String moveSet) {
		String[] moves = moveSet.split("\\s+");
	}
}
