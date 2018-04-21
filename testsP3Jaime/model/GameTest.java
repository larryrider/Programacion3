package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import model.exceptions.WrongSizeException;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("unused")
public class GameTest {
	private static final String D0 = "····\n▒▒▒▒\n····\n····\n";
	private static final String D90 = "·▒··\n·▒··\n·▒··\n·▒··\n";
	private static final String D180 = "····\n····\n▒▒▒▒\n····\n";
	private static final String D270 = "··▒·\n··▒·\n··▒·\n··▒·\n";
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public final void testConstructor() throws WrongSizeException{
		Game juego = new Game(new Coordinate(10, 8));
		String juego10x8 = "········\n········\n········\n········\n········\n········\n········\n········\n········\n········\n";
		assertEquals("por defecto", juego.toString(), juego10x8);
		assertFalse("no acabado", juego.isGameEnded());
	}
	@Test
	public final void testNextPiece()throws Exception{
		Game juego = new Game(new Coordinate(10, 8));
		String juego10x8 = "········\n··▒▒▒▒··\n········\n········\n········\n········\n········\n········\n········\n········\n";
		String juego10x8_1 = "···▒····\n···▒····\n···▒····\n···▒····\n········\n········\n········\n········\n········\n········\n";
		String juego10x8_2 = "·······▒\n·······▒\n·······▒\n·······▒\n········\n········\n········\n········\n········\n········\n";
		String abajo =  "········\n········\n········\n········\n········\n········\n······▒·\n······▒·\n······▒·\n······▒·\n";
		String finales = "········\n········\n········\n········\n········\n···▒▒▒▒·\n······▒·\n······▒·\n··▒▒▒▒▒·\n··▒▒▒▒▒·\n";
		juego.nextPiece("I");
		assertEquals("nextPiece", juego10x8, juego.toString());
		juego.rotateCurrentPieceCounterclockwise();
		assertEquals("nextPiece", juego10x8_1, juego.toString());
		juego.moveCurrentPieceRight();
		juego.moveCurrentPieceRight();
		juego.moveCurrentPieceRight();
		juego.moveCurrentPieceRight();
		
		//juego.moveCurrentPieceRight();
		//juego.moveCurrentPieceRight();
		//juego.moveCurrentPieceRight();
		//juego.moveCurrentPieceRight();
		//juego.moveCurrentPieceRight();
		assertEquals("nextPiece", juego10x8_2, juego.toString());
		//juego.rotateCurrentPieceClockwise();
		assertEquals("nextPiece", juego10x8_2, juego.toString());
		//juego.rotateCurrentPieceCounterclockwise();
		assertEquals("nextPiece", juego10x8_2, juego.toString());
		
	/*	juego.moveCurrentPieceLeft();
		for(int i = 1; i < 10; i++){
			juego.moveCurrentPieceDown();
		}
		assertEquals("abajo", abajo, juego.toString());
		
		juego.nextPiece("I");
		System.out.println(juego);
		
		for(int i = 1; i < 10; i++){
			juego.moveCurrentPieceDown();
		}
		System.out.println(juego);
		juego.nextPiece("I");
		System.out.println(juego);
		
		for(int i = 1; i < 10; i++){
			juego.moveCurrentPieceDown();
		}
		System.out.println(juego);
		juego.nextPiece("I");
		juego.moveCurrentPieceRight();
		for(int i = 1; i < 10; i++){
			juego.moveCurrentPieceDown();
		}
		System.out.println(juego);
		assertEquals("final", juego.toString(), finales);
		*/
	}
		
}
