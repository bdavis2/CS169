package food;

import java.util.Date;

public class Apple extends Fruit {
	public Apple() {
		super("apple");
	}
	public Apple(Date d, String s) {
		super(d,s);
	}
	public Apple(String s) {
		super(s);
	}
	public Apple(Date d) {
		super(d);
	}
	//Override
	public void prepare() {
		System.out.println("Core the apple");
	}
}
