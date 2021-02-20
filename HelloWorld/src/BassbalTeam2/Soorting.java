package BassbalTeam2;

public class Soorting {
	Singleton sc = Singleton.getinstance();
	public Soorting() {
		int num = (int)sc.chkNum("어떤 항목으로 정렬할까요?(1.투수방어율 2.타자타율)");
		switch(num) {
			case 1 : 
				for (int i = 0; i < sc.human.size()-1; i++) {
					for (int j = i+1; j < sc.human.size(); j++) {
						if (sc.human.get(i) instanceof Pitcher && sc.human.get(j) instanceof Pitcher) {
							double a = ((Pitcher) sc.human.get(i)).getDefence();
							double b = ((Pitcher) sc.human.get(j)).getDefence();
							if (a < b) {swap(i, j);} //내림차순
						}
					}
				}
				for (int i = 0; i < sc.human.size(); i++) {
					if (sc.human.get(i) instanceof Pitcher) {
						System.out.println(sc.human.get(i).toString());
					}
				} break;
			case 2 : 
				for (int i = 0; i < sc.human.size()-1; i++) {
					for (int j = i+1; j < sc.human.size(); j++) {
						if (sc.human.get(i) instanceof Batter && sc.human.get(j) instanceof Batter) {
							double a = ((Batter) sc.human.get(i)).getHitAvg();
							double b = ((Batter) sc.human.get(j)).getHitAvg();
							if (a < b) {swap(i, j);}
						}
					}
				}
				for (int i = 0; i < sc.human.size(); i++) {
					if (sc.human.get(i) instanceof Batter) {
						System.out.println(sc.human.get(i).toString());
					}
				} break;
		}
		sort();
	}

	void swap(int i, int j) {
		HumanDto tmp;
		HumanDto a = (HumanDto) sc.human.get(i);
		HumanDto b = (HumanDto) sc.human.get(j);
		tmp = a;
		sc.human.remove(i);
		sc.human.add(i, b); //a = b;
		sc.human.remove(j);
		sc.human.add(j, tmp); //b = tmp;
	}
	
	void sort(){
		for (int i = 0; i < sc.human.size()-1; i++) {
			for (int j = i+1; j < sc.human.size(); j++) {
				int a = sc.human.get(i).getNumber();
				int b = sc.human.get(j).getNumber();
				if(a>=2000) {a-=1000;}
				if(b>=2000) {b-=1000;}
				if (a > b) {swap(i, j);} //내림차순
			}
		}
	}
}
