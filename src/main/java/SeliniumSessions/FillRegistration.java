package SeliniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utility.BrowserUtil;
import Utility.ElementUtil;

public class FillRegistration {
	

	public static void main(String[] args) {
		
		

		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.IntitDriver("chrome");
		ElementUtil el=new ElementUtil(driver);

		
		br.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		
		By favorname=By.id("Form_getForm_subdomain");
		By fullname=By.id("Form_getForm_Name");
		By phno=By.id("Form_getForm_Contact");
		By buemail=By.id("Form_getForm_Email");
		
		el.doSendKeys(favorname, "venky");
		el.doSendKeys(fullname, "venkatesh chilukuri");
		el.doSendKeys(phno, "9902508620");
		el.doSendKeys(buemail, "venkych59@gmail.com");
		
		
		

		By firstname = By.id("input-firstname");
		By lasttname = By.id("input-lastname");
		By email= By.id("input-email");
		By pasword=By.id("input-password");
		
//		el.doSendKeys(firstname, "venkatesh");
//		el.doSendKeys(lasttname, "chilukuri");
//		el.doSendKeys(email, "venkych57@gmail.com");
//		el.doSendKeys(pasword, "venky@123");
	}

}
