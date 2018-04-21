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
public class P3TestMain3C1415 {
	
	public static void main(String[] args) throws WrongSizeException,
			NoCurrentPieceException, GameEndedMovementException,
			FixedPieceMovementException, OffBoardMovementException,
			CollisionMovementException, CurrentPieceNotFixedException {
		
		juegoVariasPiezas();
		
	}
	
	public static void juegoVariasPiezas() throws WrongSizeException,
			GameEndedMovementException, CurrentPieceNotFixedException,
			FixedPieceMovementException, OffBoardMovementException,
			CollisionMovementException, NoCurrentPieceException {
		Game game = new Game(new Coordinate(7, 10));
		System.out.println(game.toString());
		
		game.nextPiece("L");
		System.out.println(game.toString());
		
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		game.nextPiece("T");
		System.out.println(game.toString());
		game.rotateCurrentPieceClockwise();
		System.out.println(game.toString());
		
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.nextPiece("T");
		System.out.println(game.toString());
		game.rotateCurrentPieceClockwise();
		System.out.println(game.toString());
		game.rotateCurrentPieceClockwise();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		
		game.nextPiece("T");
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		
		game.nextPiece("L");
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.rotateCurrentPieceClockwise();
		System.out.println(game.toString());
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		game.nextPiece("L");
		System.out.println(game.toString());
		game.rotateCurrentPieceCounterclockwise();
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		System.out.println("ULTIMA LINEA ELIMINADA");
		
		game.nextPiece("O");
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());game.moveCurrentPieceDown();
		System.out.println(game.toString());game.moveCurrentPieceDown();
		System.out.println(game.toString());game.moveCurrentPieceDown();
		System.out.println(game.toString());game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		game.nextPiece("Z");
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		
		game.nextPiece("I");
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		game.nextPiece("J");
		game.rotateCurrentPieceCounterclockwise();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		game.nextPiece("J");
		game.rotateCurrentPieceClockwise();
		System.out.println(game.toString());
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
	}
	
	public static void juego1PiezaI() throws WrongSizeException,
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
		
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		
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
		
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		game.moveCurrentPieceRight();
		System.out.println(game.toString());
		
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		game.nextPiece("I");
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		
		System.out.println(game.toString());
	}
	
	public static void juego2PiezaI() throws WrongSizeException,
			NoCurrentPieceException, GameEndedMovementException,
			FixedPieceMovementException, OffBoardMovementException,
			CollisionMovementException, CurrentPieceNotFixedException {
		Game game = new Game(new Coordinate(10, 10));
		System.out.println(game.toString());
		
		game.nextPiece("I");
		System.out.println(game.toString());
		
		game.rotateCurrentPieceClockwise();
		System.out.println(game.toString());
		
		game.moveCurrentPieceRight();
		game.moveCurrentPieceRight();
		game.moveCurrentPieceRight();
		game.moveCurrentPieceRight();
		
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		game.nextPiece("I");
		System.out.println(game.toString());
		game.rotateCurrentPieceClockwise();
		System.out.println(game.toString());
		
		game.moveCurrentPieceRight();
		game.moveCurrentPieceRight();
		game.moveCurrentPieceRight();
		
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		System.out.println("Pieza fija: " + game.isCurrentPieceFixed());
		
		game.nextPiece("I");
		System.out.println(game.toString());
		
		game.rotateCurrentPieceClockwise();
		System.out.println(game.toString());
		
		game.moveCurrentPieceRight();
		game.moveCurrentPieceRight();
		
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		game.nextPiece("I");
		System.out.println(game.toString());
		
		game.rotateCurrentPieceClockwise();
		System.out.println(game.toString());
		
		game.moveCurrentPieceRight();
		
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		game.nextPiece("I");
		System.out.println(game.toString());
		
		game.rotateCurrentPieceClockwise();
		System.out.println(game.toString());
		
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		game.nextPiece("I");
		System.out.println(game.toString());
		
		game.rotateCurrentPieceClockwise();
		System.out.println(game.toString());
		
		game.moveCurrentPieceLeft();
		
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		game.nextPiece("I");
		System.out.println(game.toString());
		
		game.rotateCurrentPieceClockwise();
		System.out.println(game.toString());
		
		game.moveCurrentPieceLeft();
		game.moveCurrentPieceLeft();
		
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		game.nextPiece("I");
		System.out.println(game.toString());
		
		game.rotateCurrentPieceClockwise();
		System.out.println(game.toString());
		
		game.moveCurrentPieceLeft();
		game.moveCurrentPieceLeft();
		game.moveCurrentPieceLeft();
		
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		game.nextPiece("I");
		System.out.println(game.toString());
		
		game.rotateCurrentPieceClockwise();
		System.out.println(game.toString());
		
		game.moveCurrentPieceLeft();
		game.moveCurrentPieceLeft();
		game.moveCurrentPieceLeft();
		game.moveCurrentPieceLeft();
		
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		
		game.nextPiece("I");
		System.out.println(game.toString());
		
		game.rotateCurrentPieceClockwise();
		System.out.println(game.toString());
		
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		game.moveCurrentPieceLeft();
		System.out.println(game.toString());
		
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
		game.moveCurrentPieceDown();
		System.out.println(game.toString());
	}
	
}