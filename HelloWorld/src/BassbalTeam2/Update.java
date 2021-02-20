package BassbalTeam2;

public class Update {

	public Update() {
		Singleton sc = Singleton.getinstance();
		sc.search();
		int num = sc.index[0];
		if (sc.index[0] < 0) {
			System.out.println("해당 선수를 찾을 수 없습니다.");
			return;
		} else if (sc.index[1] > 0) { // 1번지가 값이 있을때, 최소 2개 이상
			int n = (int)sc.chkNum("몇 번째 선수를 수정할까요?") - 1; //라인넘버-1이 인덱스번호
			num = sc.index[n];
		}
		if (sc.human.get(num) instanceof Pitcher) {
			int coNum = (int)sc.chkNum("어떤 항목을 수정할까요?\n1.나이 2.방어률");
			switch (coNum) {
			case 1:	int age = (int)sc.chkNum("입력");
					((HumanDto) sc.human.get(num)).setAge(age);
					break;
			case 2: double defence = sc.chkNum("입력");
					((Pitcher)sc.human.get(num)).setDefence(defence);
					break;
			}
		} else if (sc.human.get(num) instanceof Batter) {
			int coNum = (int)sc.chkNum("어떤 항목을 수정할까요?\n1.나이 2.타율");
			switch (coNum) {
			case 1: int age = (int)sc.chkNum("입력");
					((HumanDto) sc.human.get(num)).setAge(age);
					break;
			case 2: double hitAvg = sc.chkNum("입력");
					((Batter)sc.human.get(num)).setHitAvg(hitAvg);
					break;
			}
		}
		System.out.println("수정되었습니다.");
	}

}
