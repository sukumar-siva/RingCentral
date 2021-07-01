package main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.AddProducts;
import pageObjects.CartContainerCheck;
import pageObjects.FilterPrice;
import pageObjects.HomePage;

public class Task extends BaseSettings{
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		driver = base();
		driver.get(prop.getProperty("url"));
		log.info("URL link successfully opened, URL : "+prop.getProperty("url"));
		
		HomePage login = new HomePage(driver);
		login.getUserName().sendKeys(prop.getProperty("userName"));
		log.info("User Name entered successfully ");
		login.getPassword().sendKeys(prop.getProperty("password"));
		log.info("Password entered successfully");
		login.clickLogin();
		log.info("Logged in successfully");
		
		FilterPrice filterProducts = new FilterPrice(driver);
		Select price = new Select(filterProducts.getDropDown());
		price.selectByValue("lohi");
		log.info("Products filtered based on Price Low to High");
		
		AddProducts addCart = new AddProducts(driver);
		WebDriverWait waitTime = new WebDriverWait(driver, 5);
		waitTime.until(ExpectedConditions.visibilityOfAllElements(addCart.getInventoryList()));
		addCart.clickAddCartButton();
		log.info("Products added to cart successfully");
		
		CartContainerCheck cartCheck = new CartContainerCheck(driver);
		cartCheck.clickCartIcon();
		log.info("Products added are listed in Cart");

	}

}
