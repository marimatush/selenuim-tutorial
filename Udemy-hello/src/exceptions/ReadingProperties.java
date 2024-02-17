package exceptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

	public static void main(String[] args) throws IOException {
		// helps java to understand file properties
		String path = "C:\\Users\\Masha\\eclipse-workspace\\selenuim-tutorial\\Udemy-hello\\src\\exceptions\\dog.properties";
		Properties props = new Properties();
		
		FileInputStream fs = new FileInputStream(path);
		props.load(fs);
		System.out.println(props.getProperty("name"));
	}

}
