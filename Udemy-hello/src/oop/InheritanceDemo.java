package oop;

public class InheritanceDemo {

	public static void main(String[] args) {
		Dog Bluey = new Dog("Husky", "Female", "Blue", "Bluey");
		Bluey.bark();
		
		Westie Leeloo = new Westie("Female", "Leeloo");
		Leeloo.bark();
		Leeloo.beStubborn();
	}

}
