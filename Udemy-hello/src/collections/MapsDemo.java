package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapsDemo {

	public static void main(String[] args) {
		maps();
		mapsIterations();
		mapTypes();
	}

	public static void maps() {
		// Stores in key -> value pair : Entry
		// keys are unique
		// values can be duplicated
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "husky");
		map.put(7, "westie");
		map.put(10, "poodle");
		
		// prints "husky"
		String value1 = map.get(1);
		System.out.println(value1);

		// prints "null"
		String value2 = map.get(2);
		System.out.println(value2);
		
		// prints "westie"
		map.put(2, "westie");
		String value3 = map.get(2);
		System.out.println(value3);
		
		// unique key -> overrides the existing one
		// prints "boxer"
		map.put(2, "boxer");
		String value4 = map.get(2);
		System.out.println(value4);
	}
	
	public static void mapsIterations() {
		// HashMap does not maintain order
		// allows one null key
		// it is fast -> use if you don't care about the order
		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		
		hashMap.put(1, "husky");
		hashMap.put(7, "westie");
		hashMap.put(10, "poodle");
		hashMap.put(5, "poodle");
		
		System.out.println("\nIterate over the entries");
		for (Map.Entry<Integer, String> entry: hashMap.entrySet()) {
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println("Key: " + key + " value: " + value);
		}
		
		System.out.println("\nIterate over the keys");
		for (Integer key: hashMap.keySet()) {
			String value = hashMap.get(key);
			System.out.println("Key: " + key + " value: " + value);
		}
	}
	
	public static void mapTypes() {
		// Maintains the order they are added
		System.out.println("\nLinked hash maps");
		Map<Integer, String> lMap = new LinkedHashMap<Integer, String>();
		lMap.put(1, "husky");
		lMap.put(7, "westie");
		lMap.put(10, "poodle");
		lMap.put(5, "poodle");
		
		for (Map.Entry<Integer, String> entry: lMap.entrySet()) {
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println("Key: " + key + " value: " + value);
		}
		
		// Maintains natural order
		System.out.println("\nTree maps");
		Map<Integer, String> tMap = new TreeMap<Integer, String>();
		tMap.put(1, "husky");
		tMap.put(7, "westie");
		tMap.put(10, "poodle");
		tMap.put(5, "poodle");
		
		for (Map.Entry<Integer, String> entry: tMap.entrySet()) {
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println("Key: " + key + " value: " + value);
		}
	}
}
