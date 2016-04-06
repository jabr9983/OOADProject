package com.ooadproject.kja.checkers.business_logic;

import com.ooadproject.kja.checkers.models.*;
import com.ooadproject.kja.checkers.utilities.*;


public class BoardLogic {

  private static BoardLogic boardLogic;
  public MoveLogic moveLogic = new MoveLogic();

  private BoardLogic() {}

  public static BoardLogic getBoardLogic(){
    if (boardLogic == null)
        boardLogic = new BoardLogic();
    return boardLogic;
  }

  public int getGridSize(Board checkersBoard) {
    return checkersBoard.piecesGrid[0].length;
  }

  public void populateGrid(Board checkersBoard) {
    int boardSize = getGridSize(checkersBoard);
    for (int row = 0; row < boardSize; row++) {
      for (int col = 0; col < boardSize; col++) {
        if (row % 2 != col % 2) {
          if (row < 3)
            checkersBoard.piecesGrid[row][col] = new Piece(ConstantsHolder.RED, row, col);
          else if (row > 4)
            checkersBoard.piecesGrid[row][col] = new Piece(ConstantsHolder.BLACK, row, col);
          else
            checkersBoard.piecesGrid[row][col] = new Piece(ConstantsHolder.EMPTY, row, col);
        } 
        else {
          checkersBoard.piecesGrid[row][col] = new Piece(ConstantsHolder.EMPTY, row, col);
        }
      }
    }
  }
  public Piece getPiece(Board checkersBoard, int col, int row) {
    return checkersBoard.piecesGrid[row][col];
  }

  
  public void movePiece(Board checkersBoard, Move move)
  {
    Piece pieceToBeMoved = checkersBoard.piecesGrid[move.fromRow][move.fromCol];
    //pieceToBeMoved.printPiece();
    if(move.hasJumpPotential){
    	//add subtract piece count!
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Hello");
    	Piece jumpedPiece = moveLogic.getMiddlePiece(checkersBoard, move);
      jumpedPiece.printPiece();
    	checkersBoard.piecesGrid[jumpedPiece.getRow()][jumpedPiece.getColumn()] = new Piece(ConstantsHolder.EMPTY, jumpedPiece.getRow(), jumpedPiece.getColumn());
    }
    checkersBoard.piecesGrid[move.toRow][move.toCol] = pieceToBeMoved;
    checkersBoard.piecesGrid[move.fromRow][move.fromCol] = new Piece(ConstantsHolder.EMPTY, move.fromRow, move.fromCol);
  }
  
  public boolean makeMove(Board checkersBoard, Move move){
	  boolean initialCheck = moveLogic.preValidateMove(move);
	  if(!initialCheck){
		  System.out.println("Initial check failed! AHAHHHAHAAH");
		  return false;
	  }
	  boolean finalCheck = moveLogic.finalValidateMove(checkersBoard, move);
	  if(finalCheck){
		  movePiece(checkersBoard, move);
		  return true;
	  }
	  System.out.println("Welp, shit hit the fan");
	  return false;
  }
}
