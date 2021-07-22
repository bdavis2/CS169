package food;

import java.util.Date;

public class Orange extends Fruit {
	public Orange() {
		super("orange");
	}
	public Orange(Date d, String s) {
		super(d,s);
	}
	public Orange(String s) {
		super(s);
	}
	public Orange(Date d) {
		super(d);
	}
	//Override
	public void prepare() {
		System.out.println("Peel the Orange");
	}
}
