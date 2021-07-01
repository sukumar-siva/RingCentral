package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	
	By userName = By.id("user-name");
	By password = By.id("password");
	By loginButton = By.id("login-button");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUserName() {
		return driver.findElement(userName);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
}
