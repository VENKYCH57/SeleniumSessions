package SeliniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calender {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get(
				"https://www.goibibo.com/flights/?utm_source=google&utm_medium=cpc&utm_campaign=DF-Brand-EM&utm_adgroup=Only+Goibibo&utm_term=%21SEM%21DF%21G%21Brand%21RSA%21108599293%216504095653%21602838584772%21e%21goibibo%21c%21&gclid=CjwKCAiAqaWdBhAvEiwAGAQlts4U7k41mSTqQb4Y6Z7_MZe_4IQPuE31McNlbC-CQE_xLUXKyAEXlBoCmEAQAvD_BwE");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//p[@class='sc-fotOHu jNyPRF fswWidgetTitle'])[1]")).click();

		// selectdate("31");

		String actmonth = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
		String expmonth = "//div[text()='March 2023']";
		String nextxpath = "//span[contains(@class,'DayPicker-NavButton--next')]";
		while (!actmonth.equals(expmonth)) {
			driver.findElement(By.xpath(nextxpath)).click();
			Thread.sleep(5000);
			actmonth = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
		}
		selectdate("25");

	}

	public static void selectdate(String date) throws InterruptedException {
		driver.findElement(By.xpath("//p[text()='" + date + "']")).click();
		Thread.sleep(100);
		driver.findElement(By.xpath("//span[text()='Done']")).click();

	}

}
