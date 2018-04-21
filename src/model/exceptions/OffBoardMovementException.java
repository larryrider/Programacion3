package model.exceptions;

import model.Coordinate;

/**
 * Excepcion OffBoardMovementException.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
@SuppressWarnings("serial")
public class OffBoardMovementException extends MovementException {
	
	/**
	 * The c.
	 * 
	 */
	private Coordinate c;
	
	/**
	 * Constructor de off board movement exception.
	 *
	 * @param c :Coordenada c
	 */
	public OffBoardMovementException(Coordinate c) {
		super();
		this.c = c;
	}
	
	/**
	 * Metodo que muestra el mensaje de la excepcion
	 * 
	 * @return mensaje
	 */
	public String getMessage() {
		return "Movimiento a " + c.toString() + " ilegal, fuera del tablero";
	}
	
}