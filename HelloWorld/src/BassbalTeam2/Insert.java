package BassbalTeam2;

public class Insert {

	public Insert() {
		Singleton sc = Singleton.getinstance();
		System.out.println("*입력항목 : 투수/타자, 선수이름, 선수나이, 키(cm)"); // 항목 출력

		int pos = (int)sc.chkNum("투수/타자(1.투수 2.타자)"); // 15~69 투수
		String name = sc.chkStr("이름");
		int age = (int)sc.chkNum("선수나이");
		double height = sc.chkNum("키(cm)");

		if (pos == 1) { // 1 투수  2 타자
			int win = (int)sc.chkNum("승수");
			int lose = (int)sc.chkNum("패수");
			double defence = sc.chkNum("방어률");
			sc.human.add(new Pitcher(sc.number, name, age, height, win, lose, defence));
		} else {
			int batCounter = (int)sc.chkNum("타수");
			int hit = (int)sc.chkNum("안타수");
			double hitAvg = sc.chkNum("타율");
			sc.human.add(new Batter(sc.number+1000, name, age, height, batCounter, hit, hitAvg));
		}
		sc.number++;
	}

}
