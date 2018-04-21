package model;

import java.util.Objects;

/**
 * Clase Coordinate: se encarga de construir y almacenar coordenadas.
 *
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */

public class Coordinate {
	
	/**
	 * Contador de coordenadas creadas.
	 *
	 */
	private static int COORDINATE_COUNT = 0;
	
	/**
	 * La fila.
	 *
	 */
	private int row;
	
	/**
	 * La columna.
	 *
	 */
	private int column;
	
	/**
	 * Constructor: Recibe dos parametros enteros, una fila y una columna, y
	 * construye una coordenada en base a estas.
	 *
	 * @param row :Es la fila que recibe
	 * @param column :Es la columna que recibe
	 */
	public Coordinate(int row, int column) {
		Objects.requireNonNull(row, "el parametro row no puede ser null");
		Objects.requireNonNull(column, "el parametro column no puede ser null");
		this.row = row;
		this.column = column;
		COORDINATE_COUNT++;
	}
	
	/**
	 * Constructor: Recibe un objeto coordenada, y contruye uno nuevo en base a
	 * este.
	 *
	 * @param c :Es el objeto coordenada que recibe
	 */
	public Coordinate(final Coordinate c) {
		Objects.requireNonNull(c, "el parametro c no puede ser null");
		row = c.row;
		column = c.column;
		COORDINATE_COUNT++;
	}
	
	/**
	 * Getter: se encarga de devolver la fila.
	 *
	 * @return row :Devuelve el valor de fila
	 */
	public final int getRow() {
		
		return row;
	}
	
	/**
	 * Getter: se encarga de devolver la columna.
	 *
	 * @return column :Devuelve el valor de la columna
	 */
	public final int getColumn() {
		
		return column;
	}
	
	/**
	 * Getter: se encarga de devolver el COORDINATE_COUNT.
	 *
	 * @return COORDINATE_COUNT :Devuelve el valor de coordinate_count
	 */
	public static int getCoordinateCount() {
		
		return COORDINATE_COUNT;
	}
	
	/**
	 * Metodo que devuelve en una string los valores de la coordenada.
	 *
	 * @return concatenation :String con los valores raw y column
	 */
	public final String toString() {
		
		String concatenation = "";
		concatenation = "[" + row + "," + column + "]";
		return concatenation;
	}
	
	/**
	 * Metodo que recibe un objeto coordenada, lo suma con el objeto coordenada
	 * en el que estamos, y devuelve el resultado en un coordinate.
	 *
	 * @param c :Objeto coordenada que recibe
	 * @return coord :Objeto coordenada que devuelve
	 */
	public Coordinate add(final Coordinate c) {
		Objects.requireNonNull(c, "el parametro c no puede ser null");
		Coordinate coord = new Coordinate(0, 0);
		
		coord.row = row + c.row;
		coord.column = column + c.column;
		return coord;
	}
	
	/**
	 * Implementacion del hasCode.
	 *
	 * @return result :Resultado del hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}
	
	/**
	 * Este metodo se encarga de comparar dos objetos coordenadas, devuelve true
	 * o false dependiendo de si son equivalentes o no.
	 * 
	 * @param obj :Objeto coordinate que recibe
	 * @return true :Por defecto devuelve true
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
}
