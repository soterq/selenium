package seleniumro.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumro.core.BaseTest;
import seleniumro.core.WordPress;
import seleniumro.poms.DashboardPage;
import seleniumro.poms.LoginPage;

@Test
public class LoginTest extends BaseTest {
	
	public void test(){
		WordPress wp = WordPress.init(driver);
		
		wp.loginPage.login("admin", "admin_pass!");
		wp.dashboardPage.pageTitle.equals("Dashboard");
		wp.dashboardPage.welcomeMsg.equals("Welcome to WordPress!");
	}
}
