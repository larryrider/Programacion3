package model;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

import model.exceptions.WrongSizeException;

/**
 * 
 * Clase Gameboard, se encarga de crear un tablero, el cual consta de un mapa
 * con una pieza y unas coordenadas asociadas.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 *
 */
public class Gameboard {
	
	/**
	 * La altura del tablero.
	 *
	 */
	private int height;
	
	/**
	 * La altura minima del tablero.
	 * 
	 */
	private static int MINIMUM_BOARD_HEIGHT = 4;
	
	/**
	 * La anchura minima del tablero.
	 * 
	 */
	private static int MINIMUM_BOARD_WIDTH = 4;
	
	/**
	 * La anchura del tablero.
	 *
	 */
	private int width;
	
	/**
	 * El tablero.
	 *
	 */
	private HashMap<Coordinate, Piece> gameboard;
	
	/**
	 * Constructor que recibe una coordenada, y crea un tablero con el tamanyo
	 * (altura,anchura).
	 *
	 * @param c :Tamanyo del tablero
	 * @throws WrongSizeException the wrong size exception
	 */
	public Gameboard(Coordinate c) throws WrongSizeException {
		Objects.requireNonNull(c, "El parametro c no puede ser null");
		if (c.getRow() >= MINIMUM_BOARD_HEIGHT
				&& c.getColumn() >= MINIMUM_BOARD_WIDTH) {
			gameboard = new HashMap<Coordinate, Piece>();
			height = c.getRow();
			width = c.getColumn();
		}
		else {
			throw new WrongSizeException(c);
		}
	}
	
	/**
	 * Metodo que se encarga de anyadir una pieza en el mapa.
	 *
	 * @param c :Coordenada que recibe (esquina superior izquierda de la pieza)
	 * @param p :Pieza que recibe, y que tiene que añadir
	 */
	public void putPiece(Coordinate c, Piece p) {
		Objects.requireNonNull(c, "el parametro c no puede ser null");
		Objects.requireNonNull(p, "el parametro p no puede ser null");
		Set<Coordinate> setPieza = p.getAbsoluteCells(c);
		
		for (Coordinate coordenada : setPieza) {
			gameboard.put(coordenada, p);
		}
	}
	
	/**
	 * Getter de la anchura.
	 *
	 * @return width :Anchura del tablero
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Getter de la altura.
	 *
	 * @return height :Altura del tablero
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Metodo que comprueba que la pieza que recibe (con su coordenada superior
	 * izquierda), pueda meterse en el tablero, que este dentro de los limites.
	 *
	 * @param c :Coordenada superior izquierda
	 * @param p :Pieza a comprobar
	 * @return correcto :Devuelve si el sitio es valido o no
	 */
	public boolean isPlaceValid(Coordinate c, Piece p) {
		Objects.requireNonNull(c, "el parametro c no puede ser null");
		Objects.requireNonNull(p, "el parametro p no puede ser null");
		
		Set<Coordinate> setPieza = p.getAbsoluteCells(c);
		
		for (Coordinate coord : setPieza) {
			if (coord.getRow() < 0 || coord.getColumn() < 0
					|| coord.getRow() >= height || coord.getColumn() >= width) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Metodo que comprueba que la pieza que recibe (con su coordenada superior
	 * izquierda), pueda anyadirse al tablero, comprobando no haya ya otra pieza
	 * en el mismo lugar.
	 *
	 * @param c :Coordenada superior izquierda
	 * @param p :Pieza a comprobar
	 * @return correcto :Devuelve si el sitio esta libre para colocar la pieza
	 */
	public boolean isPlaceFree(Coordinate c, Piece p) {
		Objects.requireNonNull(c, "el parametro c no puede ser null");
		Objects.requireNonNull(p, "el parametro p no puede ser null");
		
		boolean correcto = true;
		
		Set<Coordinate> setPieza = p.getAbsoluteCells(c);
		
		for (Coordinate coord : setPieza) {
			Piece comprobarPieza = gameboard.get(coord);
			if (comprobarPieza != null && comprobarPieza.isFixed()) {
				correcto = false;
			}
		}
		
		return correcto;
	}
	
	/**
	 * Metodo que se encarga de eliminar una pieza del tablero.
	 *
	 * @param eliminar :Pieza a eliminar
	 */
	public void removePiece(Piece eliminar) {
		Objects.requireNonNull(eliminar,
				"el parametro eliminar no puede ser null");
		
		Piece p;
		Coordinate c;
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				c = new Coordinate(i, j);
				p = gameboard.get(c);
				if (p == eliminar) {
					gameboard.remove(c);
				}
			}
		}
	}
	
