package model.score;

import java.util.Objects;

import model.io.GamePlay;

/**
 * Clase Score.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public abstract class Score implements Comparable<Score> {
	
	/** Atributo gameplay. */
	protected GamePlay gameplay;
	
	/** Nombre del jugador. */
	private String name;
	
	/** Atributo score. */
	private int score;
	
	/**
	 * Constructor de Score
	 *
	 * @param sname Nombre
	 * @param gplay GamePlay
	 */
	public Score(String sname, GamePlay gplay) {
		Objects.requireNonNull(sname, "El parametro pieza no puede ser null");
		Objects.requireNonNull(gplay, "El parametro pieza no puede ser null");
		name=sname;
		gameplay=gplay;
		score=getScoring();
	}
	
	@Override
	public int compareTo(Score o) {
		Objects.requireNonNull(o, "El parametro pieza no puede ser null");
		
		if (score>o.getScoring()) {
			return -1;
		}
		if (score<o.getScoring()) {
			return 1;
		}

		return name.compareTo(o.name);
	}
	
	@Override
	public String toString() {
		return name+":"+score;
	}
	
	/**
	 * Getter del nombre.
	 *
	 * @return el nombre
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Putuacion
	 *
	 */
	public abstract int getScoring();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		if (score != other.score)
			return false;
		return true;
	}

	
}
