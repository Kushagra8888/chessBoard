package chessgame;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by test on 7/29/2015.
 */
public class ChessGame {

	final int blackPawnInitialYPos = 7;
	final int whitePawnInitialYPos = 2;
	
	static HashMap<String, int[]> coordinateMap = new HashMap<String, int[]>();
	
	private HashMap<String, ArrayList<ChessPiece>> blackPieces = new HashMap<String, ArrayList<ChessPiece>>();
	private HashMap<String, ArrayList<ChessPiece>> whitePieces = new HashMap<String, ArrayList<ChessPiece>>();
	
	static {
		generateCoordinateMap();
	}
	
	private static void generateCoordinateMap () {
		
	}
	
	public ChessGame () {
		
		initPawns();
	}
	
	private void initPawns () {
		ArrayList<ChessPiece> bpawns = new ArrayList<ChessPiece>();
		ArrayList<ChessPiece> wpawns = new ArrayList<ChessPiece>();
		
		for (int i = 1; i <= 8; i++) {
			bpawns.add(new Pawn(i, blackPawnInitialYPos));
			wpawns.add(new Pawn(i, whitePawnInitialYPos));
		}
		
		blackPieces.put("P", bpawns);
		whitePieces.put("P", wpawns);
	}
	
	public void move (String movePair) {
		String[] moves = movePair.split("\\s+");
		
	}
	
	public void showBoard () {
		
	}
}
