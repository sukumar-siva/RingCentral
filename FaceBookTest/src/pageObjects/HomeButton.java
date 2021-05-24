package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeButton {

	public WebDriver driver;

	By home = By.xpath("//div/ul/li/span/div/a[@aria-label='Home']");

	public HomeButton(WebDriver driver) {
		this.driver = driver;
	}

	public void clickHomeButton() {
		WebDriverWait waitTime = new WebDriverWait(driver, 10);
		waitTime.until(ExpectedConditions.visibilityOfElementLocated(home));
		Actions mouseOver = new Actions(driver);
		mouseOver.moveToElement(driver.findElement(home)).click().build().perform();
	}

}
