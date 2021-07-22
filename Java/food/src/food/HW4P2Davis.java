package food;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class HW4P2Davis {
	
	public static void printFruits(ArrayList<Fruit> fruits) {
		for(Fruit i : fruits) {
			System.out.println("Fruit " + i.name + " with Date " + i.d);
		}
	}
	
	public static void main(String args[]) {
		ArrayList<Fruit> fruits = new ArrayList<Fruit>();
		fruits.add(new Fruit(new Date(), "A"));
		fruits.add(new Fruit(new Date(156817896), "B"));
		fruits.add(new Fruit(new Date(0), "C"));
		fruits.add(new Fruit(new Date(56165), "D"));
		fruits.add(new Fruit(new Date(78853434), "E"));
		fruits.add(new Fruit(new Date(919177), "F"));
		fruits.add(new Fruit(new Date(3455), "G"));
		printFruits(fruits);
		Collections.sort(fruits);
		System.out.println();
		printFruits(fruits);
	}
}
