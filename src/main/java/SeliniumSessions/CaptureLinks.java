package SeliniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utility.BrowserUtil;

public class CaptureLinks {
      
	public static void main(String[] args) {
		
		BrowserUtil b= new BrowserUtil();
		WebDriver driver=b.IntitDriver("chrome");
		b.launchUrl("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		
		List<WebElement> links =driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		
		for(int i=0; i<links.size();i++) {
			String pagelinks=links.get(i).getText();
			System.out.println(pagelinks);
		}
		
     	By register= By.linkText("Register");		
		driver.findElement(register).click();
		
		List<WebElement> textfields =driver.findElements(By.tagName("input"));
		
		System.out.println(textfields.size());
		for(WebElement e:textfields) {
			String p=e.getAttribute("placeholder");
			System.out.println(p);
		}
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
