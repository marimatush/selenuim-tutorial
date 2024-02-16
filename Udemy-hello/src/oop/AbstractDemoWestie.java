package oop;

public class AbstractDemoWestie extends AbstractDog {
	public AbstractDemoWestie() {
		super("westie");
	}
	
	public void bark() {
		super.bark();
		System.out.println("pfff");
	}

	@Override
	public void play(String toy) {
		System.out.println("Playing with " + toy);	
	}

}
