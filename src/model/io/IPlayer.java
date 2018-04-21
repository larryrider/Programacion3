package model.io;

import model.exceptions.io.TetrisIOException;

/**
 * La clase IPlayer.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public interface IPlayer {
	
	/** Ultimo movimiento. */
	public static final char LAST_MOVE = '\u25CF'; // '●'
	
	/** Rotacion en sentido de las agujas. */
	public static final char ROTATE_CLOCK = '\u21BB'; //'↻'
	
	/** Rotacion en sentido contrario a las agujas. */
	public static final char ROTATE_COUNTER ='\u21BA'; //'↺'
	
	/** Mover a la derecha. */
	public static final char MOVE_RIGHT = '\u2192'; //'→'
	
	/** Mover a la izquierda. */
	public static final char MOVE_LEFT = '\u2190'; //'←'
	
	/** Mover abajo. */
	public static final char MOVE_DOWN = '\u2193'; //'↓'
	
	/**
	 * Metodo nextMove, devuelve el siguiente movimiento.
	 *
	 * @return char movimiento siguiente
	 * @throws TetrisIOException Excepcion tetrisIO
	 */
	public char nextMove() throws TetrisIOException;
	
}