	/**
	 * Metodo que devuelve el contenido de la coordenada del tablero.
	 *
	 * @param c :Coordenada del tablero
	 * @return gameboard.get(c) :Contenido del tablero
	 */
	public Piece getCellContent(Coordinate c) {
		Objects.requireNonNull(c, "el parametro c no puede ser null");
		return gameboard.get(c);
	}
	
	/**
	 * Metodo que se encarga de anyadir la referencia de la pieza al tablero en
	 * la posicion indicada por la coordenada.
	 *
	 * @param c :Coordenada que se le pasa
	 * @param p :Pieza a anyadir al tablero
	 */
	public void setCellContent(Coordinate c, Piece p) {
		Objects.requireNonNull(c, "el parametro c no puede ser null");
		gameboard.put(c, p);
	}
	
	/**
	 * Metodo que se encarga de guardar en una string el tablero y sus piezas.
	 *
	 * @return cadena :String que devuelve
	 */
	public String toString() {
		String cadena = new String("");
		Coordinate c;
		Piece p;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				c = new Coordinate(i, j);
				p = gameboard.get(c);
				if (p == null) {
					cadena += '\u00B7';
				}
				else {
					cadena += p.getBlockSymbol();
				}
			}
			cadena += "\n";
		}
		return cadena;
	}
	
	/**
	 * Devuelve si la fila pasada por parametro esta llena.
	 *
	 * @param row :La fila a comprobar
	 * @return true si esta llena la fila
	 */
	private boolean isRowFull(int row) {
		Objects.requireNonNull(row, "el parametro row no puede ser null");
		if (row < 0 || row >= height) {
			throw new IllegalArgumentException();
		}
		else {
			Coordinate c;
			Piece p;
			for (int j = 0; j < width; j++) {
				c = new Coordinate(row, j);
				p = gameboard.get(c);
				if (p == null) {
					return false;
				}
				else if (!p.isFixed()) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Devuelve la primera fila llena comprobando desde la ultima.
	 *
	 * @return la posicion de la fila
	 */
	public int firstRowFullFromBottom() {
		
		for (int i = height - 1; i >= 0; i--) {
			if (isRowFull(i)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Limpia la fila pasada por parametro.
	 *
	 * @param row :Fila a limpiar
	 */
	public void clearRow(int row) {
		Objects.requireNonNull(row, "el parametro row no puede ser null");
		
		if (row < 0 || row >= height) {
			throw new IllegalArgumentException();
		}
		else {
			for (int j = 0; j < width; j++) {
				Coordinate c = new Coordinate(row, j);
				gameboard.remove(c);
			}
		}
	}
	
	/**
	 * Baja una fila todas las piezas.
	 *
	 * @param row :La primera fila a partir de la cual hay que bajar las piezas
	 */
	public void makeUpperRowsFall(int row) {
		Objects.requireNonNull(row, "el parametro row no puede ser null");
		if (row < 0 || row >= height) {
			throw new IllegalArgumentException();
		}
		else {
			for (int i = row - 1; i >= 0; i--) {
				for (int j = 0; j < width; j++) {
					Coordinate c = new Coordinate(i, j);
					Piece p = gameboard.get(c);
					if (p != null) {
						gameboard.remove(c);
						Coordinate coord = new Coordinate(c.getRow() + 1,
								c.getColumn());
						gameboard.put(coord, p);
					}
					
				}
			}
		}
	}
	
}
