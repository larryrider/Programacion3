package model.exceptions;

/**
 * Excepcion NoCurrentPieceException.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
@SuppressWarnings("serial")
public class NoCurrentPieceException extends TetrisException {
	
	/**
	 * Constructor de no current piece exception.
	 */
	public NoCurrentPieceException() {
		super();
	}
	
	/**
	 * Metodo que muestra el mensaje de la excepcion
	 * 
	 * @return mensaje
	 */
	public String getMessage() {
		return "La partida no ha empezado aun, no hay ninguna pieza actual";
	}
	
}
