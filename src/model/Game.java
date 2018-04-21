package model;

import java.util.Objects;

import model.exceptions.CollisionMovementException;
import model.exceptions.CurrentPieceNotFixedException;
import model.exceptions.FixedPieceMovementException;
import model.exceptions.GameEndedMovementException;
import model.exceptions.NoCurrentPieceException;
import model.exceptions.OffBoardMovementException;
import model.exceptions.WrongSizeException;

/**
 * Clase Game, se encarga de crear un juego, el cual consta de un tablero con
 * pieza y una posicion asociadas.
 * 
 * @author Lawrence Arthur Rider Garcia DNI: ********-
 *
 */
public class Game {
	
	/**
	 * Booleano que guarda si se ha acabado el juego.
	 * 
	 */
	private boolean gameEnded;
	
	/**
	 * El tablero (gameboard).
	 * 
	 */
	private Gameboard board;
	
	/**
	 * La posicion actual.
	 * 
	 */
	private Coordinate currentPosition;
	
	/**
	 * La pieza actual.
	 *
	 */
	private Piece currentPiece;
	
	/**
	 * Constructor, recibe una coordenada (Tamanyo del tablero), y crea un
	 * gameboard.
	 * 
	 * @param c :Coordenada que recibe
	 * @throws WrongSizeException the wrong size exception
	 */
	public Game(Coordinate c) throws WrongSizeException {
		Objects.requireNonNull(c, "El parametro c no puede ser null");
		
		board = new Gameboard(c);
		gameEnded = false;
	}
	
	/**
	 * Procedimiento que se encarga de mover la pieza a la izquierda
	 * (comprobando antes si se puede mover o no).
	 *
	 * @throws NoCurrentPieceException the no current piece exception
	 * @throws GameEndedMovementException the game ended movement exception
	 * @throws FixedPieceMovementException the fixed piece movement exception
	 * @throws OffBoardMovementException the off board movement exception
	 * @throws CollisionMovementException the collision movement exception
	 */
	public void moveCurrentPieceLeft() throws NoCurrentPieceException,
			GameEndedMovementException, FixedPieceMovementException,
			OffBoardMovementException, CollisionMovementException {
		
		if (currentPiece == null || currentPosition == null) {
			throw new NoCurrentPieceException();
		}
		else {
			if (!isGameEnded() && !isCurrentPieceFixed()) {
				Coordinate probarIzquierda = new Coordinate(
						currentPosition.getRow(),
						currentPosition.getColumn() - 1);
				if (board.isPlaceValid(probarIzquierda, currentPiece)
						&& board.isPlaceFree(probarIzquierda, currentPiece)) {
					currentPosition = probarIzquierda;
					board.removePiece(currentPiece);
					board.putPiece(currentPosition, currentPiece);
				}
				else if (!board.isPlaceValid(probarIzquierda, currentPiece)) {
					throw new OffBoardMovementException(currentPosition);
				}
				else if (!board.isPlaceFree(probarIzquierda, currentPiece)) {
					throw new CollisionMovementException(currentPosition);
				}
			}
			else if (isGameEnded()) {
				throw new GameEndedMovementException();
			}
			else if (isCurrentPieceFixed()) {
				throw new FixedPieceMovementException();
			}
		}
	}
	
	/**
	 * Procedimiento que se encarga de mover la pieza a la derecha (comprobando
	 * antes si se puede mover o no).
	 *
	 * @throws NoCurrentPieceException the no current piece exception
	 * @throws GameEndedMovementException the game ended movement exception
	 * @throws FixedPieceMovementException the fixed piece movement exception
	 * @throws OffBoardMovementException the off board movement exception
	 * @throws CollisionMovementException the collision movement exception
	 */
	public void moveCurrentPieceRight() throws NoCurrentPieceException,
			GameEndedMovementException, FixedPieceMovementException,
			OffBoardMovementException, CollisionMovementException {
		
		if (currentPiece == null || currentPosition == null) {
			throw new NoCurrentPieceException();
		}
		else {
			if (!isGameEnded() && !isCurrentPieceFixed()) {
				Coordinate probarDerecha = new Coordinate(
						currentPosition.getRow(),
						currentPosition.getColumn() + 1);
				if (board.isPlaceValid(probarDerecha, currentPiece)
						&& board.isPlaceFree(probarDerecha, currentPiece)) {
					currentPosition = probarDerecha;
					board.removePiece(currentPiece);
					board.putPiece(currentPosition, currentPiece);
				}
				else if (!board.isPlaceValid(probarDerecha, currentPiece)) {
					throw new OffBoardMovementException(currentPosition);
				}
				else if (!board.isPlaceFree(probarDerecha, currentPiece)) {
					throw new CollisionMovementException(currentPosition);
				}
			}
			else if (isGameEnded()) {
				throw new GameEndedMovementException();
			}
			else if (isCurrentPieceFixed()) {
				throw new FixedPieceMovementException();
			}
		}
	}
	
