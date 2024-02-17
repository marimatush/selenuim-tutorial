package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetsDemo {

	public static void main(String[] args) {
		// Sets
		
		// HashSet does not maintain order
		Set<String> set = new HashSet<String>();
		set.add("beagle");
		set.add("husky");
		set.add("terrier");
		set.add("husky");
		set.add("sheperd");
		System.out.println("HasSet is: " + set);
		
		for (String item: set) {
			System.out.println("HashSet items is: " + item);
		}
		
		// LinkedHashSet maintains the order in which elements were added
		Set<String> lhSet = new LinkedHashSet<String>();
		lhSet.add("beagle");
		lhSet.add("husky");
		lhSet.add("terrier");
		lhSet.add("husky");
		lhSet.add("sheperd");
		System.out.println("\nLinkedHashSet is: " + lhSet);
		
		for (String item: lhSet) {
			System.out.println("LinkedHashSet item is: " + item);
		}
		
		// Tree set - maintains natural order: 1, 2, 3, .... a, b, c, ....
		Set<String> tSet = new TreeSet<String>();
		tSet.add("beagle");
		tSet.add("husky");
		tSet.add("terrier");
		tSet.add("husky");
		tSet.add("sheperd");
		System.out.println("\nTreeSet is: " + tSet);
		
		for (String item: tSet) {
			System.out.println("TreeSet item is: " + item);
		}
	}
}
