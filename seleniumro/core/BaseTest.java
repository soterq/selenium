package seleniumro.core;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

	private static final Logger log = LogManager.getLogger(BaseTest.class);
	
	protected static WebDriver driver;
	
	@BeforeClass
	public void setup(){
		log.info(getClass().getSimpleName());
		log.info("Open browser");
		
//		if("driverFormConfig".equals("Firefox")) {
//			driver = new FirefoxDriver();
//		}else if("driverFormConfig".equals("Chrome")) {
//			driver = new ChromeDriver();
//		}
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = "http://testing.webtic.info/wordpress/wp-login.php";
		log.info("Navigate to: " + url);
		driver.get(url);
	}
	
	@AfterClass
	public void close(){
		takeScreenshot();
		driver.quit();
	}
	
	public static void takeScreenshot(){
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		LocalDateTime timePoint = LocalDateTime.now();
		String name = "screens/screenshot "  + timePoint.get(ChronoField.YEAR_OF_ERA) + "-" + timePoint.getMonth() + "-" + timePoint.getDayOfMonth() + "|"+ timePoint.getHour() + "-" + timePoint.getMinute() + "-" + timePoint.getSecond() + ".png";
		File DestFile=new File(name);
		log.info("Screenshot name is " + name);
        try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
