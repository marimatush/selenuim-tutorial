package oop;

public class Dog {
	private String breed;
	private String name;
	private String color;
	private String character;
	
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

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}
}
