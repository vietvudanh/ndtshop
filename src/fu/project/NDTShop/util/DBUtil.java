package fu.project.NDTShop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fu.project.NDTShop.config.DB;

public class DBUtil {

	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				Class.forName(DB.DRIVER);
				connection = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}

	}
}
