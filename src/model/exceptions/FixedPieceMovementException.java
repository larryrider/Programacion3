package model.exceptions;

/**
 * Excepcion FixedPieceMovementException.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
@SuppressWarnings("serial")
public class FixedPieceMovementException extends MovementException {
	
	/**
	 * Constructor de fixed piece movement exception.
	 */
	public FixedPieceMovementException() {
		super();
	}
	
	/**
	 * Metodo que muestra el mensaje de la excepcion
	 * 
	 * @return mensaje
	 */
	public String getMessage() {
		return "La pieza no se puede mover porque ya está fijada";
	}
	
}