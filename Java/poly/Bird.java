public class Bird extends Animal {//extends keyword instead of :, no modifier at child class' level
	public Bird() {//Default:  call parent's default constructor
		System.out.println("A new bird has been created!");
	}
	public Bird(String n) {
		super(n);
		System.out.println("A new bird has been created!");
	}

	//Override
	public void sleep() {
		super.sleep();
		System.out.println("A bird sleeps..."+name);
	}
	
	//Override
	public void eat() {
		System.out.println("A bird eats..."+name);
	}
}
