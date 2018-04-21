package model;

import static org.junit.Assert.*;
import model.exceptions.CollisionMovementException;
import model.exceptions.CurrentPieceNotFixedException;
import model.exceptions.FixedPieceMovementException;
import model.exceptions.GameEndedMovementException;
import model.exceptions.NoCurrentPieceException;
import model.exceptions.OffBoardMovementException;

import org.junit.Before;
import org.junit.Test;

public class P2TestGame {

	Game game;
	
	@Before
	public void setUp() throws Exception {
	
		game = new Game(new Coordinate(7, 10));
		//System.out.println(game.toString());	
	}
	
	
	@Test
	public void testRotate() throws NoCurrentPieceException, GameEndedMovementException, FixedPieceMovementException, OffBoardMovementException, CollisionMovementException, CurrentPieceNotFixedException {
		game.nextPiece("I");
		game.rotateCurrentPieceCounterclockwise();
		assertEquals("Rot Antihorario", "····▒·····\n"
				                      + "····▒·····\n"
				                      + "····▒·····\n"
				                      + "····▒·····\n"
				                      + "··········\n"
				                      + "··········\n"
				                      + "··········\n", game.toString());
		game.rotateCurrentPieceClockwise();
		assertEquals("Rot Antihorario", "··········\n"
				                      + "···▒▒▒▒···\n"
				                      + "··········\n"
				                      + "··········\n"
				                      + "··········\n"
				                      + "··········\n"
				                      + "··········\n", game.toString());
	}
	
	@Test
	public void moverPieza() throws NoCurrentPieceException, GameEndedMovementException, FixedPieceMovementException, OffBoardMovementException, CollisionMovementException, CurrentPieceNotFixedException {
		game.nextPiece("I");
		game.moveCurrentPieceDown();
		assertEquals("Abajo", "··········\n"
				            + "··········\n"
				            + "···▒▒▒▒···\n"
				            + "··········\n"
				            + "··········\n"
				            + "··········\n"
				            + "··········\n", game.toString());
		game.moveCurrentPieceLeft();
		assertEquals("Izquierda", "··········\n"
				                + "··········\n"
				                + "··▒▒▒▒····\n"
				                + "··········\n"
				                + "··········\n"
				                + "··········\n"
				                + "··········\n", game.toString());
		game.moveCurrentPieceRight();
		assertEquals("Derecha", "··········\n"
			               	  + "··········\n"
			               	  + "···▒▒▒▒···\n"
			               	  + "··········\n"
			               	  + "··········\n"
			               	  + "··········\n"
			               	  + "··········\n", game.toString());
	}
	
	@Test
	public final void jugarHastaFijar() throws NoCurrentPieceException, GameEndedMovementException, FixedPieceMovementException, OffBoardMovementException, CollisionMovementException, CurrentPieceNotFixedException
	{
		/*
		 * Voy a colocar varias piezas hasta que se monten unas sobre otras, me aseguro de que se fijan
		 */
		
		game.nextPiece("I");
		game.rotateCurrentPieceClockwise();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		
		assertEquals("Aun no fija", false, game.isCurrentPieceFixed());
		
		game.moveCurrentPieceDown();
		assertEquals("Ahora si fija", true, game.isCurrentPieceFixed());

		//Siguiente pieza que se deberia parar al tocar con la pieza anterior
		
		game.nextPiece("I");
		assertEquals("Aun no fija", false, game.isCurrentPieceFixed());
		
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		
		assertEquals("Deberia fijarse a la anterior", true, game.isCurrentPieceFixed());
		
		//System.out.println(game.toString());
		
	}
}
