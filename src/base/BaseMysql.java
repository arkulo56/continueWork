package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseMysql {
	private static Connection conn = null;
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/wechat_operation?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USER = "zhao";
	private static final String PASS = "";
	
	public static Connection getCon() throws ClassNotFoundException, SQLException
	{
		if(conn!=null)
		{
			return conn;
		}else
		{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		}
		return conn;
	}
}
