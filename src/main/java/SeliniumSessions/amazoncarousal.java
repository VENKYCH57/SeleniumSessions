package SeliniumSessions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazoncarousal {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.amazon.in/?ext_vrnc=hi&tag=googhydrabk1-21&ref=nav_ya_signin&adgrpid=58075519359&hvpone=&hvptwo=&hvadid=486462454211&hvpos=&hvnetw=g&hvrand=7314061292976855639&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9299294&hvtargid=kwd-64107830&hydadcr=14452_2154371&gclid=CjwKCAiAhqCdBhB0EiwAH8M_GhRc6VbhUBsHql4PTmonlR6sXgg_H2-og4i2BAWCLJZSGaBqdDemCxoCwWAQAvD_BwE");
		Thread.sleep(1000);

		String deals = "//h2[text()='Today’s Deals']/parent::div//following-sibling::div//ul//span/a";
		String nextxpath = "//h2[text()='Today’s Deals']/../following-sibling::div/a[contains(@class,'feed-right')]";
		List<WebElement> dealslist = driver.findElements(By.xpath(deals));
		System.out.println(dealslist.size());
		Set<String> accdeallist = new TreeSet<String>();

		while (!driver.findElement(By.xpath(nextxpath)).getAttribute("class").contains("feed-control-disabled")) {
			for (WebElement e : dealslist) {
				String text = e.getText();
				if (!text.isEmpty()) {
					accdeallist.add(text);
				}

				driver.findElement(By.xpath(nextxpath)).click();
				dealslist = driver.findElements(By.xpath(deals));
			}
			for (String e : accdeallist) {
				System.out.println(e);
			}

		}

	}
}
