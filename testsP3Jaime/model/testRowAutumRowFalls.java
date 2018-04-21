package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
@SuppressWarnings("unused")
public class testRowAutumRowFalls {

	@Test
	public void test() throws Exception {
			Game juego = new Game(new Coordinate(8, 6));
	
			juego.nextPiece("O");
			for(int i = 1; i <= 7; i++)
				juego.moveCurrentPieceDown();		
			System.out.println(juego);

			juego.nextPiece("O");
			for(int i = 1; i <= 2; i++)
				juego.moveCurrentPieceLeft();
			
			for(int i = 1; i <= 7; i++)
				juego.moveCurrentPieceDown();		
			System.out.println(juego);

			juego.nextPiece("O");
			for(int i = 1; i <= 2; i++)
				juego.moveCurrentPieceRight();
			System.out.println(juego);
			
			for(int i = 1; i <= 6; i++)
				juego.moveCurrentPieceDown();		
			System.out.println(juego);

			juego.moveCurrentPieceDown();
			System.out.println(juego);
			
			String vacio = "······\n······\n······\n······\n······\n······\n······\n······\n";
			assertEquals("queda vacio", vacio, juego.toString());
	}

}
