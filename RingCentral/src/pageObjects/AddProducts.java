package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProducts {

	public WebDriver driver;
	
	By inventoryList = By.className("inventory_item");
	By addCartButton = By.xpath("//div[@class='pricebar']/button");
	
	public AddProducts (WebDriver driver) {
		this.driver = driver;
	}
	
	public List<WebElement> getInventoryList() {
		List<WebElement> inventoryItems = driver.findElements(inventoryList);		
		return inventoryItems;	
	}
	
	public void clickAddCartButton(){
		List<WebElement> addCart = driver.findElements(addCartButton);
		
		for (WebElement choice : addCart) {
			
			choice.click();
		}
		

	}
}
