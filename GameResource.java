package org.bowling.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bowling.dao.GameDAO;
import org.bowling.objects.Game;

@Path("/games")
public class GameResource {

	GameDAO dao = new GameDAO();

	/**
	 * Returns all games.
	 * 
	 * @return
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Game> findAll() {
		return dao.findAll();
	}

	/**
	 * Returns game by id.
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Game findById(@PathParam("id") String id) {
		return dao.findById(Integer.parseInt(id));
	}

	/**
	 * Starts a new game.
	 * 
	 * @param game
	 * @return
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Game create(Game game) {
		return dao.create(game);
	}

}
