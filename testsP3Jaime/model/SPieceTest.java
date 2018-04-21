package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
@SuppressWarnings("unused")
public class SPieceTest {
	private static final String D0 = "·▦▦·\n▦▦··\n····\n····\n";
	private static final String D90 = "▦···\n▦▦··\n·▦··\n····\n";
	private static final String D180 = "····\n·▦▦·\n▦▦··\n····\n";
	private static final String D270 = "·▦··\n·▦▦·\n··▦·\n····\n";

	@Test
	public final void testConstructor() {
		Piece p = new S();
		String s = p.toString();
		System.out.println("D0");
		System.out.println(s);
		assertEquals("D0", s, D0);
		assertFalse(p.isFixed());
		assertEquals("BlockSimbol", p.getBlockSymbol(), '▦');
	}		
	@Test
	public final void testRotationCounterClockwise(){
		Piece p = new S();
		
		p.rotateCounterclockwise();
		System.out.println("D90");
		System.out.println(p);
		assertEquals("D90", p.toString(), D90);
		p.rotateCounterclockwise();
		System.out.println("D180");
		System.out.println(p);
		assertEquals("D180", p.toString(), D180);
		p.rotateCounterclockwise();
		System.out.println("270");
		System.out.println(p);
		assertEquals("D270", p.toString(), D270);
		p.rotateCounterclockwise();
		assertEquals("D0", p.toString(), D0);
	}
	
	@Test
	public final void testRotationClockwise(){
		Piece p = new S();
		
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
	public final void forgottenMethods(){
		Piece p = new S();
		
		p.setFixed(true);
		assertTrue("fijada", p.isFixed());
		
		p.setOrientation(Rotation.D180);
		assertEquals("orientation", p.getOrientation(), Rotation.D180);
	}
}
