package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Clase Piece: Se encarga de construir piezas.
 *
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public abstract class Piece {
	
	/**
	 * Fijacion de la pieza.
	 *
	 */
	private boolean fixed;
	
	/**
	 * Simbolo de la pieza.
	 *
	 */
	protected char blockSymbol;
	
	/**
	 * Orientacion de la pieza.
	 *
	 */
	private Rotation orientation;
	
	/**
	 * Tamaño de la pieza.
	 *
	 */
	private static int BOUNDING_SQUARE_SIZE = 4;
	
	/**
	 * Constructor por defecto de pieza.
	 * 
	 */
	public Piece() {
		orientation = Rotation.D0;
		fixed = false;
	}
	
	/**
	 * Una especie de getter que devuelve el atributo fix.
	 *
	 * @return fixed :Devuelve si la pieza esta fija o no
	 */
	public boolean isFixed() {
		return fixed;
	}
	
	/**
	 * Rota la pieza en sentido antihorario.
	 * 
	 */
	public void rotateCounterclockwise() {
		
		switch (orientation) {
			case D0:
				orientation = Rotation.D90;
				break;
			case D90:
				orientation = Rotation.D180;
				break;
			case D180:
				orientation = Rotation.D270;
				break;
			case D270:
				orientation = Rotation.D0;
				break;
		}
	}
	
	/**
	 * Rota la pieza en sentido horario.
	 * 
	 */
	public void rotateClockwise() {
		switch (orientation) {
			case D0:
				orientation = Rotation.D270;
				break;
			case D90:
				orientation = Rotation.D0;
				break;
			case D180:
				orientation = Rotation.D90;
				break;
			case D270:
				orientation = Rotation.D180;
				break;
		}
	}
	
	/**
	 * Getter que devuelve la orientacion de la pieza.
	 *
	 * @return orientation :Devuelve la orientacion
	 */
	public Rotation getOrientation() {
		return orientation;
	}
	
	/**
	 * Getter que devuelve el simbolo de la pieza.
	 *
	 * @return blockSymbol :Devuelve el simbolo
	 */
	public char getBlockSymbol() {
		return blockSymbol;
	}
	
	/**
	 * Setter que cambia la orientacion de la pieza.
	 *
	 * @param rotation :Orientacion a asignar
	 */
	public void setOrientation(Rotation rotation) {
		Objects.requireNonNull(rotation,
				"el parametro rotation no puede ser null");
		orientation = rotation;
	}
	
	/**
	 * Devuelve un conjunto (Set) que contiene todas las coordenadas del tablero
	 * que seran ocupadas por la pieza si se posiciona con la esquina superior
	 * izquierda de su cuadrado delimitador en la posicion del tablero indicada
	 * por el parametro.
	 *
	 * @param coordenada :Coordenada en la que se va a posicionar
	 * @return squares :Conjunto que devuelve
	 */
	public Set<Coordinate> getAbsoluteCells(Coordinate coordenada) {
		Objects.requireNonNull(coordenada,
				"el parametro coordenada no puede ser null");
		Set<Coordinate> squares = new HashSet<Coordinate>();
		
		for (int i = 0; i < getShape()[orientation.ordinal()].length; i++) {
			if (getShape()[orientation.ordinal()][i] == 1) {
				Coordinate nuevo = new Coordinate(i / BOUNDING_SQUARE_SIZE, i
						% BOUNDING_SQUARE_SIZE);
				
				squares.add(nuevo.add(coordenada));
			}
		}
		return squares;
	}
	
	/**
	 * Devuelve una cadena que contiene una representacion del cuadrado
	 * delimitador de una pieza de acuerdo a su orientacion actual.
	 *
	 * @return cadena :Cadena que devuelve
	 */
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		
		for (int i = 0; i < getShape()[orientation.ordinal()].length; i++) {
			if (i % BOUNDING_SQUARE_SIZE == 0 && i != 0) {
				cadena.append("\n");
			}
			switch (getShape()[orientation.ordinal()][i]) {
				case 0:
					cadena.append('\u00B7');
					break;
				case 1:
					cadena.append(getBlockSymbol());
					break;
			}
		}
		cadena.append("\n");
		return cadena.toString();
	}
	
	/**
	 * Setter del atributo fixed, cambia la fijacion de una pieza.
	 *
	 * @param fixed :Parametro que se le pasa
	 */
	public void setFixed(boolean fixed) {
		Objects.requireNonNull(fixed, "el parametro fixed no puede ser null");
		this.fixed = fixed;
	}
	
	/**
	 * Getter de la forma de la pieza.
	 *
	 * @return el atributo shape
	 */
	protected abstract int[][] getShape();
	
	/**
	 * Copia una pieza.
	 *
	 * @return la pieza
	 */
	public abstract Piece copy();
	
	/**
	 * Copia los atributos de una pieza.
	 *
	 * @param piece :Pieza a copiar
	 */
	protected void copyAttributes(Piece piece) {
		Objects.requireNonNull(piece, "el parametro piece no puede ser null");
		this.fixed = piece.fixed;
		this.blockSymbol = piece.blockSymbol;
		this.orientation = piece.orientation;
	}
	
}
