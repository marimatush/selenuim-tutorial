package exceptions;

public class RuntimeExceptionDemo {

	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		int c;
		
		try {
			c = a / b;
			System.out.println("Result is " + c);
		} catch (Exception e) {
			System.out.println("Division by zero is not possible");
			System.out.println(e.getMessage());
		}
		
		// Array out of bound
		int[] number = {1, 2, 3};
		try {
			for (int i = 0; i <= 3; i++) {
				System.out.println(number[i]);
			}
		} catch (Exception e) {
			System.out.println("There is no index availbale after 2");
		}
	}

}
