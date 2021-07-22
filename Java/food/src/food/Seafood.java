package food;
public class Seafood extends Food {
	public Seafood() {
		super("Seafood");
	}
	public Seafood(String s) {
		super(s);
	}
	
	//override
	public void prepare() {
		System.out.println("Peel the " + name);
	}
}
