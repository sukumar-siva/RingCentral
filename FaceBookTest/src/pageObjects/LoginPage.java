package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By userName = By.id("email");
	By password = By.id("pass");
	By login = By.xpath("//button[@type='submit']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getEmail() {
		return driver.findElement(userName);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public void submit() {
		driver.findElement(login).click();
	}

}
