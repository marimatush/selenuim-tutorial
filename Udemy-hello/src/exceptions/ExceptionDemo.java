package exceptions;

import java.sql.SQLException;

public class ExceptionDemo {

	public static void main(String[] args) {
		Account acc = new Account();
		try {
			System.out.println("Before trying");
			acc.withdraw(10);
			System.out.println("After trying");
		} catch (SQLException e) {
			// "catch" needs a "try"
			System.out.println(e.getMessage());
		} finally {
			// always executes
			System.out.println("Always executes!");
		}
	}

}
