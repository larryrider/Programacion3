package model.io;

import java.io.*;
import java.util.Objects;

import model.exceptions.io.TetrisIOException;

/**
 * La clase PlayerFile.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public class PlayerFile implements IPlayer {
	
	/** Buffered reader. */
	private BufferedReader br;
	
	/**
	 * Constructor.
	 *
	 * @param buffer Buffer que recibe
	 */
	PlayerFile(BufferedReader buffer) {
		Objects.requireNonNull(buffer, "El parametro buffer no puede ser null");
		br = buffer;
	}
	

	@Override
	public char nextMove() throws TetrisIOException {
		
		try {
			String linea = br.readLine();
			
			if (linea == null) {
				return LAST_MOVE;
			}
			
			String palabras[] = linea.trim().split("\\s+");
			
			if (palabras.length == 2) {
				
				String accion = palabras[0];
				String movimiento = palabras[1];
				
				if (accion.contentEquals("put")) {
					switch (movimiento) {
						case "I":
							return 'I';
						case "J":
							return 'J';
						case "L":
							return 'L';
						case "O":
							return 'O';
						case "S":
							return 'S';
						case "T":
							return 'T';
						case "Z":
							return 'Z';
					}
				}
				else if (accion.contentEquals("rotate")) {
					switch (movimiento) {
						case "clockwise":
							return ROTATE_CLOCK;
						case "counterclockwise":
							return ROTATE_COUNTER;
					}
				}
				else if (accion.contentEquals("move")) {
					switch (movimiento) {
						case "right":
							return MOVE_RIGHT;
						case "left":
							return MOVE_LEFT;
						case "down":
							return MOVE_DOWN;
					}
				}
				throw new TetrisIOException("Movimiento leido incorrecto");
			}
			throw new TetrisIOException("Linea leida incorrecta (tamaño erroneo)");
		}
		catch (IOException e) {
			throw new TetrisIOException("No se ha podido leer una linea del Buffer");
		}
	}
}
