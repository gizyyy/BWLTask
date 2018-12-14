package org.bowling.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bowling.constants.GameConstants;
import org.bowling.data.ConnectionHelper;
import org.bowling.objects.Game;

/**
 * Game Data Operations
 * 
 * @author GizemY
 *
 */
public class GameDAO {

	/**
	 * Returns all games.
	 * 
	 * @return
	 */
	public List<Game> findAll() {
		List<Game> list = new ArrayList<Game>();
		Connection c = null;
		String sql = GameConstants.SELECT_FROM_GAME;

		try {
			c = ConnectionHelper.getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				list.add(processRow(rs));
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
	 * Returns game by id.
	 * 
	 * @param id
	 * @return
	 */
	public Game findById(int id) {
		String sql = GameConstants.SELECT_ID_PLAYER_ONE_PLAYER_TWO_FROM_GAME + GameConstants.WHERE_ID;
		Game game = null;
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				game = processRow(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return game;
	}

	/**
	 * Saves game.
	 * 
	 * @param game
	 * @return
	 */
	public Game save(Game game) {
		return game.getId() > 0 ? update(game) : create(game);
	}

	/**
	 * Creates game.
	 * 
	 * @param game
	 * @return
	 */
	public Game create(Game game) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionHelper.getConnection();
			ps = c.prepareStatement(GameConstants.INSERT_INTO_GAME, new String[] { GameConstants.ID2 });
			ps.setString(1, game.getPlayerOne());
			ps.setString(2, game.getPlayerTwo());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			game.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return game;
	}

	/**
	 * Updates game.
	 * 
	 * @param game
	 * @return
	 */
	public Game update(Game game) {
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement(GameConstants.UPDATE_GAME);
			ps.setString(1, game.getPlayerOne());
			ps.setString(2, game.getPlayerTwo());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return game;
	}

	/**
	 * Process game.
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	protected Game processRow(ResultSet rs) throws SQLException {
		Game game = new Game();
		game.setId(rs.getInt(GameConstants.ID));
		game.setPlayerOne(rs.getString(GameConstants.PLAYER_ONE));
		game.setPlayerTwo(rs.getString(GameConstants.PLAYER_TWO));

		return game;
	}

}
