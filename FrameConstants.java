package org.bowling.constants;

/**
 * Holding Frame related constants
 * 
 * @author GizemY
 *
 */
public final class FrameConstants {

	public static final String SCORE = "score";
	public static final String PLAYER_NAME = "playerName";
	public static final String MOVE_ID = "moveId";
	public static final String ID = "id";
	public static final String UPDATE_FRAME = "UPDATE frame SET moveId=?, playerName=? score=? WHERE id=?";
	public static final String INSERT_INTO_FRAME = "INSERT INTO frame (moveId, playerName, score) VALUES (?, ?, ?)";
	public static final String SELECT_ALL_FRAME_WITH_PLAYER = "SELECT id, moveId, playerName, score FROM frame "
			+ "WHERE playerName LIKE ? ";
	public static final String SELECT_FROM_FRAME = "SELECT id, moveId, playerName, score FROM frame";

}