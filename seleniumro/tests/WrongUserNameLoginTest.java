package seleniumro.tests;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumro.core.BaseTest;
import seleniumro.poms.LoginPage;

@Test
public class WrongUserNameLoginTest extends BaseTest{
	
	public void test() {
		LoginPage lp = new LoginPage(driver);
		String username = "admin1";
		String password = "123456";
		lp.login(username, password);
		String errorLine = "ERROR: Invalid username. Lost your password?";
		lp.errorMsg.equals(errorLine);
	}
}
