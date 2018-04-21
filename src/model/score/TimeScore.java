package model.score;

import java.util.Objects;

import model.io.GamePlay;

/**
 * Clase TimeScore.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 */
public class TimeScore extends Score {
	
	/**
	 * Constructor de TimeScore.
	 *
	 * @param name Nombre del jugador
	 * @param gameplay Gameplay
	 */
	public TimeScore(String name, GamePlay gameplay) {
		super(name, gameplay);
		
		Objects.requireNonNull(name, "El parametro name no puede ser null");
		Objects.requireNonNull(gameplay, "El parametro gameplay no puede ser null");
	}
	

	@Override
	public int getScoring() {
		return -gameplay.getDuration();
	}
	
}
