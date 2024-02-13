package testClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGGrouping {
	
	@BeforeClass(alwaysRun=true)
	public void beforeClass() {
		System.out.println("before class");
	}
	
	@Test(groups= {"groupone", "ones"})
	public void testGroupOne1() {
		System.out.println("Test testGroupOne1");
	}
	
	@Test(groups= {"groupone", "ones"})
	public void testGroupOne2() {
		System.out.println("Test testGroupOne2");
	}
	
	@Test(groups= {"grouptwo", "twos"})
	public void testGroupTwo1() {
		System.out.println("Test testGroupTwo1");
	}
	
	@Test(groups= {"groupto", "twos"})
	public void testGroupTwo2() {
		System.out.println("Test testGroupTwo2");
	}
}
