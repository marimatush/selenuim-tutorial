package oop;

public class InterfaceDemo1 {

	public static void main(String[] args) {
		DogInterface doggo = new DogInterface() {

			@Override
			public void eat(String food) {
				System.out.println("Picking stuff from the street");
			}
		};

		doggo.eat("chicken");

	}
}
