import java.util.ArrayList;

public class ex11_ArrayList {
	public ex11_ArrayList() {
	}
	public static void main(String[] args) {
		/*ArrayList<String> slist = new ArrayList<String>();
		
		slist.add("a");
		slist.add("b");
		slist.add("c");
		for (String s : slist) {
			System.out.print(s);
		}System.out.println();
		slist.add(2,"d");
		for (String s : slist) {
			System.out.print(s);
		}System.out.println();
		int a = slist.size();
		System.out.println(a);
		for (String s : slist) {
			System.out.print(s);
		}System.out.println();
		
		slist.remove(1);
		slist.add(slist.size(), "z");
		
		for (String s : slist) {
			System.out.print(s);
		}System.out.println();
		
		int b = slist.indexOf("c");
		System.out.println(slist.get(b));
		
		slist.set(b, "gv");
		for (String s : slist) {
			System.out.print(s);
		}System.out.println();*/
		
		ArrayList<MyClass> al = new ArrayList<MyClass>();
		al.add(new MyClass(1,"a",1.2));
		al.add(1, new MyClass(1,"c",1.2));
		MyClass bb = new MyClass(2,"b",1.2);
		al.add(1, bb);
		al.remove(bb);
		int a = -1;
		for (MyClass my : al) {
			if(my.getName().equals("c")) {
				System.out.println(my.toString());
				a = al.indexOf(my);
			}
		}
		System.out.println(a);
		
	}
}

class MyClass {
	int number;
	String name;
	double height;
	public MyClass(){}
	public MyClass(int number, String name, double height) {
		this.number = number;
		this.name = name;
		this.height = height;
	}
	@Override
	public String toString() {
		return "MyClass [number=" + number + ", name=" + name + ", height=" + height + "]";
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
}
