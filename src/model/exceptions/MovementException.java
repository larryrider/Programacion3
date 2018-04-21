package model.exceptions;

/**
 * Excepcion MovementException.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
@SuppressWarnings("serial")
public class MovementException extends TetrisException {
	
	/**
	 * Constructor movement exception.
	 */
	public MovementException() {
		super();
	}
	
	/**
	 * Metodo que muestra el mensaje de la excepcion
	 * 
	 * @return mensaje
	 */
	public String getMessage() {
		return "Movimiento ilegal";
	}
	
}
