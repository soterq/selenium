package seleniumro.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class LoginWordPressCom {
	
	public void test() {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://vosaprim.wordpress.com/wp-admin");
		
		WebElement login = driver.findElement(By.xpath("//input[@id='usernameOrEmail']"));
		login.sendKeys("vosaprim");
		
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		submit.click();
		
		WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElements(pass));
		pass.sendKeys("mypass");
		
	}
}