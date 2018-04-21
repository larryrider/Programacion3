package model.io;

import java.util.Date;
import java.util.Objects;

import model.Coordinate;
import model.Game;
import model.exceptions.*;
import model.exceptions.io.TetrisIOException;

/**
 * La clase GamePlay.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public class GamePlay {
	
	/** Altura del tablero. */
	static final int TETRIS_BOARD_STANDARD_HEIGHT = 20;
	
	/** Anchura del tablero. */
	static final int TETRIS_BOARD_STANDARD_WIDTH = 10;
	
	/** Juego. */
	private Game game;
	
	/** Player. */
	private IPlayer player;
	
	/** Visualizador.. */
	private IVisualizer visualizer;
	
	/**  filas borradas. */
	private int rowsCleared=0;
	
	/**  duracion de la partida. */
	private int duration=0;
	
	/**
	 * Constructor que instancia el juego, player, y visualizador.
	 *
	 * @param iplayer :el player
	 * @param ivisual :el visualizador
	 */
	public GamePlay(IPlayer iplayer, IVisualizer ivisual) {
		Objects.requireNonNull(iplayer,
				"El parametro iplayer no puede ser null");
		Objects.requireNonNull(ivisual,
				"El parametro ivisual no puede ser null");
		try {
			game = new Game(new Coordinate(TETRIS_BOARD_STANDARD_HEIGHT,
					TETRIS_BOARD_STANDARD_WIDTH));
			player = iplayer;
			visualizer = ivisual;
			visualizer.setGame(game);
		}
		catch (WrongSizeException e) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * Metodo que se encarga de jugar.
	 *
	 * @throws TetrisIOException Excepcion TetrisIO
	 */
	public void play() throws TetrisIOException {
		
		long t0 = new Date().getTime();
		
		Character movimiento;
		try {
			visualizer.show();
			movimiento = player.nextMove();
			while (movimiento != IPlayer.LAST_MOVE) {
				try {
					switch (movimiento) {
						case IPlayer.ROTATE_CLOCK:
							game.rotateCurrentPieceClockwise();
							break;
						case IPlayer.ROTATE_COUNTER:
							game.rotateCurrentPieceCounterclockwise();
							break;
						case IPlayer.MOVE_RIGHT:
							game.moveCurrentPieceRight();
							break;
						case IPlayer.MOVE_LEFT:
							game.moveCurrentPieceLeft();
							break;
						case IPlayer.MOVE_DOWN:
							rowsCleared+=game.moveCurrentPieceDown();
							break;
						default:
							game.nextPiece(movimiento.toString());
					}
				}
				catch (OffBoardMovementException e) {
				}
				catch (CollisionMovementException o) {
				}
				catch (FixedPieceMovementException f) {
				}
				
				visualizer.show();
				movimiento = player.nextMove();
			}
		}
		catch (GameEndedMovementException e) {
		}
		catch (NoCurrentPieceException e) {
			throw new TetrisIOException("No hay pieza en el tablero aun.");
		}
		catch (CurrentPieceNotFixedException e) {
			throw new TetrisIOException("La pieza no esta fija.");
		}
		
		long t1 = new Date().getTime();
	    duration = (int)(t1 - t0);
	}

	
	/**
	 * Getter de las filas borradas.
	 *
	 * @return filas borradas
	 */
	public int getRowsCleared() {
		return rowsCleared;
	}
	
	/**
	 * Getter de la duracion.
	 *
	 * @return duracion
	 */
	public int getDuration() {
		return duration;
	}

}
