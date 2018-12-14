package org.bowling.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bowling.dao.FrameHolderDAO;
import org.bowling.objects.Frame;

@Path("/shots")
public class FrameResource {

	FrameHolderDAO dao = new FrameHolderDAO();

	/**
	 * Gets all shots.
	 * 
	 * @return
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Frame> findAll() {
		return dao.findAll();
	}

	/**
	 * Gets all shots of a certain player.
	 * 
	 * @return
	 */
	@GET
	@Path("{playerName}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Frame> findById(@PathParam("playerName") String name) {
		return dao.findByName(name);
	}

	/**
	 * Makes a shot.
	 * 
	 * @param frame
	 * @return
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Frame create(Frame frame) {
		return dao.create(frame);
	}

}
