package model.io;

import model.Game;
import model.exceptions.WrongSizeException;

/**
 * La clase IVisualizer.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public interface IVisualizer {
	
	/**
	 * Instancia el juego.
	 *
	 * @param game :el juego
	 * @throws WrongSizeException Excepcion
	 */
	public void setGame(Game game) throws WrongSizeException;
	
	/**
	 * Muestra la partida.
	 */
	public void show();
}
