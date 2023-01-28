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

public class carousel {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.noon.com/");
		Thread.sleep(1000);

		String rxpath = "//h3[text()='Recommended for you']/../following-sibling::div//div[@data-qa='product-name']/span";
        String nxpath="//h3[text()='Recommended for you']/..//following-sibling::div//div[contains(@class,'swiper-button-next')]";

	  List<WebElement> reclist=driver.findElements(By.xpath(rxpath));
	  System.out.println(reclist.size());
//	  Set<String> acrrecomlist=new TreeSet<String>();
//	  while(!driver.findElement(By.xpath(nxpath)).getAttribute("class").contains("swiper-button-disabled"));{
//		  for(WebElement e:reclist) {
//			 String text= e.getText();
//			 acrrecomlist.add(text);
//		  }
//		  driver.findElement(By.xpath(nxpath)).click();
//		  reclist=driver.findElements(By.xpath(nxpath));
//	  }
//	for(String e:acrrecomlist) {
//		System.out.println(e);
//	}
	}
	
}
