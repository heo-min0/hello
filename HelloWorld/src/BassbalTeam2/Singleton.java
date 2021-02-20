package BassbalTeam2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Singleton {
	
	private static Singleton sc = null;
	public List<HumanDto> human = new ArrayList<HumanDto>();
	public int number;
	public int index[];
	
	private Singleton() {
		
	}
	
	public static Singleton getinstance() {
		if(sc==null) {
			sc = new Singleton();
		}
		return sc;
	}
	public void search() {
		Select s = new Select();
		s.search();
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
