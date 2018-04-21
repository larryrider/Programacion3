package model;

/**
 * La clase Z.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public class Z extends Piece {
	
	/**
	 * Forma de la pieza Z.
	 * 
	 */
	private static int shape[][] = new int[][] {
			{ 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 } };
	
	@Override
	protected int[][] getShape() {
		return shape;
	}
	
	@Override
	public Z copy() {
		Z p = new Z();
		p.copyAttributes(this);
		return p;
	}
	
	/**
	 * Constructor de una pieza "Z".
	 */
	public Z() {
		super();
		// blockSymbol = '◫';
		blockSymbol = '\u25EB';
	}
}