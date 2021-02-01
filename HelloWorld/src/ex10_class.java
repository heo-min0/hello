import java.util.Arrays;
import java.util.Scanner;

public class ex10_class {
	int ran[];
	int userNum[];
	
	public void shuffle(int total, int count) {
		ran = new int[count];
		boolean swit[] = new boolean[10];
		int w = 0;
		while(w<count) {
			int r=(int)(Math.random()*total);
			if(swit[r]==false) {
				swit[r] = true;
				ran[w]=r;
				w++;
			}
		}
	}
	
	public void ballCount(int count) {
		boolean win = false;
		int w=0;
		while(w<count) {
			//2. user input 같은숫자있으면 반복
			user(3);
			System.out.println(Arrays.toString(userNum));
			
			//3. 비교
			int strike = 0;
			int ball = 0;
			for (int i = 0; i < ran.length; i++) {
				if(ran[i] == userNum[i]) {
					strike++;
				}
				for (int j = 0; j < userNum.length; j++) {
					if(i!=j && ran[i] == userNum[j]) {
						ball++;
					}
				}
			}
			if(strike == 3) {
				win = true;
			}else {
				System.out.println((count+1)+"게임:" +strike + "strike, " + ball + "ball");
			}
		w++;
		}
		if(win) {
			System.out.println("승리");
		}else {
			System.out.println("실패");
		}
	}
	
	public void user(int i) {
		userNum = new int[i];
		int w = 0;
		while(w<i) {
			System.out.print(w+1);
			String str = input("번째 수=");
			if (chkNum(str)==true) {
				userNum[w] = Integer.parseInt(str);
				w++;
			}
		}
	}

	private static String input(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.print(str);
		String num = sc.next();
		return num;
	}

	public boolean chkNum(String str) {
		boolean b = true;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c<48 || c>57) { // 0 48  9 57
				b=false;
				System.out.println("다시 입력해주세요");
				break;
			}
			else if(str.length() > 1) {
				System.out.println("숫자 1개만 입력해주세요");
				b=false;
				break;
			}
		}
		return b;
	}
	
	/*int number[];
	boolean updown;
	
	public void userInput() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 몇 개 입력할건가요?");
		int count = sc.nextInt(); // 0보다 크게
		
		number = new int[count];
		for (int i = 0; i < number.length; i++) {
			System.out.println((i+1) +"숫자:");
			number[i] = sc.nextInt();
		}
		
		System.out.print("정렬(오름:1, 내림:2)?");
		int n = sc.nextInt();
		if(n == 1) {
			updown = true;
		}else {
			updown = false;
		}
	}
	
	public void sorting() {
		for (int i = 0; i < number.length-1; i++) {
			for (int j = i+1; j < number.length; j++) {
				if(updown==true && (number[i] > number[j])) {
					swap(i, j);
				}else if(updown==false && (number[i] < number[j])) {
					swap(i, j);
				}
			}
		}
	}
	
	void swap(int i, int j) {
		int tmp;
		tmp = number[i];
		number[i] = number[j];
		number[j] = tmp;
	}
	
	public void resultPrint() {
		if(updown) {
			System.out.println("오름차순 정렬");
		} else {
			System.out.println("내림차순 정렬");
		}
		System.out.println("숫자의 갯수 :" + number.length);
		
		for (int i = 0; i < number.length; i++) {
			System.out.println((i+1)+ "번째수 " +number[i]);
		}
	}*/
}
