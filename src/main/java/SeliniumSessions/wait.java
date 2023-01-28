package SeliniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utility.BrowserUtil;
import Utility.ElementUtil;

public class wait {

	public static void main(String[] args) {
		BrowserUtil b = new BrowserUtil();
		WebDriver driver = b.IntitDriver("chrome");
		ElementUtil el = new ElementUtil(driver);

		b.launchUrl("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		

		By footer = By.cssSelector("div.container div.row div.col-sm-3 li>a");
		
		
		el.printVisibleElementTextList(footer, 5);
	
	}

}
