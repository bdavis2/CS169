
public class Dog extends Animal {
	
	private String name;
	public Dog(){
		name = "dog";
		System.out.println("A new dog has been created!");
	}
	public Dog(String iname) {
		name = iname;
		System.out.println("A new dog has been created!");
	}
	public void setName(String nname) {
		name = nname;
	}
	public String getName(){
		return name;
	}
	//Override
	public void sleep() {
		System.out.println("A dog sleeps..."+name);
	}
	
	//Override
	public void eat() {
		System.out.println("A dog eats..."+name);
	}
	
	public void bark(){
		System.out.println("Woof!  Woof!");
	}
}