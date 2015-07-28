package fu.project.NDTShop.config;

public class DB {
	
	// Change these for other DB system
	// public static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	// if use SQL server, pls check this: http://stackoverflow.com/questions/1310536/how-to-make-java-work-with-sql-server
	// public static final String URL = "jdbc:sqlserver://Lucci-PC:1433;databaseName=NDT_Shop"
	public static final String URL = "jdbc:mysql://localhost:3306/ndtshop";
	
	public static final String USERNAME = "vietvd";
	public static final String PASSWORD = "abc123";
}
