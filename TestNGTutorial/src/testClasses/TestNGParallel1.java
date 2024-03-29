package testClasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGParallel1{
	
	@BeforeClass
	public void setup() {		
	}
	
	@AfterClass
	public void cleanup() {
	}

	@Test
	public void testParallel1() throws InterruptedException {
		System.out.println("TestNGParallel1 -> testParallel1");
		Thread.sleep(6000);
		System.out.println("TestNGParallel1 -> testParallel1 -> more steps");
	}
	
	@Test
	public void testParallel2() throws Exception {
		System.out.println("TestNGParallel1 -> testParallel2");
		Thread.sleep(6000);
		System.out.println("TestNGParallel1 -> testParallel2 -> more steps");
	}
}
