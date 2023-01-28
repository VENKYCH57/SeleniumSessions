package Testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
	
	
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {
			{"venky","ch","venky@1gmail.com","venky@1"},
			{"venky","ch","venky@2gmail.com","venky@2"},
			{"venky","ch","venky@3gmail.com","venky@3"},
			{"venky","ch","venky@4gmail.com","venky@4"},	
		};
		
	}
	
	@Test(dataProvider="getData")
    public void loginCreateTest(String fn,String ln,String em,String pwd) throws InterruptedException {
    	Assert.assertTrue(fillData(fn,ln,em,pwd));
    }
	
	public boolean fillData(String fn,String ln,String em,String pwd) throws InterruptedException {
		driver.findElement(By.id("input-firstname")).clear();
		driver.findElement(By.id("input-firstname")).sendKeys(fn);
		
		driver.findElement(By.id("input-lastname")).clear();
		driver.findElement(By.id("input-lastname")).sendKeys(ln);
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(em);
		
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(pwd);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		String text=driver.findElement(By.xpath("//h1/../p")).getText();
		if(text.contains("If you already have an account with us, please login at the ")) {
			return true;
		}
		return false;
			
	}

}
