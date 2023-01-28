package TestngSession;

import org.testng.annotations.Test;

public class DependsOnMethods {

	@Test
	public void login() {
		try {
			int i = 9 / 0;
		} catch (ArithmeticException e) {
          System.out.println("handled exception");
		}

		System.out.println("login");
	}

	@Test(dependsOnMethods = "login")
	public void title() {
		System.out.println("title");
	}

	@Test(dependsOnMethods = "login")
	public void search() {
		System.out.println("search");
	}

}
