package BassbalTeam2;

public class Select {
	Singleton sc = Singleton.getinstance();

	public Select() {
		search();
		for (int i = 0; i < sc.index.length; i++) {
			if (sc.index[i] < 0) {
				System.out.println("해당 선수를 찾을 수 없습니다.");
				return;
			}
		}
	}
	
	void search() {
		int number = -1;
		String name = "";
		int k = 0; //인덱스 배열의 인덱스
		sc.index = new int[sc.human.size()]; //여러명 검색될 수 있어서 배열사용
		for (int i = 0; i < sc.index.length; i++) { //-1로 초기화
			sc.index[i] = -1;
		}
		int num = (int)sc.chkNum("어떤 항목으로 찾으시겠습니까?\n1.선수번호  2.이름");
		switch (num) {
			case 1:	number=(int)sc.chkNum("선수번호"); break;
			case 2: name  =		sc.chkStr("이름");	  break;
		}
		for (int i = 0; i < sc.human.size(); i++) {
			HumanDto hd = (HumanDto) sc.human.get(i);
			if (hd.getNumber() == number) {
				sc.index[k] = i; k++;
				System.out.println(k + ". " + hd.toString()); // 앞에 라인넘버, 여러명일때 사용하려고
			} else if (hd.getName().equals(name)) {
				sc.index[k] = i; k++;
				System.out.println(k + ". "+hd.toString());
			}
		}
	}
}
