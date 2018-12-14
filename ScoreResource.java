package org.bowling.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bowling.dao.FrameHolderDAO;
import org.bowling.dao.GameDAO;
import org.bowling.objects.Frame;
import org.bowling.objects.Game;
import org.bowling.objects.ScoreList;

@Path("/scores")
public class ScoreResource {

	FrameHolderDAO dao = new FrameHolderDAO();
	GameDAO gameDao = new GameDAO();

	/**
	 * Returns scores.
	 * 
	 * @return
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ScoreList findScoreOfPlayers() {
		Game game = gameDao.findById(1);
		String playerOne = game.getPlayerOne();
		String playerTwo = game.getPlayerTwo();
		List<Frame> allShots = dao.findAll();

		ScoreList score = new ScoreList();
		int totalOfOne = 0;
		int totalOfTwo = 0;

		for (Frame frame : allShots) {
			if (frame.getPlayerName().equals(playerOne)) {
				totalOfOne = totalOfOne + frame.getScore();
			} else if (frame.getPlayerName().equals(playerTwo)) {
				totalOfTwo = totalOfTwo + frame.getScore();
			}
		}
		score.setScoreOfOne(totalOfOne);
		score.setScoreOfTwo(totalOfTwo);

		return score;
	}

}
