package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WriteMessage {
	
	public WebDriver driver;
	
	By writePost = By.cssSelector("div[aria-label*='on your mind']");
	By submitPost = By.cssSelector("div[aria-label='Post']");
	
	public WriteMessage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement writePostMessage() {
		return driver.findElement(writePost);
	}
	public void clickPostButton() {
		driver.findElement(submitPost).click();
	}

}
