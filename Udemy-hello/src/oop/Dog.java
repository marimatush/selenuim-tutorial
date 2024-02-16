package oop;

public class Dog {
	private String breed;
	private String color;
	private String gender;
	
	// accessible within a package
	String name;
		
	// available anywhere with importing package and class
	public String publicCharactiristic;
	
	// anywhere within the same package
	// available to any sub-class even outside the package
	protected int age;	
	
	public Dog(String breed, String gender, String color, String name) {
		this.breed = breed;
		this.color = color;
		this.gender = gender;
		this.name = name;
	}
	
	public void bark() {
		System.out.println("How how!");
	}
	
	public String getBreed() {
		return this.breed;
	}
	
	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
