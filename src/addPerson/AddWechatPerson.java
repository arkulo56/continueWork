package addPerson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimerTask;

import base.BaseCapability;
import entity.WechatAccout;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AddWechatPerson extends TimerTask {

	WechatAccout wechat_accout = new WechatAccout();
	/**
	 * get next a account useful
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void getWechatAccount() throws ClassNotFoundException, SQLException
	{
		int front_days = 7;
		
		Connection conn = base.BaseMysql.getCon();
		Statement stmt = conn.createStatement();	
		//status equls 0, lastes addAction was performed before 7 days ago; order by id asc; limit 1 record;
		String sql = "select * from wechat_accout where status = 0 and lastes_time < DATE_SUB(now(),INTERVAL "+front_days+" DAY) order by id asc limit 1";
		ResultSet res = stmt.executeQuery(sql);
		while(res.next())
		{
			if(res!=null)
			{
				wechat_accout.setId(res.getInt(1));
				wechat_accout.setAccount(res.getString(2));
				wechat_accout.setStatus(res.getInt(3));
				System.out.println(wechat_accout);
			}
		}
	}
	
	/**
	 * add friend accroding by getWechatAccount
	 */
	public void run()
	{
		BaseCapability base = new BaseCapability();
		AppiumDriver<MobileElement> driver = base.getDriver("oppo");
		
		//send Message to new Friend
		String friendMessage = "喜欢耳环、项链等首饰的美女加我，大牌的原创的均有，价格实惠！";
		//action which add account
		try{
			//get next account 
			getWechatAccount();
			if(wechat_accout.getAccount()==null || wechat_accout.getAccount()=="")
			{
				throw new Exception("***get account is null***");
			}
			
			
			Thread.sleep(5000);
			MobileElement el1 = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"当前所在页面,与的聊天\"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView");
			el1.click();Thread.sleep(3000);			
			MobileElement el2 = (MobileElement) driver.findElementByXPath("//android.widget.RelativeLayout[@content-desc=\"更多功能按钮\"]/android.widget.ImageView");
			el2.click();Thread.sleep(3000);
			MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
			el3.click();Thread.sleep(3000);
			MobileElement el4 = (MobileElement) driver.findElementById("com.tencent.mm:id/dkw");
			el4.click();Thread.sleep(3000);
			MobileElement el5 = (MobileElement) driver.findElementById("com.tencent.mm:id/m6");
			el5.sendKeys(wechat_accout.getAccount());Thread.sleep(3000);
			MobileElement el6 = (MobileElement) driver.findElementById("com.tencent.mm:id/o9");
			el6.click();Thread.sleep(3000);
			MobileElement el7 = (MobileElement) driver.findElementById("com.tencent.mm:id/d8");
			el7.click();Thread.sleep(3000);
			MobileElement el8 = (MobileElement) driver.findElementById("com.tencent.mm:id/eim");
			el8.clear();
			Thread.sleep(3000);
			el8.sendKeys(friendMessage);
			Thread.sleep(3000);
			MobileElement el9 = (MobileElement) driver.findElementById("com.tencent.mm:id/lm");
			el9.click();Thread.sleep(3000);
			
			//involv update table
			this.updateAccountLastesTime();
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * modify lastes_time of wechat_accout table
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void updateAccountLastesTime() throws ClassNotFoundException, SQLException
	{
		Connection conn = base.BaseMysql.getCon();
		Statement stmt = conn.createStatement();
		
		String sql = "update wechat_accout set lastes_time=now() where id="+this.wechat_accout.getId()+" limit 1";
		if(stmt.executeUpdate(sql)>0)
		{
			this.wechat_accout.setId(0);
			this.wechat_accout.setAccount("");
			this.wechat_accout.setStatus(0);
			System.out.println("update table success!");
		}
	}
	
	
	
	
	
	
	
	
	
}
