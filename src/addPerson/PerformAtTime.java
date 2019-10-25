package addPerson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;


public class PerformAtTime {

	//15 minute perform once
	private static int period = 25*60*1000;
	
	public static void main(String[] args)
	{
		try{
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = format.parse("2019-10-22 10:42:00");
			Timer timer = new Timer();
			timer.schedule(new addPerson.AddWechatPerson(), date, period);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
