package work;

import java.util.Arrays;
import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		//initialize
		int random[];
		int userNum[] = new int[3];
		boolean win = false;
		
		while(true) { //계속 게임
			//TODO: 1. 랜덤수 3개 중복 없음
			random = shuffle(10, 3);
						
			//loop//
			win = ballCount(random, 10);
						
			//5. 결과
			if(win) {
				System.out.println("승리");
			}else {
				System.out.println("실패");
			}
			
			String replay = input("계속하시겠습니까?(Y/N)");
			if(replay.equals("n") || replay.equals("N")) {
				break;
			}
		}//end 계속 게임
		
	}

	static boolean ballCount(int[] random, int count) {
		boolean win = false;
		int w=0;
		while(w<count) {
			//2. user input 같은숫자있으면 반복
			int userNum[] = user(3);
			System.out.println(Arrays.toString(userNum));
			
			//3. 비교
			int strike = 0;
			int ball = 0;
			for (int i = 0; i < random.length; i++) {
				if(random[i] == userNum[i]) {
					strike++;
				}
				for (int j = 0; j < userNum.length; j++) {
					if(i!=j && random[i] == userNum[j]) {
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
		return win;
	}

	static int[] user(int i) {
		int userNum[] = new int[i];
		int w = 0;
		while(w<i) {
			boolean b = true;
			System.out.print(w+1);
			String str = input("번째 수=");
			b = chkNum(str);
			if (b==true) {
				userNum[w] = Integer.parseInt(str);
				w++;
			}
		}
		return userNum;
	}

	private static String input(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.print(str);
		String num = sc.next();
		return num;
	}

	static boolean chkNum(String str) {
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

	static int[] shuffle(int total, int count) {
		int ran[] = new int[count];
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
		System.out.println(Arrays.toString(ran));
		return ran;
	}

	
	
}
/*
int w=0;
while(w<3) {
	/*int a = (int)(Math.random()*10);
	System.out.print(a+" ");
	if(w>0) {				
		if(random[w-1] == a) {
			continue;
		}else if(w>1 && random[w-2] == a) {
			continue;
		}
	}
	random[w] = a;
	w++;*/
	/*
	boolean b = true;
	int a = (int)(Math.random()*10);
	System.out.println(a);
	for (int i = 0; i < w; i++) {
		if(random[i] == a) {
			b=false;
			break;
		}
	}
	if(b) {
	random[w] = a;
	w++;
	}
}*/