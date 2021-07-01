package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartContainerCheck {
	
	public WebDriver driver;
	
	By cartIcon = By.xpath("//div[@class='shopping_cart_container']/a");
	
	public CartContainerCheck(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void clickCartIcon() {
		driver.findElement(cartIcon).click();
	}

}
