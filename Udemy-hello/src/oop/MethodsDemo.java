package oop;

public class MethodsDemo {

	public static void main(String[] args) {
		String myGrade = findGrade(97);
		displaySomething("Leeloo", myGrade);
	}
	
	public static String findGrade(int score) {		
		String grade;
		if (score > 80 ) {
			grade = "A";
		} else {
			grade = "B";
		}
		
		return grade;
	}
	
	public static void displaySomething(String studentName, String grade) {
		System.out.println("Grade of " + studentName + " is " + grade);
	}
}
