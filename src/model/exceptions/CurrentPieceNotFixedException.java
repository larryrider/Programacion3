package model.exceptions;

/**
 * Excepcion CurrentPieceNotFixedException.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
@SuppressWarnings("serial")
public class CurrentPieceNotFixedException extends TetrisException {
	
	/**
	 * Constructor de current piece not fixed exception.
	 */
	public CurrentPieceNotFixedException() {
		super();
	}
	
	/**
	 * Metodo que muestra el mensaje de la excepcion
	 * 
	 * @return mensaje
	 */
	public String getMessage() {
		return "La pieza actual no esta fijada y se quiere poner una nueva pieza en el tablero";
	}
	
}
