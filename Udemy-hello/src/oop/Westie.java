package oop;

public class Westie extends Dog{
	
	public Westie(String gender, String name) {
		super("Westie", gender, "White", name);
	}

	@Override
	public void bark() { 
		System.out.println("Wo wo wo wo wo...");
	}
	
	public void beStubborn() {
		String name = this.getName();
		System.out.println(name + " doesn't want to go for a walk");
	}
	
	public void setAge(int newAge) {
		age = newAge;
	}

}
