package food;
public class Food {
	public String name;
	public Food() {
		name = "";
	}

	public Food(String iname) {
		name = iname;
	}
	public void setName(String iname) {
		name = iname;
	}
	public void prepare() {
		System.out.println("Prepare the " + name);
	}
}
