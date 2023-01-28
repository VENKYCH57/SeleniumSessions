package TestngSession;

import org.testng.annotations.Test;

public class PriorityConcept {
	
	@Test(priority=-5)
	public void a_Test() {
		System.out.println("a_Test");
	}
	@Test(priority=4)
	public void b_Test() {
		System.out.println("b_Test");
	}
	@Test(priority=3)
	public void c_Test() {
		System.out.println("c_Test");
	}
	@Test(priority=2)
	public void d_Test() {
		System.out.println("d_Test");
	}
	@Test(priority=1)
	public void e_Test() {
		System.out.println("e_Test");
	}

}
