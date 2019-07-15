package seleniumro.tests;

import static seleniumro.core.Helpers.check2StringIfEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumro.core.BaseTest;
import seleniumro.core.WordPress;
import seleniumro.poms.AddNewPost;
import seleniumro.poms.DashboardPage;
import seleniumro.poms.LeftMenu;
import seleniumro.poms.LoginPage;
import seleniumro.poms.Posts;

@Test
public class AddNewPostTest extends BaseTest {
	
	public void test() throws InterruptedException {
		WordPress wp = WordPress.init(driver);
		
		wp.loginPage.login("admin", "admin_pass!");
		wp.dashboardPage.pageTitle.checkIfDisplayed();
		
//		Helpers.click(driver, lm.postsLnk, lm.addNewPostLnk);
//		
//		Thread.sleep(5000);
//		
//		AddNewPost anp = new AddNewPost(driver);
//		Assert.assertTrue(anp.pageNameLabel.isDisplayed(), "Page label is displayed for Add New post page");
//		check2StringIfEquals(anp.pageNameLabel, "Add a New Post");
		
		wp.leftMenu.postsLnk.click();
		
		wp.posts.pageNameLabel.checkIfDisplayed();
		wp.leftMenu.addNewPostNotHoverLnk.click();
		
		wp.addNewPost.pageNameLabel.equals("Add a New Post");
		wp.addNewPost.postTitleInput.sendKeys("My new post");
		wp.addNewPost.contentInput.sendKeysWithoutValidation("New content");
		
		
		Thread.sleep(5000);
	}
}