	/**
	 * Procedimiento que se encarga de mover la pieza hacia abajo (comprobando
	 * antes si se puede mover o no), y ademas, la fijara la segunda vez que se
	 * llame estando en la ultima fila.
	 *
	 * @throws NoCurrentPieceException the no current piece exception
	 * @throws GameEndedMovementException the game ended movement exception
	 * @throws FixedPieceMovementException the fixed piece movement exception
	 * @return contador de filas borradas
	 */
	public int moveCurrentPieceDown() throws NoCurrentPieceException,
			GameEndedMovementException, FixedPieceMovementException {
		int filasborradas=0;
		if (currentPiece == null || currentPosition == null) {
			throw new NoCurrentPieceException();
		}
		else {
			if (!isGameEnded() && !isCurrentPieceFixed()) {
				Coordinate probarAbajo = new Coordinate(
						currentPosition.getRow() + 1,
						currentPosition.getColumn());
				if (board.isPlaceValid(probarAbajo, currentPiece)
						&& board.isPlaceFree(probarAbajo, currentPiece)) {
					currentPosition = probarAbajo;
					board.removePiece(currentPiece);
					board.putPiece(currentPosition, currentPiece);
				}
				else {
					currentPiece.setFixed(true);
					int primerraFilaLLena;
					do {
						primerraFilaLLena = board.firstRowFullFromBottom();
						if (primerraFilaLLena >= 0) {
							board.clearRow(primerraFilaLLena);
							board.makeUpperRowsFall(primerraFilaLLena);
							filasborradas++;
						}
					} while (primerraFilaLLena >= 0);
				}
			}
			else if (isGameEnded()) {
				throw new GameEndedMovementException();
			}
			else if (isCurrentPieceFixed()) {
				throw new FixedPieceMovementException();
			}
		}
		return filasborradas;
	}
	
	/**
	 * Procedimiento que se encarga de rotar la pieza en sentido contrario a las
	 * agujas del reloj (comprobando antes si se puede rotar o no).
	 *
	 * @throws NoCurrentPieceException the no current piece exception
	 * @throws GameEndedMovementException the game ended movement exception
	 * @throws FixedPieceMovementException the fixed piece movement exception
	 * @throws OffBoardMovementException the off board movement exception
	 * @throws CollisionMovementException the collision movement exception
	 */
	public void rotateCurrentPieceCounterclockwise()
			throws NoCurrentPieceException, GameEndedMovementException,
			FixedPieceMovementException, OffBoardMovementException,
			CollisionMovementException {
		if (currentPiece == null || currentPosition == null) {
			throw new NoCurrentPieceException();
		}
		else {
			if (!isGameEnded() && !isCurrentPieceFixed()) {
				currentPiece.rotateCounterclockwise();
				if (board.isPlaceValid(currentPosition, currentPiece)
						&& board.isPlaceFree(currentPosition, currentPiece)) {
					board.removePiece(currentPiece);
					board.putPiece(currentPosition, currentPiece);
				}
				else if (!board.isPlaceValid(currentPosition, currentPiece)) {
					currentPiece.rotateClockwise();
					throw new OffBoardMovementException(currentPosition);
				}
				else if (!board.isPlaceFree(currentPosition, currentPiece)) {
					currentPiece.rotateClockwise();
					throw new CollisionMovementException(currentPosition);
				}
			}
			else if (isGameEnded()) {
				throw new GameEndedMovementException();
			}
			else if (isCurrentPieceFixed()) {
				throw new FixedPieceMovementException();
			}
		}
	}
	
