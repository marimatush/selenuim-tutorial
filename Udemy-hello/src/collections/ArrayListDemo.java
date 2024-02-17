package collections;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		// Default size 10
		ArrayList<String> dogs = new ArrayList<String>();
		dogs.add("husky");
		dogs.add("poodle");
		dogs.add("westie");
		
		// Size
		int size = dogs.size();
		System.out.println("The size of the list is " + size);
		
		// Get element
		System.out.println("Item with index 1 is " + dogs.get(1));
		
		// Iteration
		System.out.println("\nIteration:");
		for(int i = 0; i < size; i++) {
			System.out.println("Item on index " + i + " is " + dogs.get(i));
		}
		
		System.out.println("\nIteration for each:");
		for (String dog: dogs) {
			System.out.println("The dog is: " + dog);
		}
		
		// Remove
		System.out.println("\nAfter removing");
		dogs.remove(size - 1); // remove last item
		for (String dog: dogs) {
			System.out.println("The dog is: " + dog);
		}		
	}

}
