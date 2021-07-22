package food;
import java.util.Date;
public class Fruit extends Food implements Comparable<Fruit> {
	public Date d;
	public Fruit() {
		d = new Date(0);
		name = "";
	}
	public Fruit(Date id, String iname) {
		d = id;
		name = iname;
	}
	public Fruit(Date id) {
		d = id;
		name = "";
	}
	public Fruit(String iname) {
		d = new Date(0);
		name = iname;
	}

	public void setDate(int da) {
		d = new Date(da);
	}
	public void ripeTime() {
		System.out.println("you can eat it on " + d.toString());
	}
	public int compareTo(Fruit f) {
		return d.compareTo(f.d);
	}
}