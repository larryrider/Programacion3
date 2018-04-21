package model.io;

import java.util.Objects;

import model.Coordinate;
import model.Game;
import model.exceptions.WrongSizeException;

/**
 * La clase PlayerString.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public class VisualizerConsole implements IVisualizer {
	
	/** Variable juego. */
	private Game juego;
	
	/**
	 * Constructor de visualizer console.
	 */
	VisualizerConsole() {
		juego = null;
	}
	
	
	@Override
	public void setGame(Game game) throws WrongSizeException {
		Objects.requireNonNull(game, "El parametro game no puede ser null");
		
		Integer altura_tablero = game.getGameboard().getHeight();
		Integer anchura_tablero = game.getGameboard().getWidth();
		
		if (GamePlay.TETRIS_BOARD_STANDARD_HEIGHT == altura_tablero
				&& GamePlay.TETRIS_BOARD_STANDARD_WIDTH == anchura_tablero) {
			juego = game;
		}
		else {
			throw new WrongSizeException(new Coordinate(altura_tablero, anchura_tablero));
		}
	}
	

	@Override
	public void show() {
		Objects.requireNonNull(juego, "El parametro game no puede ser null");
		
		System.out.println(juego.toString());
		
	}
	
}
