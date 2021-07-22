import java.util.ArrayList;

public class MainClass {
	@SuppressWarnings("deprecation")
	public static void main( String[] args ){
//	    Dog aDog = new Dog("Max");
//	    //foo(aDog);//Changes the name
//	    bar(aDog);//Doesn't change the name
//
//		if (aDog.getName().equals("Max")) {
//			System.out.println( "At the end:  Name is Max" );
//		} 
//	    if (aDog.getName().equals("Fifi")) {
//	    	System.out.println( "At the end:  Name is Fifi" );
//	    }
//
//	    int x=5;
//	    int y=x;
		Animal animal = new Animal();
		Bird bird = new Bird();
		Dog dog = new Dog();
		ArrayList<Object> a = new ArrayList<Object>();
		a.add(animal);
		a.add(bird);
		a.add(dog);
		a.add(new Animal());
		a.add(new Integer(5));
		//int x = 5;
		a.add(4);
		//Can only call methods defined on Object
		
		for (Object i : a) {
			System.out.println(i.getClass());
			
		}
	
		
	
		//Write code that will count the number of dogs, birds and other objects.
		//Then:  call the eat function for the dogs and birds.
		int birds = 0;
		int dogs = 0;
		int other = 0;
		
		for(Object i : a) {
				if(i.getClass().toString().equals("class Bird")) {
					birds++;
					Bird b = (Bird)i;
					b.eat();
				}
				if(i.getClass().toString().equals("class Dog")) {
					dogs++;
					Dog d = (Dog)i;
					d.eat();
				}
		}
		System.out.print("Birds: ");
		System.out.println(birds);
		System.out.print("Dogs: ");
		System.out.println(dogs);
		System.out.print("Other: ");
		System.out.println(other);
		
	}

//	public static void foo(Dog d) {
//		if (d.getName().equals("Max")) {
//			System.out.println( "Name is Max" );
//		} 
//		d.setName("Fifi");
//	    if (d.getName().equals("Fifi")) {
//	    	System.out.println( "Name is Fifi" );
//	    }
//	}
//	public static void bar(Dog d) {
//		if (d.getName().equals("Max")) {
//			System.out.println( "Name is Max" );
//		} 
//	    d = new Dog("Fifi");
//	    if (d.getName().equals("Fifi")) {
//	    	System.out.println( "Name is Fifi" );
//	    }
//	}
//	

	
}



//System.out.println(Dog.SIZ);