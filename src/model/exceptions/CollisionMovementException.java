package model.exceptions;

import model.Coordinate;

/**
 * Excepcion CollisionMovementException.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
@SuppressWarnings("serial")
public class CollisionMovementException extends MovementException {
	
	/**
	 * Coordenada c.
	 * 
	 */
	private Coordinate c;
	
	/**
	 * Constructor de collision movement exception.
	 *
	 * @param c :Coordenada c
	 */
	public CollisionMovementException(Coordinate c) {
		super();
		this.c = c;
	}
	
	/**
	 * Metodo que muestra el mensaje de la excepcion
	 * 
	 * @return mensaje
	 */
	public String getMessage() {
		return "Movimiento a " + c.toString()
				+ " ilegal, ya hay una pieza en ese sitio";
	}
	
}