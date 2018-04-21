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
public class GameBoardTest {
	private static final String D0 = "····\n▒▒▒▒\n····\n····\n";
	private static final String D90 = "·▒··\n·▒··\n·▒··\n·▒··\n";
	private static final String D180 = "····\n····\n▒▒▒▒\n····\n";
	private static final String D270 = "··▒·\n··▒·\n··▒·\n··▒·\n";
	@Before
	public void setUp() throws Exception {
				
	}

	@Test
	public final void testConstructor() throws WrongSizeException{
		Gameboard gb = new Gameboard(new Coordinate(4, 5));
		String vacio45 ="·····\n·····\n·····\n·····\n";
		assertEquals("vacio", gb.toString(), vacio45);
		assertEquals("altura", gb.getHeight(), 4);
		assertEquals("anchura", gb.getWidth(), 5);
	}		
	@Test
	public final void testPutPiece() throws WrongSizeException{
		Piece p = new I();
		Piece p2 = new I();
		String miTablero = "··▒······\n··▒······\n··▒······\n··▒······\n·····▒▒▒▒\n";
		Gameboard gb = new Gameboard(new Coordinate(5, 9));
		gb.putPiece(new Coordinate(3, 5), p);
		
		p2.rotateClockwise();
		gb.putPiece(new Coordinate(0,0), p2);
		
		assertEquals("dos piezas", gb.toString(), miTablero);
	}
	
	@Test
	public final void testPlaceValid() throws WrongSizeException{
		Gameboard gb = new Gameboard(new Coordinate(6, 6));
		Piece pD0 = new I(); // D0
		Piece pD90 = new I();
		pD90.rotateCounterclockwise();
		
		
		assertTrue("valido", gb.isPlaceValid(new Coordinate(-1, 0), pD0));
		assertTrue("valido", gb.isPlaceValid(new Coordinate(0, 2), pD0));
		assertFalse("no valido", gb.isPlaceValid(new Coordinate(0, -1), pD0));
		assertFalse("no valido", gb.isPlaceValid(new Coordinate(0, 3), pD0));

		assertTrue("valido", gb.isPlaceValid(new Coordinate(2, 0), pD90));
		assertFalse("no valido", gb.isPlaceValid(new Coordinate(3, 0), pD90));
		assertFalse("no valido", gb.isPlaceValid(new Coordinate(-1, -1), pD90));
		
	}
	@Test
	public final void testPlaceFree() throws WrongSizeException{
		Gameboard gb = new Gameboard(new Coordinate(6, 6));
		Piece pD0 = new I(); // D0
		Piece pD90 = new I();
		pD90.rotateCounterclockwise();
		
		Piece trozo = new I();
		trozo.setFixed(true);
		gb.setCellContent(new Coordinate(2,2), trozo);
		System.out.println(pD0);
		System.out.println(gb);
		assertTrue("libre", gb.isPlaceFree(new Coordinate(0, 1), pD0));
		assertFalse("ocupada", gb.isPlaceFree(new Coordinate(1, 2), pD0));
		assertTrue("libre", gb.isPlaceFree(new Coordinate(2, 0), pD90));
		assertFalse("ocupada", gb.isPlaceFree(new Coordinate(2, 1), pD90));
		
		// solo se tiene en cuenta si esta fija :(
		trozo.setFixed(false);
		assertTrue("libre", gb.isPlaceFree(new Coordinate(0, 1), pD0));
		assertTrue("ocupada", gb.isPlaceFree(new Coordinate(1, 2), pD0));
		assertTrue("libre", gb.isPlaceFree(new Coordinate(2, 0), pD90));
		assertTrue("ocupada", gb.isPlaceFree(new Coordinate(2, 1), pD90));
		
	}
	@Test
	public final void testRemovePiece() throws WrongSizeException{
		Piece p = new I();
		Piece p2 = new I();
		String miTablero = "··▒······\n··▒······\n··▒······\n··▒······\n·····▒▒▒▒\n";
		Gameboard gb = new Gameboard(new Coordinate(5, 9));
		gb.putPiece(new Coordinate(3, 5), p);
		
		p2.rotateClockwise();
		gb.putPiece(new Coordinate(0,0), p2);
		
		gb.removePiece(p2);
		System.out.println(gb);
		
		assertNull("vacio", gb.getCellContent(new Coordinate(0, 2)));
		assertNull("vacio", gb.getCellContent(new Coordinate(1, 2)));
		assertNull("vacio", gb.getCellContent(new Coordinate(2, 2)));
		assertNull("vacio", gb.getCellContent(new Coordinate(3, 2)));
		
		assertNotNull("no vacio", gb.getCellContent(new Coordinate(4, 5)));
		assertNotNull("no vacio", gb.getCellContent(new Coordinate(4, 6)));
		assertNotNull("no vacio", gb.getCellContent(new Coordinate(4, 7)));
		assertNotNull("no vacio", gb.getCellContent(new Coordinate(4, 8)));	
	}
}
