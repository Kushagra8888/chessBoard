package chessgame;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @TODO
 * 
 * 1. Change ArrayList To normal Array in the HashMap
 * 2. add 'final' member variables for initial positions of various chess pieces
 *
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
		initKnight();
		initRook();
		initBishop();
		initKing();
		initQueen();
		
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
	
	private void initKnight () {
		ArrayList<ChessPiece> bknights = new ArrayList<ChessPiece>();
		ArrayList<ChessPiece> wknights = new ArrayList<ChessPiece>();
		
		bknights.add(new Knight(2, 8));
		bknights.add(new Knight(7, 8));
		
		wknights.add(new Knight(2, 1));
		wknights.add(new Knight(7, 1));
			
		blackPieces.put("N", bknights);
		whitePieces.put("N", wknights);
	}
	
	private void initRook () {
		ArrayList<ChessPiece> brooks = new ArrayList<ChessPiece>();
		ArrayList<ChessPiece> wrooks = new ArrayList<ChessPiece>();
		
		brooks.add(new Rook(1, 8));
		brooks.add(new Rook(8, 8));
		
		wrooks.add(new Rook(1, 1));
		wrooks.add(new Rook(8, 1));
			
		blackPieces.put("R", brooks);
		whitePieces.put("R", wrooks);
	}
	
	private void initBishop() {
		ArrayList<ChessPiece> bbishops = new ArrayList<ChessPiece>();
		ArrayList<ChessPiece> wbishops = new ArrayList<ChessPiece>();
		
		bbishops.add(new Bishop(3, 8));
		bbishops.add(new Bishop(6, 8));
		
		wbishops.add(new Bishop(3, 1));
		wbishops.add(new Bishop(6, 1));
			
		blackPieces.put("B", bbishops);
		whitePieces.put("B", wbishops);
	}
	
	private void initKing() {
		ArrayList<ChessPiece> bking = new ArrayList<ChessPiece>();
		ArrayList<ChessPiece> wking = new ArrayList<ChessPiece>();
		
		bking.add(new King(5, 8));
		
		wking.add(new King(5, 1));
			
		blackPieces.put("K", bking);
		whitePieces.put("K", wking);
	}
	
	private void initQueen() {
		ArrayList<ChessPiece> bqueen = new ArrayList<ChessPiece>();
		ArrayList<ChessPiece> wqueen = new ArrayList<ChessPiece>();
		
		bqueen.add(new Queen(4, 8));
		
		wqueen.add(new Queen(4, 1));
			
		blackPieces.put("Q", bqueen);
		whitePieces.put("Q", wqueen);
	}
	
	public void move (String movePair) {
		String[] moves = movePair.split("\\s+");
		
	}
	
	public void showBoard () {
		
	}
}
