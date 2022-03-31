package connector.db;

import  java.sql.Statement;


import  java.sql.ResultSet;
import 	java.sql.Connection;
import  java.sql.DriverManager;		
import  java.sql.SQLException;

public abstract class DBConnector {
	
	protected Connection connection = null;
	protected String connectionString; 
	protected String host;
	protected String port;
	protected String dbName;
	protected String username;
	protected String password;
	 
	
	/**
	 * @param host
	 * @param port
	 * @param dbName
	 * @param username
	 * @param password
	 */
	public DBConnector(String host, String port, String dbName, String username, String password) {
		this.host = host;
		this.port = port;
		this.dbName = dbName;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * @return Connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Connection connectDB() throws SQLException {		
		this.closeConnection();
		try {
			connection = DriverManager.getConnection(connectionString, username, password);
			return connection;
		} catch (SQLException e) {
			throw new SQLException("Error SQL al intentar conectar: " + e.getMessage());
		}
	}
	
	/**
	 * @param query
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String query) throws SQLException {
		this.closeConnection();
		try {
			Statement statement = connection.createStatement();
			return statement.executeQuery(query);
		} catch (SQLException e) {
			throw new SQLException("SQL error: Error execution query: " + e.getMessage());
		}
	}
	
	/**
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException {
		if(connection != null && !connection.isClosed()){
			connection.close();
		}
	}
}