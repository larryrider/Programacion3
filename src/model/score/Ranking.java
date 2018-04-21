package model.score;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

import model.exceptions.score.RankingException;

/**
 * La clase ranking.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 * 
 * @param <ScoreType> Tipo generico score
 */
public class Ranking<ScoreType extends Score> {
	
	 /** Atributo gameplay. */
 	private SortedSet<ScoreType> gamePlays;
	
	
	/**
	 * Constructor de ranking.
	 */
	public Ranking() {
		 gamePlays = new TreeSet<ScoreType>();
	}
	
	/**
	 * Anyade la puntuacion
	 *
	 * @param scoretype puntuacion a anyadir
	 */
	public void addScore(ScoreType scoretype) {
		Objects.requireNonNull(scoretype, "El parametro scoretype no puede ser null");
		
		gamePlays.add(scoretype);
	}
	
	/**
	 * Getter del ganador del ranking.
	 *
	 * @return el ganador
	 * @throws RankingException Excepcion de ranking vacio
	 */
	public ScoreType getWinner() throws RankingException {
		if (gamePlays.isEmpty()) {
			throw new RankingException();
		}
		else {
			return gamePlays.first();
		}
		
	}
	
	/**
	 * Getter del ranking ordenado.
	 *
	 * @return el ranking
	 */
	public SortedSet<ScoreType> getSortedRanking() {
		return gamePlays;
	}
	
	
}
