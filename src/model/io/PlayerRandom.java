package model.io;

import java.util.Objects;
import java.util.Random;

import model.exceptions.io.TetrisIOException;

/**
 * La clase PlayerRandom.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public class PlayerRandom implements IPlayer {
	
	/** Numero aleatorio. */
	private Random random;
	
	/** Contiene si se hace un putPiece. */
	private boolean nextPutPiece = true;
	
	/** Contador de movimientos hacia abajo. */
	private int downCounter = 0;
	
	/**
	 * Constructor de un aleatorio en base a una semilla
	 *
	 * @param semilla la semilla
	 */
	PlayerRandom(long semilla) {
		Objects.requireNonNull(semilla, "El parametro semilla no puede ser null");
		random = new Random(semilla);
	}
	
	@Override
	public char nextMove() throws TetrisIOException {
		
		if (!nextPutPiece) {
			Integer aleatorio = random.nextInt(10);
			switch (aleatorio) {
				case 0:
					return MOVE_LEFT;
				case 1:
					return MOVE_RIGHT;
				case 2:
					return ROTATE_CLOCK;
				case 3:
					return ROTATE_COUNTER;
				default:
					if (downCounter < GamePlay.TETRIS_BOARD_STANDARD_HEIGHT) {
						downCounter++;
					}
					if (downCounter == GamePlay.TETRIS_BOARD_STANDARD_HEIGHT){
						downCounter = 0;
						nextPutPiece = true;
					}
					return MOVE_DOWN;
			}
		}
		else {
			Integer aleatorio = random.nextInt(8);
			switch (aleatorio) {
				case 0:
					nextPutPiece = false;
					return 'I';
				case 1:
					nextPutPiece = false;
					return 'J';
				case 2:
					nextPutPiece = false;
					return 'L';
				case 3:
					nextPutPiece = false;
					return 'O';
				case 4:
					nextPutPiece = false;
					return 'S';
				case 5:
					nextPutPiece = false;
					return 'T';
				case 6:
					nextPutPiece = false;
					return 'Z';
				case 7:
					nextPutPiece = false;
					return LAST_MOVE;
				default:
					return 0;
			}
		}
	}
	
}
