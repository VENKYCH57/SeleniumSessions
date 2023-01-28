package SeliniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alert {
     static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
//		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//		
//		
//		//driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//		//driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
//		
//		Alert alert=driver.switchTo().alert();
//		alert.sendKeys("iam venky");
//		Thread.sleep(3000);
//		String text=alert.getText();
//		System.out.println(text);
//		alert.accept();
//		//alert.dismiss();
		
		
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
	    driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:/Users");
		
	
		
		
	
	
		
		

	}

}
