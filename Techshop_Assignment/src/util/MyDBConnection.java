package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyDBConnection {

	static Connection con;
	public static Connection getMyDbConnection() throws ClassNotFoundException {
		String fileName="db.properties";
		Properties properties = new Properties();
		FileInputStream fis =null;
		String connectionString;
		try {
			fis= new FileInputStream(fileName);
			properties.load(fis);
			String driver=properties.getProperty("driver");
			String host = properties.getProperty("host");
	        String port = properties.getProperty("port");
			String dbname = properties.getProperty("dbname");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			connectionString = "jdbc:mysql://" + host + ":" + port + "/" + dbname + "?user=" + username + "&password=" + password;
			
			Class.forName(driver);
		con=DriverManager.getConnection(connectionString);
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return con;
	}

}