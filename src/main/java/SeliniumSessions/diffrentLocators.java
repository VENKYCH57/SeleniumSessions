package SeliniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utility.BrowserUtil;
import Utility.ElementUtil;

public class diffrentLocators {

	public static void main(String[] args) {
		
		BrowserUtil b= new BrowserUtil();
		WebDriver driver=b.IntitDriver("chrome");
		b.launchUrl("https://adminportalp.camcom.ai/hil/login");
		
		ElementUtil el= new ElementUtil(driver);
		
		By sign= By.linkText("Sign Up");
		By name= By.name("first_name");
		By lname= By.name("surname");
		By email= By.name("email");
		By cemail=By.name("email_confirm");
		By un=By.xpath("/html/body/section[1]/div[1]/form/div[7]/input");
		By pwd=By.cssSelector("div.form-group:nth-child(9) > input:nth-child(1)");
		By cnpwd=By.name("passwordconfirm");
		By agree=By.name("agreeTerms");
		By sbt=By.id("submitButton");
		
		
		el.doClick(sign);
		el.doSendKeys(name, "venkatesh");
		el.doSendKeys(lname, "chilukuri");
		el.doSendKeys(email, "venky@123");
		el.doSendKeys(cemail, "venky@123");
		el.doSendKeys(un, "venkych57");
		el.doSendKeys(pwd, "venky123456");
		el.doSendKeys(cnpwd, "venky123456");
		el.doClick(agree);
		el.doClick(sbt);
		

	}

}