	/**
	 * Procedimiento que se encarga de rotar la pieza en sentido de las agujas
	 * del reloj (comprobando antes si se puede rotar o no).
	 *
	 * @throws NoCurrentPieceException the no current piece exception
	 * @throws GameEndedMovementException the game ended movement exception
	 * @throws FixedPieceMovementException the fixed piece movement exception
	 * @throws OffBoardMovementException the off board movement exception
	 * @throws CollisionMovementException the collision movement exception
	 */
	public void rotateCurrentPieceClockwise() throws NoCurrentPieceException,
			GameEndedMovementException, FixedPieceMovementException,
			OffBoardMovementException, CollisionMovementException {
		if (currentPiece == null || currentPosition == null) {
			throw new NoCurrentPieceException();
		}
		else {
			if (!isGameEnded() && !isCurrentPieceFixed()) {
				currentPiece.rotateClockwise();
				if (board.isPlaceValid(currentPosition, currentPiece)
						&& board.isPlaceFree(currentPosition, currentPiece)) {
					board.removePiece(currentPiece);
					board.putPiece(currentPosition, currentPiece);
				}
				else if (!board.isPlaceValid(currentPosition, currentPiece)) {
					currentPiece.rotateCounterclockwise();
					throw new OffBoardMovementException(currentPosition);
				}
				else if (!board.isPlaceFree(currentPosition, currentPiece)) {
					currentPiece.rotateCounterclockwise();
					throw new CollisionMovementException(currentPosition);
				}
			}
			else if (isGameEnded()) {
				throw new GameEndedMovementException();
			}
			else if (isCurrentPieceFixed()) {
				throw new FixedPieceMovementException();
			}
		}
	}
	
	/**
	 * Esta funcion se encarga de crear una nueva pieza y posicionarla en la
	 * parte superior del tablero, siempre que se pueda posicionar, en caso
	 * contrario termina la partida.
	 *
	 * @param type :Tipo de pieza
	 * @return correcto :Devuelve si se ha anyadido una pieza en el tablero
	 * @throws GameEndedMovementException the game ended movement exception
	 * @throws CurrentPieceNotFixedException the current piece not fixed
	 *         exception
	 */
	public boolean nextPiece(String type) throws GameEndedMovementException,
			CurrentPieceNotFixedException {
		Objects.requireNonNull(type, "El parametro type no puede ser null");
		boolean correcto = false;
		if (gameEnded) {
			throw new GameEndedMovementException();
		}
		else {
			if (currentPiece != null && !currentPiece.isFixed()) {
				throw new CurrentPieceNotFixedException();
			}
			else {
				currentPiece = PieceFactory.createPiece(type);
				
				currentPosition = new Coordinate(0, board.getWidth() / 2 - 2);
				if (board.isPlaceValid(currentPosition, currentPiece)
						&& board.isPlaceFree(currentPosition, currentPiece)) {
					board.putPiece(currentPosition, currentPiece);
					correcto = true;
				}
				else {
					gameEnded = true;
					correcto = false;
				}
			}
		}
		
		return correcto;
	}
	
	/**
	 * Funcion que se encarga de devolver el tablero en una string.
	 *
	 * @return board.toString() :Tablero en formato String
	 */
	public String toString() {
		return board.toString();
	}
	
	/**
	 * Funcion que devuelve si la pieza esta fija o no.
	 *
	 * @return currentPiece.isFixed() :Boolean con la fijacion de la pieza
	 * @throws NoCurrentPieceException the no current piece exception
	 */
	public boolean isCurrentPieceFixed() throws NoCurrentPieceException {
		
		if (currentPiece == null || currentPosition == null) {
			throw new NoCurrentPieceException();
		}
		
		return currentPiece.isFixed();
	}
	
	/**
	 * Funcion que devuelve si el juego esta acabado o no.
	 *
	 * @return gameEnded :Boolean que contiene si el juego esta finalizado o no
	 */
	public boolean isGameEnded() {
		return gameEnded;
	}
	
	/**
	 * Getter del gameboard.
	 *
	 * @return board :el tablero
	 */
	public Gameboard getGameboard() {
		return board;
	}
	
}
