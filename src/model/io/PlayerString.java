package model.io;

import java.util.Objects;

import model.exceptions.io.TetrisIOException;

/**
 * La clase PlayerString.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public class PlayerString implements IPlayer {
	/**
	 * @param moves String con los movimientos
	 */
	private String moves;
	/**
	 * @param currentMove Movimiento actual
	 */
	private int currentMove = 0;
	
	/**
	 * Constructor de PlayerString
	 * 
	 * @param movimientos : Movimientos que se le pasan
	 */
	PlayerString(String movimientos) {
		Objects.requireNonNull(movimientos,
				"El parametro movimientos no puede ser null");
		moves = movimientos;
	}
	
	@Override
	public char nextMove() throws TetrisIOException {
		
		if (moves.length() == currentMove) {
			currentMove = 0;
			return LAST_MOVE;
		}
		
		char cadena = moves.charAt(currentMove);
		currentMove++;
		switch (cadena) {
			case 'I':			
				return 'I';
			case 'J':			
				return 'J';
			case 'L':			
				return 'L';
			case 'O':				
				return 'O';
			case 'S':				
				return 'S';
			case 'T':				
				return 'T';
			case 'Z':				
				return 'Z';
			case ROTATE_CLOCK:				
				return ROTATE_CLOCK;
			case ROTATE_COUNTER:
				return ROTATE_COUNTER;
			case MOVE_RIGHT:
				return MOVE_RIGHT;
			case MOVE_LEFT:
				return MOVE_LEFT;
			case MOVE_DOWN:
				return MOVE_DOWN;
		}
		throw new TetrisIOException("Movimiento incorrecto");
	}
}
