package SeliniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StringLocator {
    static  WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		
		String email="input-email";
		String password="password";
		String loginbutton="//button[text()='Login']";
		
		
		By emailid=getBy("id", email);
		
		getElement(emailid).sendKeys("venkych57");
		

	}
	
	public static By getBy(String locatorType,String locatorValue) {
		System.out.println("type :"+locatorType+" and "+ "value :"+locatorValue);
		By locator=null;
		switch (locatorType) {
		case "id":
			locator=By.id(locatorValue);
			break;
		case "name":
			locator=By.id(locatorValue);
			break;
		case "classname":
			locator=By.id(locatorValue);
			break;
		case "linktext":
			locator=By.id(locatorValue);
			break;
		case "partiallinktext":
			locator=By.id(locatorValue);
			break;
		case "xpath":
			locator=By.id(locatorValue);
			break;
		case "css":
			locator=By.id(locatorValue);
			break;
		case "tagname":
			locator=By.id(locatorValue);
			break;

		default:
			System.out.println("plesae pass the correct locator");
			break;
		}
		return locator;
		
	}
	public static void doSendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
}
