package Assignment1;

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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class InitializeBrowser {
	public static Properties config;
	public static WebDriver driver;
	public static Logger log = Logger.getLogger(FacebookPost.class.getName());

	public static WebDriver broswerConfig() throws IOException {

		config = new Properties();
		String packName = new Object() {

		}.getClass().getPackage().getName();
		FileInputStream fileRef = new FileInputStream("src" + "/" + packName + "/" + "config.properties");
		config.load(fileRef);

		FileHandler fileName = new FileHandler("src" + "/" + "logs/FaceBookPost_Log.txt");
		log.addHandler(fileName);
		SimpleFormatter formatter = new SimpleFormatter();
		fileName.setFormatter(formatter);

		String browserName = config.getProperty("browser");

		if (browserName.equals("chrome")) {
			File path = new File("src");
			File source = new File(path, "chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", source.getAbsolutePath());

			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");

			driver = new ChromeDriver(option);
		} else if (browserName.equals("firefox")) {
			File path = new File("src");
			File source = new File(path, "geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", source.getAbsolutePath());

			FirefoxProfile option = new FirefoxProfile();
			option.setPreference("dom.webnotifications.enabled", false);

			driver = new FirefoxDriver(option);
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;

	}
}
