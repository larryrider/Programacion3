package model;

/**
 * La clase O.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public class O extends Piece {
	
	/** 
	 * Forma de la pieza O. 
	 * 
	 */
	private static int shape[][] = new int[][] {
			{ 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
	
	@Override
	protected int[][] getShape() {
		return shape;
	}
	
	@Override
	public O copy() {
		O p = new O();
		p.copyAttributes(this);
		return p;
	}
	
	/**
	 * Constructor de una pieza "O".
	 */
	public O() {
		super();
		//blockSymbol = '▣';
		blockSymbol='\u25A3';
	}
}