package model;

/**
 * Clase T.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public class T extends Piece {
	
	/** 
	 * Forma de la pieza T.
	 * 
	 */
	private static int shape[][] = new int[][] {
			{ 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 } };
	
	@Override
	protected int[][] getShape() {
		return shape;
	}

	@Override
	public T copy() {
		T p = new T();
		p.copyAttributes(this);
		return p;
	}
	
	/**
	 * Constructor de una pieza "T".
	 */
	public T() {
		super();
//		blockSymbol = '▤';
		blockSymbol='\u25A4';
	}
}