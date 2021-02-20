package BassbalTeam3;

public class Batter extends HumanDto {

	private int batCounter;
	private int hit;
	private double hitAvg;
	
	public Batter() {
	}

	public Batter(int number, String name, int age, double height, int batCounter, int hit, double hitAvg) {
		super(number, name, age, height);
		this.batCounter = batCounter;
		this.hit = hit;
		this.hitAvg = hitAvg;
	}

	@Override
	public String toString() {
		return "Batter " + super.toString() + ", batCounter=" + batCounter + ", hit=" + hit + ", hitAvg=" + hitAvg + "]";
	}
	
	public String saveString() {
		return "1,"+super.saveString()+ "," + batCounter + "," + hit + "," + hitAvg;
	}
	
	public int getBatCounter() {
		return batCounter;
	}

	public void setBatCounter(int batCounter) {
		this.batCounter = batCounter;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public double getHitAvg() {
		return hitAvg;
	}

	public void setHitAvg(double hitAvg) {
		this.hitAvg = hitAvg;
	}
}
