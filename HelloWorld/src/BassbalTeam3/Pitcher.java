package BassbalTeam3;

public class Pitcher extends HumanDto {

	private int win;
	private int lose;
	private double defence;
	
	public Pitcher() {
	}

	public Pitcher(int number, String name, int age, double height, int win, int lose, double defence) {
		super(number, name, age, height);
		this.win = win;
		this.lose = lose;
		this.defence = defence;
	}

	@Override
	public String toString() {
		return "Pitcher "+ super.toString() + ", win=" + win + ", lose=" + lose + ", defence=" + defence + "]";
	}
	
	public String saveString() {
		return "0,"+super.saveString()+ "," + win + "," + lose + "," + defence;
	}
	
	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public double getDefence() {
		return defence;
	}

	public void setDefence(double defence) {
		this.defence = defence;
	}
	
}
