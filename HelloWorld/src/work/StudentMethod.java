package work;

import java.util.Scanner;

public class StudentMethod {

	public static void main(String[] args) {
		/*이름, 나이, 전화번호, 주소, 내용
		  홍길동, 24, 123-4567, 서울시, 고교동창
		  MENU
		  1. 친구추가
		  2. 친구삭제
		  3. 친구검색
		  4. 친구수정
		  5. 모든데이터 출력
		  6. 종료
		 */
		String Member[][] = new String [100][5];
		String title[] = {"이름", "나이", "전화번호", "주소", "내용"};
		
		while(true) {
			int workNum = printMenu();
			boolean close = false;
			
			switch(workNum) {
				case 1 : insert(Member, title); 	break;
				case 2 : delete(Member); 			break;
				case 3 : search(Member, title); 	break;
				case 4 : modify(Member, title);	 	break;
				case 5 : printAll(Member, title);	break;
				case 6 : close = true;		 		break;
			}
			
			if(close) {
				System.out.println("종료합니다.");
				break;
			}
		}
	}

	static void insert(String[][] member, String[] title) { // 1.친구 입력
		System.out.print("*입력항목 : ");		// 항목 출력
		for (int i = 0; i < title.length; i++) {
			System.out.print(title[i] +" ");
			if(i<title.length-1) {
				System.out.print(", ");
			}
		}System.out.println();
				
		int index = emptyIndex(member); //빈 row 찾기
		for (int i = 0; i < title.length; i++) { //입력받기
			member[index][i] = chkStr(title[i]);
		}
	}
	
	static int emptyIndex(String[][] member) { //빈 row 찾기
		int index = 0;
		for (int i = 0; i < member.length; i++) {
			if(member[i][0]==null || member[i][0].equals("")) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	static void delete(String[][] member) {		// 2.친구삭제
		int index = serIndex(member, "삭제 할 이름"); //이름검색
		rtnMenu(index); //검색 실패시 메뉴이동
		for (int i = 0; i < member[index].length; i++) { //내용 삭제
			member[index][i] = "";
		}System.out.println("삭제되었습니다.");
	}
	
	static void search(String[][] member, String[] title) { // 3.친구검색
		int index = serIndex(member, "찾아야 할 이름"); 	// 이름검색
		rtnMenu(index); //검색 실패시 메뉴이동
		printTitle(title); //항목 출력
		printMember(member, index); //친구 출력
	}
	
	static int serIndex(String[][] member, String str) { // 이름으로 인덱스 검색
		int index = -1;
		int w = 0;
		while(w<3) {	// 기회 3번
			String ser = chkStr(str);	// 입력 확인
			for (int i = 0; i < member.length; i++) { //이름검색
				if(ser.equals(member[i][0])) {
					index = i;
					break;
				}
			}
			if(index>=0) { break; }
			System.out.println("이름을 찾을 수 없습니다.");
			w++;
		}
		return index;
	}
	
	static void modify(String[][] member, String[] title) { // 4.친구수정
		int index = serIndex(member, "수정 할 이름");
		rtnMenu(index); //검색 실패시 메뉴이동
		printTitle(title);  //항목 친구 출력
		printMember(member, index);
		
		int modiNum = chkNum("수정항목 : 1.전화번호, 2.주소");
		switch(modiNum) {
			case 1: 
				member[index][2] = chkStr("수정 할 전화번호");   // 전화번호 수정
				break;
			case 2: 
				member[index][3] = chkStr("수정 할 주소");   // 주소 수정
				break;
			default :
				System.out.println("정확한 입력이 아닙니다.");
				return;
		}
		System.out.println("===================================================================");
		printMember(member, index); //수정 후 확인
		System.out.println("수정되었습니다.");
	}

	static void printAll(String[][] member, String[] title) { // 5.전부출력
		printTitle(title);
		for (int i = 0; i < member.length; i++) {
			if (member[i][0] != null && member[i][0] != "") {
				printMember(member, i);
			}
		}
	}

	static void printMember(String[][] member, int index) { // 1명 출력
		for (int i = 0; i < member[index].length; i++) {
			System.out.print(member[index][i] + "\t");
			if (i>1) {
				System.out.print("\t");
			}
		}
		System.out.println();
	}
	
	static void printTitle(String[] title) { //항목만 출력
		for (int i = 0; i < title.length; i++) {
			System.out.print(title[i] +"\t");
			if (i == 2) {
				System.out.print("\t\t");
			}else if (i==3) {
				System.out.print("\t");
			}
		}
		System.out.println();
	}
	
	static int printMenu() {
		String menu[] = {"1.친구추가", "2.친구삭제", "3.친구검색", "4.친구수정","5.모든데이터출력", "6.종료"};
		
		System.out.println("=========================== M E N U ===============================");
		System.out.print("| ");
		for (int i = 0; i < menu.length; i++) {
			System.out.print(menu[i]+" | ");
		}
		System.out.println();
		System.out.println("===================================================================");
		int workNum = chkNum("입력>>");
		if(workNum < 0) {
			workNum = 6; //강제종료
			System.out.print("입력이 올바르지 않아 프로그램을 ");
		}
		return workNum;
	}
	
	static int chkNum(String msg) { // 숫자 체크
		Scanner sc = new Scanner(System.in);
		String numStr = "";
		boolean b;
		
		int w = 0;
		while(w<3) {
			b = true;
			System.out.print(msg+":");
			numStr = sc.nextLine();
			numStr = numStr.replace(" ", "");  	// 공백제거

			if (numStr.length()==0 || numStr.length()>1 || numStr == null) { //빈 문자 체크
				b=false;
			}else {
				for(int i=0; i<numStr.length(); i++) { //숫자체크
					char c = numStr.charAt(i);
					if(c<49 || c>54) { // 0 48  9 57
						b=false;
						break;
					}
				}
			}
			if (b==true) { break; }
			
			System.out.println("숫자를 정확히 입력해주세요.");
			w++;
		}
		
		if (w==3) { return -1; } //실패시 음수리턴
		return Integer.parseInt(numStr); 
	}

	static String chkStr(String msg) {
		Scanner sc = new Scanner(System.in);
		String str = "";
		int w = 0;
		while(w<2) {
			System.out.print(msg+":");
			str = sc.next();
			str = str.replace(" ", "");  	// 공백제거
			
			if (str.length()==0 || str == null) { // 빈 문자 체크
				System.out.println("문자를 입력해주세요");
				w++;
				continue;
			}
			break;
		}
		return str;
	}
	
	static void rtnMenu(int index) {	//검색실패시 메뉴로 돌아감
		if(index < 0) {
			System.out.println("메뉴화면으로 돌아갑니다.");
			return;
		}
	}

}
/*String a[] = {"홍길동", "24", "123-4567", "서울시", "고교동창"};
String b[] = {"이순신", "30", "145-4534", "강원도", "회사동료"};
String c[] = {"김정호", "30", "145-4534", "충청도", "회사동료"};
for (int i = 0; i < Member[0].length; i++) {
	Member[0][i] = a[i];
	Member[1][i] = b[i];
	Member[2][i] = c[i];}*/