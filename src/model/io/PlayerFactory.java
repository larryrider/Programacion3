package model.io;

import java.io.*;
import java.util.Objects;

import model.exceptions.io.TetrisIOException;

/**
 * La clase PlayerFactory.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public class PlayerFactory {
	
	/**
	 * Constructor vacio.
	 */
	public PlayerFactory(){
		
	}
	
	/**
	 * Se encarga de crear un juego.
	 *
	 * @param cadena string cadena
	 * @return Iplayer
	 * @throws TetrisIOException Excepcion Tetris IO
	 */
	public static IPlayer createPlayer(String cadena) throws TetrisIOException {
		
		Objects.requireNonNull(cadena, "El parametro cadena no puede ser null");
		
		if (cadena.contains(".") || cadena.contains("/")
				|| cadena.contains("\\")) {
			try {
				return new PlayerFile(new BufferedReader(new FileReader(cadena)));
			}
			catch (FileNotFoundException e) {
				throw new TetrisIOException("Problema inexperado con el fichero (BufferedReader)");
			}
		}
		
		if (isLong(cadena)){
			return new PlayerRandom(Long.parseLong(cadena));
		}
		
		return new PlayerString(cadena);
	}
	
	/**
	 * Comprueba si cadena es de tipo long
	 *
	 * @param cadena el string
	 * @return true, si es de tipo long
	 */
	private static boolean isLong(String cadena){
		Objects.requireNonNull(cadena, "El parametro cadena no puede ser null");
		try{
			Long.parseLong(cadena);
			return true;
		}
		catch(Exception n){
			return false;
		}
	}
}
