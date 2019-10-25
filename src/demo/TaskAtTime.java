package demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

public class TaskAtTime {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Connection conn = base.BaseMysql.getCon();
		Statement stmt = conn.createStatement();		
		String sql = "insert into add_friend_history values (null,1,\"ymnyhl5\",now())";
		int num = stmt.executeUpdate(sql);
		System.out.println(num);
	}
}
