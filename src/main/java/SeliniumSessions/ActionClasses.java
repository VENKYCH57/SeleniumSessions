package SeliniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Utility.BrowserUtil;
import Utility.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClasses {

	public static void main(String[] args)  {
		BrowserUtil b= new BrowserUtil();
		WebDriver driver=b.IntitDriver("firefox");
		b.launchUrl("https://www.spicejet.com/");
		ElementUtil el= new ElementUtil(driver);
		
		By addon=By.xpath("//div[text()='Add-ons']");
		By zero=By.xpath("//div[text()='Zero Cancellation']");
		
		try {
			el.parentChildMenueHandle(addon, zero);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}