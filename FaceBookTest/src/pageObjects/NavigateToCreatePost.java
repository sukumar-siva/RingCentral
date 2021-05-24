package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigateToCreatePost {

	public WebDriver driver;

	By createIcon = By.xpath("//div[@aria-label='Create']");
	By menuIcon = By.xpath("//div[@aria-label='Menu']");
	By postIcon = By.xpath("//span[normalize-space()='Post']");

	public NavigateToCreatePost(WebDriver driver) {
		this.driver = driver;
	}

	public void identifyCreatePost() {

		if (driver.findElements(createIcon).size() != 0) {
			driver.findElement(createIcon).click();
		} else if (driver.findElements(menuIcon).size() != 0) {
			driver.findElement(menuIcon).click();
		}
	}

	public void clickPostIcon() {
		WebDriverWait waitTime = new WebDriverWait(driver, 5);
		waitTime.until(ExpectedConditions.visibilityOfElementLocated(postIcon));
		driver.findElement(postIcon).click();
	}

}
