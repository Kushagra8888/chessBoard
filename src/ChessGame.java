//package chessgame;
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

	private ArrayList<Integer[]> coordList = new ArrayList<Integer[]>();
	
	static HashMap<String, int[]> coordinateMap = new HashMap<String, int[]>();
	static HashMap<String, Integer> xCoordMap = new HashMap<String, Integer>(); 
	static HashMap<int[], String> invertedCoordinateMap = new HashMap<int[], String>();
	
	private HashMap<String, ArrayList<ChessPiece>> blackPieces = new HashMap<String, ArrayList<ChessPiece>>();
	private HashMap<String, ArrayList<ChessPiece>> whitePieces = new HashMap<String, ArrayList<ChessPiece>>();
	
	static {
		generateCoordinateMap();
	}
	
	private static void generateCoordinateMap () {
		int[] coord = new int[2];
		String[] xPositions = {"a", "b", "c", "d", "e", "f", "g", "h"};
		String[] yPositions = {"1", "2", "3", "4", "5", "6", "7", "8"};
		
		for (int i = 1; i <= 8 ; i++) {
			for (int j = 1; j <= 8; j++) {
				coord[0] = i;
				coord[1] = j;
				coordinateMap.put(xPositions[i] + yPositions[j], coord);
				invertedCoordinateMap.put(coord, xPositions[i] + yPositions[j]);
			}
			xCoordMap.put(xPositions[i], i);
		}
	}

	private void capture(HashMap<String, ArrayList<ChessPiece>> listOfPieces, String position) {
		for (String  pieceType: listOfPieces.keySet()) {
			for (ChessPiece piece: listOfPieces.get(pieceType)){
				if (piece.getXCoord() == coordinateMap.get(position)[0] && piece.getYCoord() == coordinateMap.get(position)[1]){
					piece.capture();
					break;
				}
			}
		}
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
			Integer[] toAdd = {i,blackPawnInitialYPos};
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
	
	private boolean isPieceInGivenPos (String currPos, ArrayList<ChessPiece> chPs) {
		if (currPos == null) {
			return true;
		}
		if (xCoordMap.containsKey(currPos)) {
			return isPieceInGivenXCoord(currPos, chPs);
		} else {
			return isPieceInGivenYCoord(currPos, chPs);
		}
	}
	
	private boolean isPieceInGivenXCoord(String currPos, ArrayList<ChessPiece> chPs) {
		for (ChessPiece ch : chPs) {
			if (ch.getXCoord() == xCoordMap.get(currPos)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isPieceInGivenYCoord(String currPos, ArrayList<ChessPiece> chPs) {
		for (ChessPiece ch : chPs) {
			if (ch.getYCoord() == Integer.parseInt(currPos)) {
				return true;
			}
		}
		return false;
	}
	
	private void move (HashMap<String, ArrayList<ChessPiece>> chPs, String move) {
		ArrayList<ChessPiece> chessPs;
		String movPos;
		
		if (move == "O-O" || move == "O-O-O") {
			int xCoord, kingPos;
			chessPs = chPs.get("K");
			ChessPiece king = chessPs.get(0);
			chessPs = chPs.get("R");
			if (move == "O-O") {
				xCoord = 8;
				kingPos = 7; 
			} else {
				xCoord = 1;
				kingPos = 3;
			}
				
			for (ChessPiece ch : chessPs) {
				if (ch.getXCoord() == xCoord) {
					ch.move(-1, -1);
					king.move(kingPos, king.getYCoord());
					break;
				}
			}
			
			return;
		}	
		
		if (Character.isUpperCase(move.charAt(0))) {
			movPos = move.substring(1);
			switch (move.charAt(0)) {
			case 'N': chessPs = chPs.get("N");
				break;
			case 'R': chessPs = chPs.get("R");
				break;
			case 'B': chessPs = chPs.get("B");
				break; 
			case 'K': chessPs = chPs.get("K");
				break;
			case 'Q': chessPs = chPs.get("Q");
				break;
			default:
				chessPs = null;	
			}
		} else {
			movPos = move.substring(0);
			chessPs = chPs.get("P");
		}
		
		String currPos = null;
		String movPosFinal;
		
		if ( ! coordinateMap.containsKey(movPos)) {
			currPos = movPos.substring(0, 1);
			movPosFinal = movPos.substring(1, 3);
		} else {
			movPosFinal = movPos;
		}
		
		int[] coord;
		coord = coordinateMap.get(movPosFinal);
		
		for (ChessPiece ch : chessPs) {
			if (ch.isAlive) {
				if (isPieceInGivenPos(currPos, chessPs)) {
					if (ch.move(coord[0], coord[1])) {
						break;
					}
				}
			}
		}
	}
	
	public void move (String movePair) {
		String[] moves = movePair.split("\\s+");
		
		if (moves[0].contains("x")) {
			String[] positions = moves[0].split("x");
			move( whitePieces, positions[0]);
			capture(blackPieces, positions[1]);
		} else {
			
			move( whitePieces, moves[0]);
		}
		
		if (moves[1].contains("x")) {
			String[] positions = moves[1].split("x");
			move(blackPieces, positions[0]);
			capture(whitePieces, positions[1]);
		} else {
			move(blackPieces, moves[1]);
		}
		
	}
	
	
	public void showBoard () {
		System.out.println("White ChessPieces\n");
		for (String key : whitePieces.keySet()) {
			displayChessPieceType(key);
			displayChessPieceList(whitePieces.get(key));
		}

		System.out.println("Black ChessPieces\n");
		for (String key : blackPieces.keySet()) {
			displayChessPieceType(key);
			displayChessPieceList(blackPieces.get(key));
		}
	}
	
	public void displayChessPieceList(ArrayList<ChessPiece> chessPieceList) {
		int[] coord = new int[2];
		for (ChessPiece chessPiece : chessPieceList) {
			coord[0] = chessPiece.getXCoord();
			coord[1] = chessPiece.getYCoord();
			String pos = invertedCoordinateMap.get(coord);
			System.out.println(pos + "; ");
		}
		System.out.println("\n");
	}
	
	public void displayChessPieceType(String key) {
		switch(key)
			{
				case "P":
				System.out.println("Pawns");
				break;
				
				case "N":
				System.out.println("Knight");
				break;
				
				case "R":
				System.out.println("Rook");
				break;
				
				case "B":
				System.out.println("Bishop");
				break;
				
				case "K":
				System.out.println("King");
				break;
				
				case "Q":
				System.out.println("Queen");
				break;
			}
	}
	
	public ArrayList<int[]> generatePositionsOccupied()
	{
		ArrayList<int[]> coordList;
		int[] coord = new int[2];
		for (String key : whitePieces.keySet()) {
			displayChessPieceList(whitePieces.get(key));
			for (ChessPiece chessPiece : chessPieceList) {
				coord[0] = chessPiece.getXCoord();
				coord[1] = chessPiece.getYCoord();
				coordList.add(coord);
			}		
		}
		
		for (String key : blackPieces.keySet()) {
			displayChessPieceList(whitePieces.get(key));
			for (ChessPiece chessPiece : chessPieceList) {
				coord[0] = chessPiece.getXCoord();
				coord[1] = chessPiece.getYCoord();
				coordList.add(coord);
			}		
		}
		
		return coordList;
	}
}
 
