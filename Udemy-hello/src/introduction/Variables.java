package introduction;

public class Variables {

	public static void main(String[] args) {
		byte myByte = 100;
		System.out.println("Byte Value " + myByte);
		System.out.println(((Object) myByte).getClass().getSimpleName());
		
		short myShort = 1001;
		System.out.println("Short Value: " + myShort);
		System.out.println(((Object) myShort).getClass().getSimpleName());
		
		int myInt = 100001;
		System.out.println("Int value: " + myInt);
		System.out.println(((Object) myInt).getClass().getSimpleName());
		
		long myLong = 100010020202002L;
		System.out.println("Long value: " + myLong);
		System.out.println(((Object) myLong).getClass().getSimpleName());
		
		float myFloat = 12.1f;
		System.out.println("Float value: " + myFloat);
		System.out.println(((Object) myFloat).getClass().getSimpleName());
		
		double myDouble = 60.33;
		System.out.println("Double value: " + myDouble);
		System.out.println(((Object) myDouble).getClass().getSimpleName());
		
		boolean myBool = true;
		System.out.println("Boolean value: " + myBool);
		System.out.println(((Object) myBool).getClass().getSimpleName());
		
		char myChar = 1004;
		System.out.println("Char value: " + myChar);
		System.out.println(((Object) myChar).getClass().getSimpleName());
	}

}
