//package chessgame;

import java.util.*;
import java.io.*;

class ChessGameClient
{
	public static void main (String[] args) throws java.lang.Exception
	{
		ChessGame chessGame = new ChessGame();
		BufferedReader br = new BufferedReader(new FileReader("Adams.pgn"));
		String nextMove;
		String moves = br.readLine();
		String[] movesArray = moves.split("\\.");
		String[] currentMove;
		String move;
		
		for (int index = 1; index < movesArray.length; index++){
			currentMove = movesArray[index].split(" ");
			if(!Character.isUpperCase(currentMove[0].charAt(0)))
				currentMove[0] = "P" + currentMove[0];
			move = currentMove[0];

			if (currentMove[1] != null)
			{	
				if(!Character.isUpperCase(currentMove[1].charAt(0)))
					currentMove[1] = "P" + currentMove[1];
				move += " " + currentMove[1];
			}
			//System.out.println(move);
			chessGame.move(move);
		}
 		br.close();
	} 
}
