package Singleton;

public class Sigletonleton {

	private static Sigletonleton sc=null;
	public int sNum;
	public String sName;
	
	private Sigletonleton() {
		// TODO Auto-generated constructor stub
	}
	
	public static Sigletonleton getintance() {
		if(sc==null) {
			sc = new Sigletonleton();
		}
		return sc;
	}

}
