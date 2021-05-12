/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;


import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Felipe
 */
public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();
        
        while(!chessMatch.getCheckMate()){
            try{
                UI.clearScreen();
                UI.printMatch(chessMatch,captured);
                System.out.println();
                System.out.println("source: ");
                ChessPosition source = UI.readChessPosition(sc);
                
                boolean [][] possibleMoves=chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(),possibleMoves);

                System.out.println();
                System.out.println("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                
                if(capturedPiece != null ){
                    captured.add(capturedPiece);
                }
                
                if(chessMatch.getPromoted() !=null){
                    System.out.println("Entre com a peça a ser promovida: (B/N/R/Q) ");
                    String type = sc.next().toUpperCase();
                    while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
                        System.out.println("Tipo inválido, colocar as mostradas");
                        type = sc.next().toUpperCase();

                    }
                    chessMatch.replacePromotedPiece(type);
                }
            }
            catch(ChessException e){
                System.out.println(e.getMessage());
                sc.next();
            }
            catch(InputMismatchException e){
                System.out.println(e.getMessage());
                sc.next();
            }
        }
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
    
}
