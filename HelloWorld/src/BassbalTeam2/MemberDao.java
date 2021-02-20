package BassbalTeam2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberDao {

	/*private List<HumanDto> human = new ArrayList<HumanDto>();
	private int number;
	
	public MemberDao() { }
	
	public MemberDao(String path) {
		File file = new File(path);
		if(file.exists()) {
			Fileproc ms = new Fileproc();
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
			human.add(new Pitcher(number, name, age, height, win, lose, defence));
		} else {
			int batCounter = (int) chkNum("타수");
			int hit = (int) chkNum("안타수");
			double hitAvg = chkNum("타율");
			human.add(new Batter(number+1000, name, age, height, batCounter, hit, hitAvg));
		}
		number++;
	}
	
	public void delete() {
		int index[] = search();
		if (index[0] < 0) { // 전부 -1, 일치하는게 없는거
			System.out.println("해당 선수를 찾을 수 없습니다.");
			return;
		} else if (index[1] > 0) { // 1번지가 값이 있을때, 최소 2개 이상
			int num = (int) chkNum("몇 번째 선수를 삭제할까요?") - 1;
			int n = index[num];
			human.remove(n);
			System.out.println("삭제가 완료되었습니다.");
			return;
		} // 지나왔다면 값이 1개라는거라서 바로 삭제
		human.remove(index[0]);
		System.out.println("삭제가 완료되었습니다.");
	}
	
	public void select() {
		int index[] = search();
		for (int i = 0; i < index.length; i++) {
			if (index[i] < 0) {
				System.out.println("해당 선수를 찾을 수 없습니다.");
				return;
			}
		}
	}
	
	int[] search() {
		int number = -1;
		String name = "";
		int k = 0; //인덱스 배열의 인덱스
		int index[] = new int[human.size()]; //여러명 검색될 수 있어서 배열사용
		for (int i = 0; i < index.length; i++) { //-1로 초기화
			index[i] = -1;
		}
		int num = (int) chkNum("어떤 항목으로 찾으시겠습니까?\n1.선수번호  2.이름");
		switch (num) {
			case 1:	number=(int)chkNum("선수번호"); break;
			case 2: name  =		chkStr("이름");	  break;
		}
		for (int i = 0; i < human.size(); i++) {
			HumanDto hd = (HumanDto) human.get(i);
			if (hd.getNumber() == number) {
				index[k] = i; k++;
				System.out.println(k + ". " + hd.toString()); // 앞에 라인넘버, 여러명일때 사용하려고
			} else if (hd.getName().equals(name)) {
				index[k] = i; k++;
				System.out.println(k + ". "+hd.toString());
			}
		}
		return index;
	}
	
	public void update() {
		int index[] = search();
		int num = index[0];
		if (index[0] < 0) {
			System.out.println("해당 선수를 찾을 수 없습니다.");
			return;
		} else if (index[1] > 0) { // 1번지가 값이 있을때, 최소 2개 이상
			int n = (int)chkNum("몇 번째 선수를 수정할까요?") - 1; //라인넘버-1이 인덱스번호
			num = index[n];
		}
		if (human.get(num) instanceof Pitcher) {
			int coNum = (int)chkNum("어떤 항목을 수정할까요?\n1.나이 2.방어률");
			switch (coNum) {
			case 1:	int age = (int)chkNum("입력");
					((HumanDto) human.get(num)).setAge(age);
					break;
			case 2: double defence = chkNum("입력");
					((Pitcher)human.get(num)).setDefence(defence);
					break;
			}
		} else if (human.get(num) instanceof Batter) {
			int coNum = (int)chkNum("어떤 항목을 수정할까요?\n1.나이 2.타율");
			switch (coNum) {
			case 1: int age = (int)chkNum("입력");
					((HumanDto) human.get(num)).setAge(age);
					break;
			case 2: double hitAvg = chkNum("입력");
					((Batter)human.get(num)).setHitAvg(hitAvg);
					break;
			}
		}
		System.out.println("수정되었습니다.");
	}
	
	public void printAll() {
		for (int i = 0; i < human.size(); i++) {
			HumanDto hd = (HumanDto) human.get(i);
			System.out.println(hd.toString());
		}
	}
	
	public void save() {
		Fileproc ms = new Fileproc();
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
			case 1 : 
				for (int i = 0; i < human.size()-1; i++) {
					for (int j = i+1; j < human.size(); j++) {
						if (human.get(i) instanceof Pitcher && human.get(j) instanceof Pitcher) {
							double a = ((Pitcher) human.get(i)).getDefence();
							double b = ((Pitcher) human.get(j)).getDefence();
							if (a < b) {swap(i, j);} //내림차순
						}
					}
				}
				for (int i = 0; i < human.size(); i++) {
					if (human.get(i) instanceof Pitcher) {
						System.out.println(human.get(i).toString());
					}
				} break;
			case 2 : 
				for (int i = 0; i < human.size()-1; i++) {
					for (int j = i+1; j < human.size(); j++) {
						if (human.get(i) instanceof Batter && human.get(j) instanceof Batter) {
							double a = ((Batter) human.get(i)).getHitAvg();
							double b = ((Batter) human.get(j)).getHitAvg();
							if (a < b) {swap(i, j);}
						}
					}
				}
				for (int i = 0; i < human.size(); i++) {
					if (human.get(i) instanceof Batter) {
						System.out.println(human.get(i).toString());
					}
				} break;
		}
	}
	
	void swap(int i, int j) {
		HumanDto tmp;
		HumanDto a = (HumanDto) human.get(i);
		HumanDto b = (HumanDto) human.get(j);
		tmp = a;
		human.remove(i);
		human.add(i, b); //a = b;
		human.remove(j);
		human.add(j, tmp); //b = tmp;
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
	*/
}
