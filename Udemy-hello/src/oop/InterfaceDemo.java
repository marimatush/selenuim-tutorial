package oop;

public class InterfaceDemo implements DogInterface {

	@Override
	public void eat(String food) {
		System.out.println("Eating " + food);
	}

}
