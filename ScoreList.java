package org.bowling.objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ScoreList {
	// score of first player
	private int scoreOfOne;
	// score of second player
	private int scoreOfTwo;

	public int getScoreOfOne() {
		return scoreOfOne;
	}

	public void setScoreOfOne(int scoreOfOne) {
		this.scoreOfOne = scoreOfOne;
	}

	public int getScoreOfTwo() {
		return scoreOfTwo;
	}

	public void setScoreOfTwo(int scoreOfTwo) {
		this.scoreOfTwo = scoreOfTwo;
	}

}
