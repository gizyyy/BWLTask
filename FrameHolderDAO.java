package org.bowling.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bowling.constants.FrameConstants;
import org.bowling.data.ConnectionHelper;
import org.bowling.objects.Frame;

/**
 * Frame Data Operations
 * 
 * @author GizemY
 *
 */
public class FrameHolderDAO {

	/**
	 * Returns all shots.
	 * 
	 * @return
	 */
	public List<Frame> findAll() {
		List<Frame> list = new ArrayList<Frame>();
		Connection c = null;
		String sql = FrameConstants.SELECT_FROM_FRAME;

		try {
			c = ConnectionHelper.getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				list.add(processSummaryRowFrame(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return list;
	}
	

	/**
	 * Returns all shots of a certain player
	 * 
	 * @param name
	 * @return
	 */
	public List<Frame> findByName(String name) {
		List<Frame> list = new ArrayList<Frame>();
		Connection c = null;
		String sql = FrameConstants.SELECT_ALL_FRAME_WITH_PLAYER;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(processSummaryRowFrame(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return list;
	}

	/**
	 * Saves shot.
	 * 
	 * @param frame
	 * @return
	 */
	public Frame save(Frame frame) {
		return frame.getId() > 0 ? update(frame) : create(frame);
	}

	/**
	 * Creates a new shot in frame database.
	 * 
	 * @param frame
	 * @return
	 */
	public Frame create(Frame frame) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionHelper.getConnection();
			ps = c.prepareStatement(FrameConstants.INSERT_INTO_FRAME, new String[] { "ID" });
			ps.setInt(1, frame.getMoveId());
			ps.setString(2, frame.getPlayerName());
			ps.setInt(3, frame.getScore());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			// Update the id in the returned object.
			int id = rs.getInt(1);
			frame.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return frame;
	}

	/**
	 * Updates a certain shot.
	 * 
	 * @param frame
	 * @return
	 */
	public Frame update(Frame frame) {
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement(FrameConstants.UPDATE_FRAME);
			ps.setInt(1, frame.getMoveId());
			ps.setString(2, frame.getPlayerName());
			ps.setInt(3, frame.getScore());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return frame;
	}

	/**
	 * Process data.
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	protected Frame processSummaryRowFrame(ResultSet rs) throws SQLException {
		Frame frame = new Frame();
		frame.setId(rs.getInt(FrameConstants.ID));
		frame.setMoveId(rs.getInt(FrameConstants.MOVE_ID));
		frame.setPlayerName(rs.getString(FrameConstants.PLAYER_NAME));
		frame.setScore(rs.getInt(FrameConstants.SCORE));

		return frame;
	}

}
