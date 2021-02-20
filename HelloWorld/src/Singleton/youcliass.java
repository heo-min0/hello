package Singleton;

public class youcliass {

	int num;
	
	public youcliass() {
		
	}

	public void print() {
		num = Sigletonleton.getintance().sNum;
		System.out.println("num = " + num);
	}
}
