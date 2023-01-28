package SeliniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fairfirst {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rsgib.portal.pilot.camcom.ai/login");

		String email = "exampleInputEmail1";
		String password = "exampleInputPassword1";
		String loginbutton = "//button[text()='Login']";
		String contbtn = "btnCont";

		dosendKeys("id", email, "rsgib@camcom.ai");
		dosendKeys("id", password, "camcom1616");
		doClick("xpath", loginbutton);
		Thread.sleep(2000);
		try {
			doClick("id", contbtn);
		} catch (NoSuchElementException e) {
			System.out.println("nosuch element error handled");
			Thread.sleep(1000);
		}

		List<WebElement> pages = driver.findElements(By.xpath("//li/a"));

		int i = 0;
		while (true) {
			if (driver.findElements(By.xpath("//td[text()='CAI037']")).size() > 0) {
				seletId(37);
				break;
			} else {
				try {
					pages.get(i).click();
					Thread.sleep(1000);

				} catch (Exception e) {
					System.out.println("pages are over coundnt find the element");
					break;
				}
				pages = driver.findElements(By.xpath("//li/a"));
			}
			i++;

		}

	}

	public static void seletId(int num) {
		String claimxpath = "//td[text()='CAI0" + num + "']";
		driver.findElement(By.xpath(claimxpath)).click();
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void dosendKeys(String locatorType, String locatorValue, String value) {
		getElement(getBy(locatorType, locatorValue)).sendKeys(value);
	}

	public static void doClick(String locatorType, String locatorValue) {
		getElement(getBy(locatorType, locatorValue)).click();
	}

	public static By getBy(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "css":
			locator = By.cssSelector(locatorValue);
			break;
		case "linktext":
			locator = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
			break;
		case "tag":
			locator = By.tagName(locatorValue);
			break;

		default:
			System.out.println("plesae pass the correct locator");
			break;
		}
		return locator;
	}

}
