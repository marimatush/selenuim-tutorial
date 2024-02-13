package introduction;
import java.util.Arrays;

public class StringDemo {

	public static void main(String[] args) {
		int[] myIntArray1;
		myIntArray1 = new int[10];
		myIntArray1[0] = 100;
		myIntArray1[1] = 90;
		
		System.out.println("0 index: " + myIntArray1[0]);
		System.out.println("2nd index: " + myIntArray1[2]);
		
		String[] myStringArray1 = {"apple", "orange", "tomato"};
		System.out.println("0 index: " + myStringArray1[0]);
		System.out.println("2nd index: " + myStringArray1[2]);
		
		int len1 = myIntArray1.length;
		int len2 = myStringArray1.length;
		
		System.out.println("Len1: " + len1);
		System.out.println("Len2: " + len2);
		
		Arrays.sort(myIntArray1);
	}

}
