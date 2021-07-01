package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FilterPrice {
	
	public WebDriver driver;
	
	By selectDropdown = By.className("product_sort_container");
	
	public FilterPrice(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getDropDown() {
		return driver.findElement(selectDropdown);
	}

}
