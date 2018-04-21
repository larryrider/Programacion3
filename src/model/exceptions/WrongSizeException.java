package model.exceptions;

import model.Coordinate;

/**
 * Excepcion WrongSizeException.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
@SuppressWarnings("serial")
public class WrongSizeException extends TetrisException {
	
	/**
	 * Coordenada c.
	 * 
	 */
	private Coordinate c;
	
	/**
	 * Constructor de wrong size exception.
	 *
	 * @param c :Coordenada c
	 */
	public WrongSizeException(Coordinate c) {
		super();
		this.c = c;
	}
	
	/**
	 * Metodo que muestra el mensaje de la excepcion
	 * 
	 * @return mensaje
	 */
	public String getMessage() {
		return "El tamaño del tablero " + c.toString()
				+ " es demasiado pequeño para introducir una pieza";
	}
	
}
