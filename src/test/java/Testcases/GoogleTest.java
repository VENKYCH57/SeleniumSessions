package Testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

	@Test
	public void titleTest() {
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google");
	}

	@Test
	public void searchTest() {
		Assert.assertTrue(driver.findElement(By.name("q")).isDisplayed());
	}

	@Test
	public void logoTest() {
		Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed());
	}

}
