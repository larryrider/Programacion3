package model;

/**
 * Clase I.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public class I extends Piece {
	
	/**
	 * Forma de la pieza I.
	 * 
	 */
	private static int shape[][] = new int[][] {
			{ 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0 },
			{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 } };
	
	@Override
	protected int[][] getShape() {
		return shape;
	}
	
	@Override
	public I copy() {
		I p = new I();
		p.copyAttributes(this);
		return p;
	}
	
	/**
	 * Constructor de una pieza "I".
	 * 
	 */
	public I() {
		super();
		// blockSymbol = '▒';
		blockSymbol = '\u2592';
	}
}