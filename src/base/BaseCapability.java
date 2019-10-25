package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseCapability {
	
	//private String virtualDeviceName = "oppo";
	private String deviceName;
	private String udid;
	private String platformName;
	private String platformVersion;
	private String appPackage;
	private String noReset;
	
	private AppiumDriver<MobileElement> driver;
	
	public AppiumDriver<MobileElement> getDriver(String virualDeviceName)
	{
		if(virualDeviceName == "oppo")
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName", "OPPO R9tm");
			caps.setCapability("udid", "4TDIVOOB99999999"); //Give Device ID of your mobile phone
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "5.1");
			caps.setCapability("appPackage", "com.tencent.mm");
			caps.setCapability("appActivity", "com.tencent.mm.ui.LauncherUI");
			caps.setCapability("noReset", "true");
			caps.setCapability("unicodeKeyboard", "true");
			caps.setCapability("resetKeyboard", "true");
			
			try
			{
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			}catch(MalformedURLException e){
				System.out.println(e.getMessage());
			}
			return driver;
		}
		
		return null;
	}
}
