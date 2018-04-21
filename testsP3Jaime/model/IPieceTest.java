package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class IPieceTest {
	private static final String D0 = "····\n▒▒▒▒\n····\n····\n";
	private static final String D90 = "·▒··\n·▒··\n·▒··\n·▒··\n";
	private static final String D180 = "····\n····\n▒▒▒▒\n····\n";
	private static final String D270 = "··▒·\n··▒·\n··▒·\n··▒·\n";
	@Before
	public void setUp() throws Exception {
				
	}

	@Test
	public final void testConstructor() {
		Piece p = new I();
		String s = p.toString();
		assertEquals("D0", s, D0);
		assertFalse(p.isFixed());
		assertEquals("BlockSimbol", p.getBlockSymbol(), '▒');
	}		
	@Test
	public final void testRotationCounterClockwise(){
		Piece p = new I();
		
		p.rotateCounterclockwise();
		assertEquals("D90", p.toString(), D90);
		p.rotateCounterclockwise();
		assertEquals("D180", p.toString(), D180);
		p.rotateCounterclockwise();
		assertEquals("D270", p.toString(), D270);
		p.rotateCounterclockwise();
		assertEquals("D0", p.toString(), D0);

		
		
	}
	
	@Test
	public final void testRotationClockwise(){
		Piece p = new I();
		
		p.rotateClockwise();
		assertEquals("D270", p.toString(), D270);
		p.rotateClockwise();
		assertEquals("D180", p.toString(), D180);
		p.rotateClockwise();
		assertEquals("D90", p.toString(), D90);
		p.rotateClockwise();
		assertEquals("D0", p.toString(), D0);	
	}
	@Test
	public final void testOcupation(){
		Piece p = new I();

		Set<Coordinate> ocupadas = p.getAbsoluteCells(new Coordinate(3, 5));
		Set<Coordinate> ocupadasReal = new HashSet<Coordinate>();
		ocupadasReal.add(new Coordinate(4, 5));
		ocupadasReal.add(new Coordinate(4, 6));
		ocupadasReal.add(new Coordinate(4, 7));
		ocupadasReal.add(new Coordinate(4, 8));
		assertEquals("ocupadas D0", ocupadasReal, ocupadas);
		
		p.rotateClockwise(); // D270
		ocupadas = p.getAbsoluteCells(new Coordinate(3, 5));
		ocupadasReal.clear();
		ocupadasReal.add(new Coordinate(3, 7));
		ocupadasReal.add(new Coordinate(4, 7));
		ocupadasReal.add(new Coordinate(5, 7));
		ocupadasReal.add(new Coordinate(6, 7));
		assertEquals("ocupadas D270", ocupadasReal, ocupadas);
		
		p.rotateClockwise(); // D180
		ocupadas = p.getAbsoluteCells(new Coordinate(3, 5));
		ocupadasReal.clear();
		ocupadasReal.add(new Coordinate(5, 5));
		ocupadasReal.add(new Coordinate(5, 6));
		ocupadasReal.add(new Coordinate(5, 7));
		ocupadasReal.add(new Coordinate(5, 8));
		assertEquals("ocupadas D180", ocupadasReal, ocupadas);

		p.rotateClockwise(); // D90
		ocupadas = p.getAbsoluteCells(new Coordinate(3, 5));
		ocupadasReal.clear();
		ocupadasReal.add(new Coordinate(3, 6));
		ocupadasReal.add(new Coordinate(4, 6));
		ocupadasReal.add(new Coordinate(5, 6));
		ocupadasReal.add(new Coordinate(6, 6));
		assertEquals("ocupadas D90", ocupadasReal, ocupadas);
	}
	@Test
	public final void forgottenMethods(){
		Piece p = new I();
		
		p.setFixed(true);
		assertTrue("fijada", p.isFixed());
		
		p.setOrientation(Rotation.D180);
		assertEquals("orientation", p.getOrientation(), Rotation.D180);
	}
}
