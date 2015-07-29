#ChessBoard

Given a PGN(Portable Game Notation) representing a game of chess determine the final positions of the pieces on the chessboard.

##Approach:

1. Store the collection of white pieces and the collection of black pieces.
2. For every move determine which piece should be moved and apply the move to that piece.
3. If a piece is captured mark it as not alive.
4. After processing the entire file, display the position of each piece.
