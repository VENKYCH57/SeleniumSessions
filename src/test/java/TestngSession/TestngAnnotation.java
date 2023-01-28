package TestngSession;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngAnnotation {

	@BeforeSuite
	public void connectWithDb() {
		System.out.println("BS.......connectWithDb");
	}

	@BeforeTest
	public void login() {
		System.out.println("BT..........login");
	}

	@BeforeClass
	public void createUser() {
		System.out.println("BC..........createUser");
	}

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("BM..........launchBrowser");
	}

	@Test
	public void Atest() {
		System.out.println("Atest");
	}

	@Test
	public void Btest() {
		System.out.println("Btest");
	}

	@Test
	public void Ctest() {
		System.out.println("Ctest");
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("AM..........closeBrowser");
	}

	@AfterClass
	public void deleteUser() {
		System.out.println("AC..........deleteUser");
	}

	@AfterTest
	public void logout() {
		System.out.println("AT..........logout");
	}

	@AfterSuite
	public void disConnectWithDb() {
		System.out.println("AS.......disConnectWithDb");
	}

}
