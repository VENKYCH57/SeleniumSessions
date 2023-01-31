package SeliniumSessions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windowhandles {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		

		By facebook = By.xpath("//a[@href='https://www.facebook.com/OrangeHRM/']");
		By twiiter = By.xpath("//a[@href='https://twitter.com/orangehrm?lang=en']");
		By youtube = By.xpath("//a[@href='https://www.youtube.com/c/OrangeHRMInc']");

		
//		driver.findElement(twiiter).click();
//		driver.findElement(youtube).click();

		Set<String> windowhandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>(windowhandles);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		
		String parentwindow = handles.get(0);
		
		driver.findElement(facebook).click();
		String facewindow = handles.get(1);
		driver.switchTo().window(facewindow);
		System.out.println("facebook title is:" + driver.getTitle());

	}

}
