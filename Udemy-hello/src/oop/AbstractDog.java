package oop;

public abstract class AbstractDog {
	private String breed;
	protected int age;
	public String Name;

	public AbstractDog(String breed) {
		this.breed = breed;
	}

	public void bark() {
		System.out.println("wo wow owo wo");
	}

	public abstract void play(String toy);
}
