package com.ooadproject.kja.checkers.models;


import com.ooadproject.kja.checkers.utilities.*;

public class Piece {

  private int color;
  private boolean isKing;
  private Move[] possibleMoves;
  private int column;
  private int row;

  public Piece(int color, int row, int column)
  {
    this.color = color;
    this.setRow(row);
    this.setColumn(column);
  }


  public void printPiece()
  {
    GenHelper helperUtil = GenHelper.getGenHelper();
    System.out.println("Color: " + helperUtil.pieceColorConverter(this.color) + " Location: " + this.row + "," + this.column);
  }


  public int getColor() {
    return color;
  }

  public void setColor(int color) {
    this.color = color;
  }

  public boolean isKing() {
    return isKing;
  }

  public void setKing(boolean isKing) {
    this.isKing = isKing;
  }

  public Move[] getPossibleMoves() {
    return possibleMoves;
  }

  public void setPossibleMoves(Move[] possibleMoves) {
    this.possibleMoves = possibleMoves;
  }


public int getColumn() {
	return column;
}


public void setColumn(int column) {
	this.column = column;
}


public int getRow() {
	return row;
}


public void setRow(int row) {
	this.row = row;
}
}
