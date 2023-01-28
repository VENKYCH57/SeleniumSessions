package SeliniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jquery {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();

		By choice = By.xpath("//li[@class='ComboTreeItemChlid']//span");
		selectChoices(choice, "choice 4","choice 5");
	}

	public static void selectChoices(By locator, String... value) {
		List<WebElement> choicelist = driver.findElements(locator);

		if (!value[0].equalsIgnoreCase("ALL")) {

			for (WebElement e : choicelist) {
				String text = e.getText();
				System.out.println(text);

				for (String f : value) {
					if (text.equals(f)) {
						e.click();
						break;
					}
				}

			}
		} else {
			for (WebElement e : choicelist) {
				e.click();
			}

		}
	}
}
