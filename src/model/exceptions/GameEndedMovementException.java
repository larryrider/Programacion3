package model.exceptions;

/**
 * Excepcion GameEndedMovementException.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
@SuppressWarnings("serial")
public class GameEndedMovementException extends MovementException{
	
	/**
	 * Constructor de game ended movement exception.
	 */
	public GameEndedMovementException(){
		super();
	}
	
	/**
	 * Metodo que muestra el mensaje de la excepcion
	 * 
	 * @return mensaje
	 */
	public String  getMessage(){
		return "La pieza no se puede mover o añadir a la partida porque la partida ya se ha terminado";
	}
	
}