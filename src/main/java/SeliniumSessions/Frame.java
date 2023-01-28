package SeliniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utility.BrowserUtil;
import Utility.ElementUtil;

public class Frame {
     static WebDriver driver;
	public static void main(String[] args) {
		BrowserUtil b= new BrowserUtil();
		
		driver=b.IntitDriver("chrome");
		ElementUtil el= new ElementUtil(driver);
		
		b.launchUrl("https://classic.crmpro.com/index.html");
		
		
	}

}
