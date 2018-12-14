package org.bowling.objects;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Frame class represents a single shot.
 * 
 * @author GizemY
 *
 */
@XmlRootElement
public class Frame {
	// game id
	private int id;
	// shot number of the player
	private int moveId;
	// name of player
	private String playerName;
	// score of this shot
	private int score;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMoveId() {
		return moveId;
	}

	public void setMoveId(int moveId) {
		this.moveId = moveId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
