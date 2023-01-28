package SeliniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.ElementUtil;
import Utility.JavaScriptUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testjsborder {

	public static WebDriver driver;
	public static ElementUtil elementutil;
	public static JavaScriptUtil js;

	private By firstn = By.id("input-firstname");
	private By lastn = By.id("input-lastname");
	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By btnYes = By.xpath("(//div[@class='form-check form-check-inline']//label)[1]");
	private By btnno = By.xpath("(//div[@class='form-check form-check-inline']//label)[2]");
	private By agree = By.name("agree");
	private By ctn = By.xpath("//button[@type='submit']");
	private By suc = By.xpath("(//div[@class='row']//p)[2]");

	public String registartion(String fn, String ln, String em, String pwd, String subscribe) {
		fillRegister(fn, ln, em, pwd);
		subscribe(subscribe);
		return agreAndCont();
	}

	private void fillRegister(String fn, String ln, String em, String pwd) {
		elementutil.doActSendkeys(firstn, fn);
		elementutil.doActSendkeys(lastn, ln);
		elementutil.doActSendkeys(email, em);
		elementutil.doActSendkeys(password, pwd);
	}

	private void subscribe(String subscribe) {
		if (subscribe.equalsIgnoreCase("yes")) {
			elementutil.doActClick(btnYes);
		} else {
			elementutil.doActClick(btnno);
		}
	}

	private String agreAndCont()  {
		elementutil.doClick(agree);
		js.scrollIntoView(elementutil.getElement(ctn));
		elementutil.doActClick(ctn);
		// Thread.sleep(500);
		return elementutil.doGetText(suc);
	}

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	    elementutil =new ElementUtil(driver);
		js = new JavaScriptUtil(driver);
		driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");

		testjsborder t = new testjsborder();
		t.registartion("venkatesh", "chilukuri", "venkych57@gmail.com", "venky@123", "yes");

	}

}
