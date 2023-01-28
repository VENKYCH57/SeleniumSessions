package Testcases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FreshworkTest extends BaseTest {

	@Test
	public void titleTest() {
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Freshworks | Modern and Easy Customer and Employee Experience Software");
	}

	@Test
	public void logoTest() {
		Assert.assertTrue(driver.findElement(By.xpath("(//img[@alt='Freshworks'])[1]")).isDisplayed());
	}

}
