package BassbalTeam3;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MemberDao {

	private Map<Integer, HumanDto> human = new HashMap<Integer, HumanDto>();
	private int number;

	public MemberDao() { }
	
	public MemberDao(String path) {
		File file = new File(path);
		if(file.exists()) {
			MemberSave ms = new MemberSave();
			number = ms.readfile(file, human)+1;
		}else number = 1001;
	}

	public void insert() {
		System.out.println("*입력항목 : 투수/타자, 선수이름, 선수나이, 키(cm)"); // 항목 출력

		int pos = (int)chkNum("투수/타자(1.투수 2.타자)"); // 15~69 투수
		String name = chkStr("이름");
		int age = (int)chkNum("선수나이");
		double height = chkNum("키(cm)");

		if (pos == 1) { // 1 투수  2 타자
			int win = (int)chkNum("승수");
			int lose = (int)chkNum("패수");
			double defence = chkNum("방어률");
			human.put(number, new Pitcher(number, name, age, height, win, lose, defence));
		} else {
			int batCounter = (int) chkNum("타수");
			int hit = (int) chkNum("안타수");
			double hitAvg = chkNum("타율");
			human.put(number+1000, new Batter(number+1000, name, age, height, batCounter, hit, hitAvg));
		}
		number++;
	}

	public void delete() {
		int key[] = search();
		if (key[0] < 0) { // 전부 -1, 일치하는게 없는거
			System.out.println("해당 선수를 찾을 수 없습니다.");
			return;
		} else if (key[1] > 0) { // 1번지가 값이 있을때, 최소 2개 이상
			int num = (int) chkNum("몇 번째 선수를 삭제할까요?") - 1;
			int n = key[num];
			HumanDto h = human.remove(n);
			System.out.println(h.getName()+"선수의 삭제가 완료되었습니다.");
			return;
		} // 지나왔다면 값이 1개라는거라서 바로 삭제
		HumanDto h = human.remove(key[0]);
		System.out.println(h.getName()+"선수의 삭제가 완료되었습니다.");
	}

	public void select() {
		int key[] = search();
		for (int i = 0; i < key.length; i++) {
			if (key[i] < 0) {
				System.out.println("해당 선수를 찾을 수 없습니다.");
				return;
			}
		}
	}

	int[] search() {
		int number = -1;
		String name = "";
		
		int w = 0; //인덱스 배열의 인덱스
		int key[] = new int[human.size()]; //여러명 검색될 수 있어서 배열사용
		for (int i = 0; i < key.length; i++) { //-1로 초기화
			key[i] = -1;
		}
		int num = (int) chkNum("어떤 항목으로 찾으시겠습니까?\n1.선수번호  2.이름");
		switch (num) {
			case 1:	number=(int)chkNum("선수번호"); break;
			case 2: name  =		chkStr("이름");	  break;
		}
		
		Iterator<Integer> it = human.keySet().iterator(); // 모든 키(주소값)를 가져옴 
		while(it.hasNext()) {
			int k = it.next();
			HumanDto h= human.get(key);
			if (h.getNumber() == number) {
				key[k] = k; w++;
				System.out.println(w + ". " + h.toString()); // 앞에 라인넘버, 여러명일때 사용하려고
			} else if (h.getName().equals(name)) {
				key[k] = k; w++;
				System.out.println(w + ". "+h.toString());
			}
		 }
		return key;
	}

	public void update() {
		int key[] = search();
		int k = key[0];
		if (key[0] < 0) {
			System.out.println("해당 선수를 찾을 수 없습니다.");
			return;
		} else if (key[1] > 0) { // 1번지가 값이 있을때, 최소 2개 이상
			int n = (int)chkNum("몇 번째 선수를 수정할까요?") - 1; //라인넘버-1이 인덱스번호
			k = key[n];
		}
		HumanDto h = human.get(k);
		if (h instanceof Pitcher) {
			int coNum = (int)chkNum("어떤 항목을 수정할까요?\n1.나이 2.방어률");
			switch (coNum) {
			case 1:	int age = (int)chkNum("입력");
					human.get(k).setAge(age);
					break;
			case 2: double defence = chkNum("입력");
					((Pitcher) human.get(k)).setDefence(defence);
					break;
			}
		} else if (h instanceof Batter) {
			int coNum = (int)chkNum("어떤 항목을 수정할까요?\n1.나이 2.타율");
			switch (coNum) {
			case 1: int age = (int)chkNum("입력");
					human.get(k).setAge(age);
					break;
			case 2: double hitAvg = chkNum("입력");
					((Batter)human.get(k)).setHitAvg(hitAvg);
					break;
			}
		}
		System.out.println("수정되었습니다.");
	}

	public void printAll() {
		Map<Integer, HumanDto> sortm = new TreeMap<Integer, HumanDto>();
		Iterator<Integer> it = human.keySet().iterator();
		while(it.hasNext()) {
			int key = it.next();
			HumanDto h = human.get(it.next());
			if(key>2000) { key-=1000; }
			sortm.put(key, h);
		}
		
		it = sortm.keySet().iterator();
		while(it.hasNext()) {
			System.out.println( sortm.get(it.next()).toString()  );
		}
		
	}

	public void save() {
		MemberSave ms = new MemberSave();
		ms.clearfile(); // 저장 전 파일 초기화
		for (int i = 0; i < human.size(); i++) {
			if (human.get(i) instanceof Pitcher) {
				String text = ((Pitcher) human.get(i)).saveString();
				ms.writefile(text);
			} else if (human.get(i) instanceof Pitcher) {
				String text = ((Pitcher) human.get(i)).saveString();
				ms.writefile(text);
			}
		}System.out.println("저장되었습니다.");
	}
	
	public void sorting() {
		int num = (int)chkNum("어떤 항목으로 정렬할까요?(1.투수방어율 2.타자타율)");
		switch(num) {
			case 1 : defencerank(); break;
			case 2 : hitrank(); break;
		}
	}

	void defencerank() {
		Map<String, HumanDto> sm = new TreeMap<String, HumanDto>();
		
		Iterator<Integer> it = human.keySet().iterator();
		while(it.hasNext()) {
			HumanDto h = human.get(it.next());
			if (h instanceof Pitcher) {
				String key = ((Pitcher) h).getDefence() + "";
				HumanDto c = sm.get(key);
				if(c != null) {	key = key + "1"; }
				sm.put(key, h);
			}
		}
		
		Iterator<String> its = sm.keySet().iterator();
		while(it.hasNext()) {
			System.out.println( sm.get(it.next()).toString() );
		}
	}

	void hitrank() {
		Map<String, HumanDto> sm = new TreeMap<String, HumanDto>();
		
		Iterator<Integer> it = human.keySet().iterator();
		while(it.hasNext()) {
			HumanDto h = human.get(it.next());
			if (h instanceof Batter) {
				String key = ((Batter) h).getHitAvg() + "";
				HumanDto c = sm.get(key);
				if(c != null) {	key = key + "1"; }
				sm.put(key, h);
			}
		}
		
		Iterator<String> its = sm.keySet().iterator();
		while(it.hasNext()) {
			System.out.println( sm.get(it.next()).toString() );
		}
	}
	
	public int printMenu() { // 추가 삭제 검색 수정, 출력, 저장, 정렬, 종료
		System.out.println("========================== M E N U =====================================");
		System.out.println("| 1.선수추가  2.선수삭제  3.선수검색  4.선수수정  5.선수출력  6.저장  7.정렬  8.종료 |");
		System.out.println("========================================================================");
		int workNum = (int) chkNum("입력");
		if (workNum < 0) {
			workNum = 8; // 강제종료
			System.out.print("입력이 올바르지 않아 프로그램을 ");
		}
		return workNum;
	}

	double chkNum(String msg) { // 숫자 체크
		Scanner sc = new Scanner(System.in);
		String numStr = "";
		boolean b;
		int w = 0;
		while (w < 5) {
			b = true;
			System.out.print(msg + ":");
			numStr = sc.nextLine();
			numStr = numStr.replace(" ", ""); // 공백제거
			if (numStr.length()==0 || numStr == null) { //빈 문자일때
				numStr = "0";
			}
			else {
				for (int i = 0; i < numStr.length(); i++) { // 숫자체크
					char c = numStr.charAt(i);
					if (c < 46 || c > 57 || c == 47) { // 0=48, 9=57 .=46
						b = false;
						break;
					}
				}
			}
			if (b == true) {break;}
			System.out.println("숫자를 정확히 입력해주세요.");
			w++;
		}
		if (w == 5) {return -1;} // 실패시 음수리턴
		return Double.parseDouble(numStr);
	}

	String chkStr(String msg) {
		Scanner sc = new Scanner(System.in);
		String str = "";
		int w = 0;
		while (w < 5) {
			System.out.print(msg + ":");
			str = sc.nextLine();
			str = str.replace(" ", ""); // 공백제거
			if (str.length() == 0 || str.equals(null)) { // 빈 문자 체크
				System.out.println("문자를 입력해주세요");
				w++;
				continue;
			}
			break;
		}
		return str;
	}

}
