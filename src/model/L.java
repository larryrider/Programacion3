package model;

/**
 * Clase L.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public class L extends Piece {
	
	/** 
	 * Forma de la pieza L. 
	 * 
	 */
	private static int shape[][] = new int[][] {
			{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 } };
	
	@Override
	protected int[][] getShape() {
		return shape;
	}
	
	@Override
	public L copy() {
		L p = new L();
		p.copyAttributes(this);
		return p;
	}
	
	/**
	 * Constructor de una pieza "L".
	 */
	public L() {
		super();
		//blockSymbol = '▧';
		blockSymbol='\u25A7';
	}
}