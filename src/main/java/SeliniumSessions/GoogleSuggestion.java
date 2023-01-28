package SeliniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSuggestion {
     static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		 //driver=new ChromeDriver();
		 driver=new FirefoxDriver();
		 driver.get("https://www.google.com/");
		 
		 
		
		driver.findElement(By.name("q")).sendKeys("selinium webdriver");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//b[contains(text(),' interview questions')]")).click();
	}

}
