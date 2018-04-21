package model;

/**
 * La clase S.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public class S extends Piece {
	
	/**
	 * 
	 * Forma de la pieza S.
	 */
	private static int shape[][] = new int[][] {
			{ 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
			{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 } };
	
	@Override
	protected int[][] getShape() {
		return shape;
	}
	
	@Override
	public S copy() {
		S p = new S();
		p.copyAttributes(this);
		return p;
	}
	
	/**
	 * Constructor de una pieza "S".
	 */
	public S() {
		super();
//		blockSymbol = '▦';
		blockSymbol='\u25A6';
	}
}