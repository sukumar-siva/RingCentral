package Assignment1;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

import pageObjects.HomeButton;
import pageObjects.LoginPage;
import pageObjects.NavigateToCreatePost;
import pageObjects.WriteMessage;

public class FacebookPost extends InitializeBrowser {
	public static WebDriver driver;

	public static void main(String[] args) throws SecurityException, IOException {

		driver = broswerConfig();
		driver.get(config.getProperty("url"));
		log.info("URL link loaded successfully");

		LoginPage loginFacebook = new LoginPage(driver);
		loginFacebook.getEmail().sendKeys(config.getProperty("username"));
		loginFacebook.getPassword().sendKeys(config.getProperty("password"));
		log.info("Username and Password entered");
		loginFacebook.submit();
		log.info("Logged into account successfully");

		NavigateToCreatePost navigate = new NavigateToCreatePost(driver);
		navigate.identifyCreatePost();
		log.info("Clicked on Menu/Create link to create Post");
		navigate.clickPostIcon();
		log.info("Clicked on Post link to write the post");

		WriteMessage post = new WriteMessage(driver);
		post.writePostMessage().sendKeys(config.getProperty("postMessage"));
		log.info("Entered post as " + config.getProperty("postMessage"));

		post.clickPostButton();
		log.info("Clicked on Post button to post on timeline");

		HomeButton homeIcon = new HomeButton(driver);
		homeIcon.clickHomeButton();
		log.info("Clicked on Home button to view the Post");

	}

}
