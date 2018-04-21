package model;

import model.Coordinate;
import model.Game;
import model.Gameboard;
import model.Piece;
import model.exceptions.CollisionMovementException;
import model.exceptions.CurrentPieceNotFixedException;
import model.exceptions.FixedPieceMovementException;
import model.exceptions.GameEndedMovementException;
import model.exceptions.NoCurrentPieceException;
import model.exceptions.OffBoardMovementException;
import model.exceptions.WrongSizeException;

@SuppressWarnings("unused")
public class P2TestMain2C1415 {
	
	public static void main(String[] args) throws WrongSizeException,
			NoCurrentPieceException, GameEndedMovementException,
			FixedPieceMovementException, OffBoardMovementException,
			CollisionMovementException, CurrentPieceNotFixedException {
		Game game = new Game(new Coordinate(7, 10));
		System.out.println(game.toString());
		
		game.nextPiece("I");
		System.out.println(game.toString());
		
		game.rotateCurrentPieceClockwise();
		System.out.println(game.toString());
		
		game.rotateCurrentPieceCounterclockwise();
		System.out.println(game.toString());
		
		game.rotateCurrentPieceCounterclockwise();
		System.out.println(game.toString());
		
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		System.out.println("Pieza fija: " + game.isCurrentPieceFixed());
		
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		System.out.println("Pieza fija: " + game.isCurrentPieceFixed());
		
		game.nextPiece("I");
		System.out.println(game.toString());
		
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		
		game.rotateCurrentPieceCounterclockwise();
		System.out.println(game.toString());
		
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		System.out.println("Pieza fija: " + game.isCurrentPieceFixed());
		
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		System.out.println("Pieza fija: " + game.isCurrentPieceFixed());
		
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		try {
			game.moveCurrentPieceLeft();
			System.out.println(game.toString());
			game.moveCurrentPieceLeft();
			System.out.println(game.toString());
			game.moveCurrentPieceLeft();
			System.out.println(game.toString());
		}
		catch (Exception e) {
			
		}
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		
		game.rotateCurrentPieceClockwise();
		System.out.println(game.toString());
		
		try {
			game.moveCurrentPieceRight();
			System.out.println(game.toString());
			game.moveCurrentPieceRight();
			System.out.println(game.toString());
			game.moveCurrentPieceRight();
			System.out.println(game.toString());
		}
		catch (Exception e) {
			
		}
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		try {
			game.moveCurrentPieceLeft();
			System.out.println(game.toString());
			game.moveCurrentPieceLeft();
			System.out.println(game.toString());
			game.moveCurrentPieceLeft();
			System.out.println(game.toString());
		}
		catch (Exception e) {
			
		}
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		System.out.println("Pieza fija: " + game.isCurrentPieceFixed());
		
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		System.out.println("Pieza fija: " + game.isCurrentPieceFixed());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		System.out.println("Pieza fija: " + game.isCurrentPieceFixed());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		System.out.println("Pieza fija: " + game.isCurrentPieceFixed());
		
		game.nextPiece("I");
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		System.out.println("Pieza fija: " + game.isCurrentPieceFixed());
		
		game.rotateCurrentPieceClockwise();
		System.out.println(game.toString());
		
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		System.out.println("Pieza fija: " + game.isCurrentPieceFixed());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		System.out.println("Pieza fija: " + game.isCurrentPieceFixed());
		
		System.out.println("Se puede meter otra pieza: " + game.nextPiece("I"));
		System.out.println(game.toString());
		System.out.println("Pieza fija: " + game.isCurrentPieceFixed());
		
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		System.out.println("Pieza fija: " + game.isCurrentPieceFixed());
		System.out.println("Juego terminado: " + game.isGameEnded());
		System.out.println("Se puede meter otra pieza: " + game.nextPiece("I"));
		try {
			game.nextPiece("I");
			System.out.println(game.toString());
			System.out.println("Juego terminado: " + game.isGameEnded());
		}
		catch (Exception e) {
			
		}
		
		// Gameboard board= new Gameboard(new Coordinate(5, 7));
		// Piece p = new Piece();
		// board.putPiece(new Coordinate(0, 0), p);
		// System.out.println(board.toString());
		//
		// board.putPiece(new Coordinate(2, 2), p);
		// board.putPiece(new Coordinate(3, 3), p);
		// System.out.println(board.toString());
		//
		// Piece p2 = new Piece();
		
	}
	
}
