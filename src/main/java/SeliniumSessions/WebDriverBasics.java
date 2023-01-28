package SeliniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Utility.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		BrowserUtil br= new BrowserUtil();
		WebDriverBasics wb= new WebDriverBasics();
		WebDriverManager.chromedriver().setup();
		
		
		
		ChromeOptions co= new ChromeOptions();
		co.addArguments("--incognito");
		WebDriver driver= new ChromeDriver(co);
		
		driver.get("https://carsell.hil.portal.camcom.ai/hil/login");
		
		
		
		
		
		
		
		

	}

}
