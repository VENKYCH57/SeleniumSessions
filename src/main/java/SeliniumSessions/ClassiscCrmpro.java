package SeliniumSessions;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.BrowserUtil;
import Utility.ElementUtil;

public class ClassiscCrmpro {

	static WebDriver driver;

	public static void main(String[] args) {

		BrowserUtil b = new BrowserUtil();
		driver = b.IntitDriver("firefox");
		ElementUtil el= new ElementUtil(driver);
		b.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");

		//By country = By.xpath("//select[@name='Country']");
		By demo= By.xpath("//h5[text()='About Us']");
		
		WebElement bafd=driver.findElement(demo);
		
		scrollIntoView(bafd);
		//clickByJs(bafd);
		
		

	}

	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0]scrollIntoView(true);", element);

	}
	public static void clickByJs(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

}
