package model.exceptions.io;

import model.exceptions.TetrisException;

/**
 * Excepcion TetrisIOException.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
@SuppressWarnings("serial")
public class TetrisIOException extends TetrisException{
	
	/**
	 * Mensaje
	 */
	private String message;
	
	/**
	 * Constructor de tetris exception.
	 * 
	 * @param mensaje Mensaje de la excepcion
	 */
	public TetrisIOException(String mensaje) {
		super();
		message=mensaje;
	}
	
	/**
	 * Metodo que muestra el mensaje de la excepcion
	 * 
	 * @return mensaje
	 */
	public String getMessage() {
		return message;
	}
	
}
