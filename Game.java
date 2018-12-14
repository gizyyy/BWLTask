package org.bowling.objects;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Game class represents a game.
 * 
 * @author GizemY
 *
 */
@XmlRootElement
public class Game {
	// id of a game
	private int id;
	// name of first player
	private String playerOne;
	// name of second player
	private String PlayerTwo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(String playerOne) {
		this.playerOne = playerOne;
	}

	public String getPlayerTwo() {
		return PlayerTwo;
	}

	public void setPlayerTwo(String playerTwo) {
		PlayerTwo = playerTwo;
	}

}
