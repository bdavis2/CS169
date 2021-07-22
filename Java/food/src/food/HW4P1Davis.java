package food;

import java.util.ArrayList;
import java.util.Date;

public class HW4P1Davis {
	public static  ArrayList<Object> makeList(ArrayList<Object> stuff) {

		ArrayList<Object> ret = new ArrayList<Object>();
		Date temp_date = new Date(0); // temp date initialized to epoch
		String temp_name = "";
		for (int i = 0; i < stuff.size(); i++) {
			if(checkObj(stuff.get(i))) { 
				for(int j = i + 1; j < stuff.size() && j < i + 3; j++) {
					if(checkObj(stuff.get(j))) break;
					else if(stuff.get(j) instanceof Integer) temp_date = new Date((int) stuff.get(j));
					else if(stuff.get(j).equals("now")) temp_date = new Date();
					else temp_name = (String) stuff.get(j);
				}
				ret.add(createObj((String) stuff.get(i), temp_date, temp_name));
			}
			//re-initializes variables
			temp_date = new Date(0);
			temp_name = "";
		}
		return ret;
	}
	// this helper method determines if a string is of one of the object types
	public static boolean checkObj(Object o) {
		String[] types = {"Food", "Fruit", "Apple", "Orange"};
		for(Object i : types) {
			if(o.equals(i)) return true;
		}
		return false;
	}
	// helper function that creates an object with desired parameters
	public static Object createObj(String type, Date d, String name) {
		if(type.equals("Orange")) {
			System.out.println("A new " + type + " has been created with date: " + d.toString() + " and name: " + name);
			return new Orange(d, name);
		}
		if(type.equals("Apple")) {
			System.out.println("A new " + type + " has been created with date: " + d.toString() + " and name: " + name);
			return new Apple(d, name);
		}
		if(type.equals("Fruit")) {
			System.out.println("A new " + type + " has been created with date: " + d.toString() + " and name: " + name);
			return new Fruit(d, name);
		}
		// else, type == "Food"
		System.out.println("A new " + type + " has been created with name: " + name);
		return new Food(name);
	}
	 @SuppressWarnings("deprecation")
	public static void main(String args[]){ 
		 ArrayList<Object> test = new ArrayList<Object>();
		 System.out.println(new Date());
		 test.add(new String("Food"));
		 test.add(new String("Orange"));
		 test.add(new String("Fruit"));
		 test.add(new String("Papaya"));
		 test.add(new Integer(3932558));
		 test.add(new String("Apple"));
		 test.add(new String("Food"));
		 test.add(new String("sandwich"));
		 ArrayList<Object> the = makeList(test);
		 System.out.println(the.toString());
	 }
}
