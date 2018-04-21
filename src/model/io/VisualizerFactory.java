package model.io;

import java.util.Objects;

import model.exceptions.io.TetrisIOException;

/**
 * La clase Visualizer Factory.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public class VisualizerFactory {
	
	/**
	 * Constructor vacio.
	 */
	public VisualizerFactory() {
	}
	
	/**
	 * Crea un visualizador en base a una cadena.
	 *
	 * @param cadena la cadena
	 * @return el visualizador
	 * @throws TetrisIOException Tetris IO Exception
	 */
	public static IVisualizer createVisualizer(String cadena) throws TetrisIOException {
		Objects.requireNonNull(cadena, "El parametro cadena no puede ser null");
		if (cadena.contentEquals("console")) {
			return new VisualizerConsole();
		}
//		if (cadena.contentEquals("window")) {
//			return new VisualizerWindow();
//		}
		throw new TetrisIOException("No se ha podido crear el visualizador: "+cadena);
	}
}
