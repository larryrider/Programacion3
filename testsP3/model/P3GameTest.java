package model;

import java.util.Random;

import model.exceptions.CollisionMovementException;
import model.exceptions.CurrentPieceNotFixedException;
import model.exceptions.FixedPieceMovementException;
import model.exceptions.GameEndedMovementException;
import model.exceptions.NoCurrentPieceException;
import model.exceptions.OffBoardMovementException;
import model.exceptions.TetrisException;
import model.exceptions.WrongSizeException;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 *
 * @author Larry Rider
 */
public class P3GameTest {
	
	private Game game;
	
	@Before
	public void setUp() throws WrongSizeException {
		game = new Game(new Coordinate(7, 10));
	}
	
	@Test
	public void randomPlayTest() throws NoCurrentPieceException,
			GameEndedMovementException, FixedPieceMovementException,
			OffBoardMovementException, CollisionMovementException,
			CurrentPieceNotFixedException {
		Random rand = new Random();
		int randomChoose;
		
		System.out.println(game.toString());
		
		randomChoose = rand.nextInt((7 - 1) + 1) + 1;
		siguientePieza(randomChoose, true);
		
		while (game.isGameEnded() == false) {
			randomChoose = rand.nextInt((4 - 1) + 1) + 1;
			
			moveryrotarpieza(randomChoose);
			
			randomChoose = rand.nextInt((7 - 1) + 1) + 1;
			siguientePieza(randomChoose, false);
			
			System.out.println(game.toString());
			System.out.println("Currente piece fixed: "
					+ game.isCurrentPieceFixed());
		}
		System.out.println("Juego terminado:" + game.isGameEnded());
		assertTrue(game.isGameEnded() == true);
	}
	
	public void siguientePieza(int randomChoose, boolean primera)
			throws GameEndedMovementException, FixedPieceMovementException,
			NoCurrentPieceException, CurrentPieceNotFixedException {
		switch (randomChoose) {
		
			case 1:
				if (primera || game.isCurrentPieceFixed())
					game.nextPiece("I");
				else
					game.moveCurrentPieceDown();
				break;
			case 2:
				if (primera || game.isCurrentPieceFixed())
					game.nextPiece("J");
				else
					game.moveCurrentPieceDown();
				break;
			case 3:
				if (primera || game.isCurrentPieceFixed())
					game.nextPiece("L");
				else
					game.moveCurrentPieceDown();
				break;
			case 4:
				if (primera || game.isCurrentPieceFixed())
					game.nextPiece("O");
				else
					game.moveCurrentPieceDown();
				break;
			case 5:
				if (primera || game.isCurrentPieceFixed())
					game.nextPiece("S");
				else
					game.moveCurrentPieceDown();
				break;
			case 6:
				if (primera || game.isCurrentPieceFixed())
					game.nextPiece("T");
				else
					game.moveCurrentPieceDown();
				break;
			case 7:
				if (primera || game.isCurrentPieceFixed())
					game.nextPiece("Z");
				else
					game.moveCurrentPieceDown();
				break;
		}
	}
	
	public void moveryrotarpieza(int randomChoose) {
		switch (randomChoose) {
			case 1:
				try {
					game.moveCurrentPieceLeft();
				}
				catch (TetrisException t) {
					
				}
				break;
			case 2:
				try {
					game.moveCurrentPieceRight();
				}
				catch (TetrisException t) {
					
				}
				break;
			case 3:
				try {
					game.rotateCurrentPieceClockwise();
				}
				catch (TetrisException t) {
					
				}
				break;
			case 4:
				try {
					game.rotateCurrentPieceCounterclockwise();
				}
				catch (TetrisException t) {
					
				}
				break;
		}
	}
	
}