package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 * Array List - {1, 2, 3, 4, ...}
 * Linked List - [0] <> [1] <> [2] ... => elements point to each other
 * 
 * Use ArrayList when add/remove to/from the end
 * Use LinkedList when add/remove to/from the beginning
 */
public class LinkListDemo {

	public static void main(String[] args) {
		// Default size 10
		LinkedList<String> dogs = new LinkedList<String>();
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
		for (int i = 0; i < size; i++) {
			System.out.println("Item on index " + i + " is " + dogs.get(i));
		}

		System.out.println("\nIteration for each:");
		for (String dog : dogs) {
			System.out.println("The dog is: " + dog);
		}

		// Remove
		System.out.println("\nAfter removing");
		dogs.remove(size - 1); // remove last item
		for (String dog : dogs) {
			System.out.println("The dog is: " + dog);
		}
		
			
		// We can initialize both with List
		List<Integer> lList = new LinkedList<Integer>();
		List<Integer> aList = new ArrayList<Integer>();
		
		// Run duration
		runDuration(aList, ((Object) aList).getClass().getSimpleName());
		runDuration(lList, ((Object) lList).getClass().getSimpleName());
	}
	
	public static void runDuration(List<Integer> list, String listType) {
		System.out.println("\nBeginning of the duration for " + listType);
		
		/***
		 * Beginning of the duration for ArrayList
		 * Duration of the ArrayList is 2 ms
		 * Beginning of the duration for LinkedList
		 * Duration of the LinkedList is 1 ms
		 */
		for (int i = 0; i < 10000; i++) {
			list.add(i);
		}
		
		/***
		 * Adding more elements to the end:
		 * Beginning of the duration for ArrayList
		 * Duration of the ArrayList is 3 ms	
		 * Beginning of the duration for LinkedList
		 * Duration of the LinkedList is 7 ms
		 */
		int size = list.size();
		int elementsToAdd = size + 20000;
		for (int i = size; i < elementsToAdd; i++) {
			list.add(i);
		}
		
		/***
		 * Adding elements to the beginning of the list
		 * Beginning of the duration for ArrayList
         * Duration of the ArrayList is 92 ms
         * Beginning of the duration for LinkedList
         * Duration of the LinkedList is 4 ms
		 */
		
		int sizeUpd = list.size();
		int moreElementsToAdd = sizeUpd + 20000;
		
		for (int i = sizeUpd; i < moreElementsToAdd; i++) {
			list.add(0, i);
		}
		
		/***
		 * Remove elements from the END:
		 * Beginning of the duration for ArrayList
		 * Duration of the ArrayList is 17 ms
		 * Beginning of the duration for LinkedList
		 * Duration of the LinkedList is 259 ms
		 */
		for (int i = 20000; i < 25000; i++) {
			list.remove(i); // remove from the end
		}
		
		/***
		 * Remove elements from the BEGINNING:
		 * Beginning of the duration for ArrayList
		 * Duration of the ArrayList is 5 ms
		 * Beginning of the duration for LinkedList
		 * Duration of the LinkedList is 1 ms
		 */
		Long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			list.remove(i); // remove from the beginning
		}
		Long endTime = System.currentTimeMillis();
		
		Long durarion = endTime - startTime;
		System.out.println("Duration of the " + listType + " is " + durarion + " ms");
	}
}
