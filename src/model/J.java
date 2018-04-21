package model;

/**
 * Clase J.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public class J extends Piece {
	
	/**
	 * Forma de la pieza J.
	 * 
	 */
	private static int shape[][] = new int[][] {
			{ 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 } };
	
	@Override
	protected int[][] getShape() {
		return shape;
	}
	
	@Override
	public J copy() {
		J p = new J();
		p.copyAttributes(this);
		return p;
	}
	
	/**
	 * Constructor de una pieza "J".
	 */
	public J() {
		super();
		// blockSymbol = '◪';
		blockSymbol = '\u25EA';
	}
}
