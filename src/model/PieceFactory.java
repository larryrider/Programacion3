package model;

import java.util.Objects;

/**
 * Clase para crear piezas.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public class PieceFactory {
	
	/**
	 * Crea una nueva pieza.
	 *
	 * @param pieza :La forma de la pieza
	 * @return la pieza creada
	 */
	public static Piece createPiece(String pieza) {
		
		Objects.requireNonNull(pieza, "El parametro pieza no puede ser null");
		
		try {
			@SuppressWarnings("rawtypes")
			Class clase = Class.forName("model."+pieza);
			Object objeto = clase.newInstance();
			if (objeto instanceof Piece) {
				return (Piece) objeto;
			}
		}
		catch (ClassNotFoundException c) {
		}
		catch (InstantiationException e) {
		}
		catch (IllegalAccessException e) {
		}
		
		return null;
		
	}
	
	/**
	 * Constructor por defecto de PieceFactory
	 */
	public PieceFactory() {
	}
}
