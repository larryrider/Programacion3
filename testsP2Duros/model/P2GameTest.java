/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class P2GameTest {
	
	private Game game;
	
	@Before
	public void setUp() throws WrongSizeException {
		game = new Game(new Coordinate(7, 10));
	}
	
	@Test
	public void testnextPiece() throws GameEndedMovementException,
			CurrentPieceNotFixedException {
		boolean expected = true;
		boolean toBeTested = game.nextPiece("I");
		
		assertTrue(expected == toBeTested);
		
	}
	
	@Test
	public void testRotationCounterclockwise() throws NoCurrentPieceException,
			GameEndedMovementException, FixedPieceMovementException,
			OffBoardMovementException, CollisionMovementException,
			CurrentPieceNotFixedException {
		String expected = "····▒·····\n" + "····▒·····\n" + "····▒·····\n"
				+ "····▒·····\n" + "··········\n" + "··········\n"
				+ "··········\n";
		game.nextPiece("I");
		
		game.rotateCurrentPieceCounterclockwise();
		
		assertTrue(expected.equals(game.toString()));
		
	}
	
	@Test
	public void forceBoundsTest() throws NoCurrentPieceException,
			GameEndedMovementException, FixedPieceMovementException,
			OffBoardMovementException, CollisionMovementException,
			CurrentPieceNotFixedException {
		game.nextPiece("I");
		
		game.rotateCurrentPieceCounterclockwise();
		game.moveCurrentPieceLeft();
		game.moveCurrentPieceLeft();
		game.moveCurrentPieceLeft();
		game.moveCurrentPieceLeft();
		try {
			game.moveCurrentPieceLeft();
			game.moveCurrentPieceLeft();
			game.moveCurrentPieceLeft();
			game.moveCurrentPieceLeft();
		}
		catch (TetrisException t) {
			
		}
		
		String expected = "▒·········\n" + "▒·········\n" + "▒·········\n"
				+ "▒·········\n" + "··········\n" + "··········\n"
				+ "··········\n";
		
		// System.out.println(game.toString());
		assertTrue(expected.equals(game.toString()));
		
		expected = "·········▒\n" + "·········▒\n" + "·········▒\n"
				+ "·········▒\n" + "··········\n" + "··········\n"
				+ "··········\n";
		
		game.moveCurrentPieceRight();
		game.moveCurrentPieceRight();
		game.moveCurrentPieceRight();
		game.moveCurrentPieceRight();
		game.moveCurrentPieceRight();
		game.moveCurrentPieceRight();
		game.moveCurrentPieceRight();
		game.moveCurrentPieceRight();
		game.moveCurrentPieceRight();
		try {
			game.moveCurrentPieceRight();
			game.moveCurrentPieceRight();
			game.moveCurrentPieceRight();
		}
		catch (TetrisException t) {
			
		}
		
		// System.out.println(game.toString());
		assertTrue(expected.equals(game.toString()));
		
		expected = "··········\n" + "··········\n" + "··········\n"
				+ "·········▒\n" + "·········▒\n" + "·········▒\n"
				+ "·········▒\n";
		
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		game.moveCurrentPieceDown();
		
		// System.out.println(game.toString());
		assertTrue(expected.equals(game.toString()));
	}
	
	@Test
	public void gamePlayTest() throws NoCurrentPieceException,
			GameEndedMovementException, FixedPieceMovementException,
			CurrentPieceNotFixedException {
		game.nextPiece("I");
		
		while (game.isGameEnded() == false) {
			game.moveCurrentPieceDown();
			if (game.isCurrentPieceFixed() == true)
				game.nextPiece("I");
		}
		
		// System.out.println(game.toString());
		
		assertTrue(game.isGameEnded() == true);
	}
	
	@Test
	public void randomPlayTest() throws NoCurrentPieceException,
			GameEndedMovementException, FixedPieceMovementException,
			OffBoardMovementException, CollisionMovementException,
			CurrentPieceNotFixedException {
		Random rand = new Random();
		int randomChoose;
		
		System.out.println(game.toString());
		
		game.nextPiece("I");
		
		System.out.println(game.toString());
		
		while (game.isGameEnded() == false) {
			randomChoose = rand.nextInt((4 - 1) + 1) + 1;
			
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
			
			if (game.isCurrentPieceFixed() == true)
				game.nextPiece("I");
			else
				game.moveCurrentPieceDown();
			
			System.out.println(game.toString());
			System.out.println("Currente piece fixed: "
					+ game.isCurrentPieceFixed());
		}
		
		assertTrue(game.isGameEnded() == true);
	}
}
