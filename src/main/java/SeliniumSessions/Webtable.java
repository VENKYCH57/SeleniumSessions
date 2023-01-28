package SeliniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/big-bash-league-2022-23-1324623/adelaide-strikers-vs-sydney-thunder-9th-match-1324632/full-scorecard");

		// System.out.println(getWicketTakerName("Daniel Sams"));

		// List<WebElement> scorelist = driver.findElements(By.xpath(
		// "//span[text()='Alex Hales']/.././../../following-sibling::td[@class='ds-w-0
		// ds-whitespace-nowrap ds-min-w-max ds-text-right']"));

		System.out.println(getBatsmanScore("Oliver Davies"));
	}

	public static String getWicketTakerName(String batsname) {
		String wxpath = "//span[text()='" + batsname + "']/../../../following-sibling::td/span/span";
		return driver.findElement(By.xpath(wxpath)).getText();
	}

	public static List<String> getBatsmanScore(String batsname) {
		String scorexpath = "//span[text()='" + batsname
				+ "']/.././../../following-sibling::td[@class='ds-w-0 ds-whitespace-nowrap ds-min-w-max ds-text-right']";
		List<String> avgscorelist = new ArrayList<String>();
		List<WebElement> scorelist = driver.findElements(By.xpath(scorexpath));
		for (WebElement e : scorelist) {
			String text = e.getText();
			avgscorelist.add(text);
		}
		return avgscorelist;

	}

}
