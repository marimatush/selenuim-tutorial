package introduction;

public class ReverseString {

	public static void main(String[] args) {
		String input = "Hello, world!";
		
		if (((Object) input).getClass() != String.class) {
			System.out.println("Wrong type");
		}
		
		ReverseString output = new ReverseString();
		
		// Reverse characters
		String reversedCharStr = output.reverseCharWithStringBuilder(input);
		System.out.println("Reversed characters: " + reversedCharStr);
		
		// Reverse words
		String reversedWordsStr = output.reverseString(input);
		System.out.println("Reversed words: " + reversedWordsStr);
	}

	public String reverseCharacters(String input) {
		String output = "";
		
		if (input.isEmpty() || input == null) {
			System.out.println("wrong string");
		}
		
//		for (int i = 0; i < input.length(); i++) {
//			output = input.charAt(i) + output; 
//		}
		
		for (int i = input.length() - 1; i >= 0; i--) {
			output = output + input.charAt(i); 
		}
		
		return output;
	}
	
	public String reverseCharWithStringBuilder(String input) {
		StringBuilder output =  new StringBuilder();
		
		if (input.isEmpty() || input == null) {
			System.out.println("wrong string");
		}
		
		output.append(input);
		output.reverse();
		
		return output.toString();
	}
	
	public String reverseString(String input) {
		String output = "";
		
		if (input.isEmpty() || input == null) {
			System.out.println("String can't be empty");
		}
		
		if (input.length() <= 1) {
			output = input;
		} else {
			String[] wordsInInput = input.split("\\s+");
			
			for (String word: wordsInInput) {
				output = word + " " + output;
			}
		}
		
		return output;
	}
}
