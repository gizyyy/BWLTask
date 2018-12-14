package org.bowling.constants;

/**
 * Holding Game related Constants
 * 
 * @author GizemY
 *
 */
public final class GameConstants {

	public static final String PLAYER_TWO = "playerTwo";
	public static final String PLAYER_ONE = "playerOne";
	public static final String ID = "id";
	public static final String UPDATE_GAME = "UPDATE game SET playerOne=?, playerTwo=? WHERE id=?";
	public static final String ID2 = "ID";
	public static final String INSERT_INTO_GAME = "INSERT INTO game (playerOne, PlayerTwo) VALUES (?, ?)";
	public static final String WHERE_ID = "WHERE id = ? ";
	public static final String SELECT_ID_PLAYER_ONE_PLAYER_TWO_FROM_GAME = "SELECT id, playerOne, playerTwo FROM game ";
	public static final String SELECT_FROM_GAME = "SELECT id, playerOne, playerTwo FROM game";

}