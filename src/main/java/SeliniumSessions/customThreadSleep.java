package SeliniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class customThreadSleep {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://app.hubspot.com/login?_conv_v=vi%3A1*sc%3A1*cs%3A1671770933*fs%3A1671770933*pv%3A1*seg%3A%7B10031564.1%7D*exp%3A%7B100330256.%7Bv.1003131869-g.%7B%7D%7D%7D&_conv_s=si%3A1*sh%3A1671770932867-0.6598097792462484*pv%3A1&hubs_signup-url=www.hubspot.com/products/crm&hubs_signup-cta=homepage-nav-login&_ga=2.1935217.1382642631.1671770918-1497777770.1671770917");

	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);

	}

	public WebElement customWait(int count, By locator) {
		WebElement element = null;
		int attempts = 0;
		while (attempts < count) {
			try {
				element = getElement(locator);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("element not found : " + attempts + " " + locator);
				try {
					Thread.sleep(2000);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
			attempts++;
		}
		return element;

	}

}
