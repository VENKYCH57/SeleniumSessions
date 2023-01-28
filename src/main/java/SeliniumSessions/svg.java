package SeliniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class svg {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver= new FirefoxDriver();
		WebDriver driver = new ChromeDriver();

		driver.get("https://emicalculator.net/");
		Thread.sleep(3000);

		String xpat = "//*[local-name()='svg']//*[name()='g' and contains(@class,'highcharts-pie-series')]//*[name()='path' and contains(@class,'highcharts-point')]";
		String tipxpath ="//*[local-name()='svg']//*[name()='g' and contains(@class,'highcharts-tooltip')]//*[name()='text']//*[name()='tspan']";
		List<WebElement> pie = driver.findElements(By.xpath(xpat));
		System.out.println(pie.size());
		Actions act = new Actions(driver);
		for (WebElement e : pie) {
			act.moveToElement(e).perform();
			Thread.sleep(100);
			String text=driver.findElement(By.xpath(tipxpath)).getText();
			System.out.println(text);
		}

	}

}
