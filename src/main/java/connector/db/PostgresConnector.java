package connector.db;

public class PostgresConnector extends DBConnector{
	
	
	/** "Class constructor"
	 * @param host - you must enter the host address
	 * @param port - the connection port must be entered
	 * @param dbName - the name of the database must be entered
	 * @param username - you must enter the username of the database
	 * @param password - the database password must be entered
	 */
	public PostgresConnector(String host, String port, String dbName, String username,
			String password) {
		super(host, port, dbName, username, password);
		// TODO Auto-generated constructor stub
		this.connectionString = String.format("jdbc:postgresql://%s:%s/%s", host, port, dbName);
	}
	
}
