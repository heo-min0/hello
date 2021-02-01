package AccountBook;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Book {
	//private AccountDto ac[] = new AccountDto[50];
	private ArrayList<AccountDto> ac = new ArrayList<AccountDto>();
	
	public Book() {
		ac.add(new AccountDto("2021-01-24", "식비", "지출", 12000, "점심식사"));
		ac.add(new AccountDto("2021-01-25", "교통비", "지출", 7000, "택시비"));
		ac.add(new AccountDto("2021-01-26", "기타", "지출", 10000, "쇼핑"));
		ac.add(new AccountDto("2021-01-27", "월급", "수입", 100000, "월급"));
		loop();
	}
	
	public void loop() {
		while(true) {
			int workNum = printMenu();
			boolean close = false;

			switch(workNum) {
				case 1 : insert(); 	break;
				case 2 : delete(); 	break;
				case 3 : search(); 	break;
				case 4 : modify();	 	break;
				case 5 : printAll();	break;
				case 6 : close = true;	break;
			}
			if(close) {
				System.out.println("종료합니다.");
				break;
			}
		}
	}

	void insert() {
		System.out.println("*입력항목 : 용도(ex.쇼핑), 분류(수입/지출), 금액, 내용");		// 항목 출력
				
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
		String date = day.format(Calendar.getInstance().getTime());
		String use = chkStr("용도");
		String classify = chkStr("분류");
		int money = chkNum("금액");
		String memo = chkStr("내용");
		
		ac.add(ac.size(), new AccountDto(date, use, classify, money, memo));
	}
	
	void delete() {
		int index[] = serIndex(); 	// 이름검색
		if(index[0]<0) { return; }; //검색 실패시 메뉴이동
		serPrint(index);
		int num = chkNum("삭제할 항목번호");
		
		ac.remove(index[num-1]);
		System.out.println("삭제되었습니다.");
	}
	
	void search() {
		int index[] = serIndex(); 	// 이름검색
		if(index[0]<0) { return; }; //검색 실패시 메뉴이동
		serPrint(index);
	}
	
	int[] serIndex() { // 이름으로 인덱스 검색
		int index[] = new int[ac.size()];
		for (int i = 0; i < index.length; i++) {
			index[i] = -1;
		}
		
		int k, w, i, num;
		k = w = i = num = 0;
		while(w<3) {
			num = chkNum("검색항목(1.날짜, 2.분류)");
			if (num==1 || num==2) { break; }
			System.out.println("숫자를 다시 입력해주세요");
			w++;
		}
		if (w==3) {
			System.out.println("메뉴화면으로 돌아갑니다.");
			return index;
		}
		
		while(w<3) {	// 기회 3번
			String ser = chkStr("해당내용");	// 입력 확인
			if(num==1) {
				for (int j = 0; j < ac.size(); j++) {
					AccountDto a = ac.get(j);
					if(a.getDate().equals(ser)) {
						index[k] = j;
						k++;
					}
				}
			}
			else if(num==2) {
				for (int j = 0; j < ac.size(); j++) {
					AccountDto a = ac.get(j);
					if(a.getClassify().equals(ser)) {
						index[k] = j;
						k++;
					}
				}
			}
			if(index[0] > -1) { break; }
			System.out.println("내용을 찾을 수 없습니다.");
			w++;
		}
		return index;
	}
	
	void modify() {
		int index[] = serIndex();
		if(index[0]<0) { return; }; //검색 실패시 메뉴이동
		serPrint(index);
		int num = chkNum("수정할 대상번호");
		int modiNum = chkNum("수정항목 : 1.용도, 2.분류, 3금액, 4내용\n입력>>");
		switch(modiNum) {
			case 1: 
				String use = chkStr("수정 할 용도");
				ac.get(index[num-1]).setUse(use);
				break;
			case 2: 
				String classify = chkStr("수정 할 분류");
				ac.get(index[num-1]).setClassify(classify);
				break;
			case 3: 
				int money = chkNum("수정 할 금액");
				ac.get(index[num-1]).setMoney(money);
				break;
			case 4: 
				String memo = chkStr("수정 할 내용");
				ac.get(index[num-1]).setMemo(memo);
				break;
			default :
				System.out.println("정확한 입력이 아닙니다.");
				return;
		}
		System.out.println("수정되었습니다.");
	}
	
	void serPrint(int index[]) {
		int w = 0;
		while(true) {
			if(index[w]==-1) {
				break;
			}
			System.out.print((w+1) + ". ");
			for (int i = 0; i < index.length; i++) {
				AccountDto a = ac.get(index[i]);
				a.print();
			}
			w++;
		}
	}
	
	void printAll() {
		for (AccountDto a : ac) {
			a.print();
		}
	}

	public int printMenu() { //추가 삭제 검색 수정, 출력, 종료
		System.out.println("================= M E N U ======================");
		System.out.println("| 1.추가   2.삭제   3.검색   4.수정   5.출력   6.종료 |");
		System.out.println("================================================");
		int workNum = chkNum("입력>>");
		if(workNum < 0) {
			workNum = 6; //강제종료
			System.out.print("입력이 올바르지 않아 프로그램을 ");
		}
		return workNum;
	}
	
	int chkNum(String msg) { // 숫자 체크
		Scanner sc = new Scanner(System.in);
		String numStr = "";
		boolean b;
		
		int w = 0;
		while(w<3) {
			b = true;
			System.out.print(msg+":");
			numStr = sc.nextLine();
			numStr = numStr.replace(" ", "");  	// 공백제거

			if (numStr.length()==0 || numStr == null) { //빈 문자 체크
				b=false;
			}else {
				for(int i=0; i<numStr.length(); i++) { //숫자체크
					char c = numStr.charAt(i);
					if(c<48 || c>57) { // 0 48  9 57
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

	String chkStr(String msg) {
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
	
}
