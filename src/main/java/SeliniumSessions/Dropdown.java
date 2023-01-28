package SeliniumSessions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import Utility.BrowserUtil;
import Utility.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {
	static WebDriver driver;

	public static void main(String[] args) {

		//WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();

		driver = new FirefoxDriver();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		ElementUtil el = new ElementUtil(driver);
		
		By signin=By.cssSelector("input[type='submit']");
		
		driver.findElement(signin).click();
		
		System.out.println(el.alertGetText(3));
		
	}
}