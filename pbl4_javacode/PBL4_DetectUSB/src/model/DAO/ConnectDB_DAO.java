package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB_DAO {

	public static Connection connectMySQL() {
		Connection connection = null;
		if(connection == null) {
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pbl4", "root", "sonk51ca1");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

}
