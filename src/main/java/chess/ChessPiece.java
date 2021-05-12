/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import boardgame.Piece;
import boardgame.Board;
import boardgame.Position;

/**
 *
 * @author Felipe
 */
public abstract class ChessPiece extends Piece {
    
    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }
    
    public int getMoveCount(){
        return moveCount;
    }

    public Color getColor() {
        return color;
    }
    
    public void increaseMoveCount(){
        this.moveCount++;
    }
    
    public void decreaseMoveCount(){
        this.moveCount--;
    }
    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }
    
    protected boolean isThereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p !=null && p.getColor() != color;
    }
    
    
}
