package model.exceptions.score;

import model.exceptions.TetrisException;

/**
 * Excepcion RankingException.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
@SuppressWarnings("serial")
public class RankingException extends TetrisException{
	
	
	/**
	 * Constructor de ranking exception.
	 * 
	 */
	public RankingException() {
		super();
	}
	
	/**
	 * Metodo que muestra el mensaje de la excepcion
	 * 
	 * @return mensaje
	 */
	public String getMessage() {
		return "El ranking actual esta vacio o no es valido";
	}
	
}
