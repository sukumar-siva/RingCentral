package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseSettings {
	public static Properties prop;
	public static WebDriver driver;
	public static Logger log = Logger.getLogger(Task.class.getName());
	
	public static WebDriver base() throws IOException {
	
	prop = new Properties();
	FileInputStream fi = new FileInputStream("src"+"/"+"config.properties");
	prop.load(fi);
	
	FileHandler fileName = new FileHandler("src" + "/" + "sauceDemo_Log.txt");
	log.addHandler(fileName);
	SimpleFormatter formatter = new SimpleFormatter();
	fileName.setFormatter(formatter);

	
	String browserName = prop.getProperty("browser");
	
	if (browserName.equalsIgnoreCase("chrome")) {
		File path = new File("src");
		File source = new File(path, "chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", source.getAbsolutePath());

		driver = new ChromeDriver();
		
	} else if (browserName.equals("firefox")) {
		File path = new File("src");
		File source = new File(path, "geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", source.getAbsolutePath());

		driver = new FirefoxDriver();
	}

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	return driver;
	
	}

}
