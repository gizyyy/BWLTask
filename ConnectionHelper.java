package org.bowling.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * The class aims to supply a database connection. Database:MySQL DatabaseName:
 * directory Tables: game, frame
 * 
 * @author gizemY
 *
 */
public class ConnectionHelper {
	private static final String JDBC_URL = "jdbc.url";
	private static final String JDBC_DRIVER = "jdbc.driver";
	private static final String DATABASE_NAME = "directory";
	private static final String JDBC_MYSQL_LOCALHOST_DIRECTORY_USER_ROOT = "jdbc:mysql://localhost/directory?user=root";
	private static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private String url;
	private static ConnectionHelper instance;

	/**
	 * Creates the connection
	 */
	private ConnectionHelper() {
		String driver = null;
		try {
			Class.forName(COM_MYSQL_JDBC_DRIVER);
			url = JDBC_MYSQL_LOCALHOST_DIRECTORY_USER_ROOT;
			ResourceBundle bundle = ResourceBundle.getBundle(DATABASE_NAME);
			driver = bundle.getString(JDBC_DRIVER);
			Class.forName(driver);
			url = bundle.getString(JDBC_URL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the connection
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			instance = new ConnectionHelper();
		}
		try {
			return DriverManager.getConnection(instance.url);
		} catch (SQLException e) {
			throw e;
		}
	}

	/**
	 * Closes the connection
	 * 
	 * @param connection
	 */
	public static void close(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}