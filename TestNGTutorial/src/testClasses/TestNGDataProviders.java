package testClasses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProviders {
	// datasets for testing
//	 moved to a class TestData
//	@DataProvider(name="inputs")
//	public Object[][] getData() {
//		return new Object[][] {
//			{"bmw", "m3"},
//			{"audi", "a6"},
//			{"benz", "c300"}
//		};
//	}
	
	@Test(dataProvider = "inputs", dataProviderClass=TestData.class)
	public void testMethod(String input1, String input2) {
		System.out.println("Input1: " + input1);
		System.out.println("Input2: " + input2);
	}
}
