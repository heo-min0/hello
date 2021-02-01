package work;

import java.util.Scanner;

public class GBbgame {

	public static void main(String[] args) {

		int random;
		int userN = 0;
		int win, lose, draw;
		int result;
		
		
		win = lose = draw = 0;
		while(true) {
			//랜덤 수 1
			random = (int)(Math.random()*3)+1;
			System.out.println(random);
			//유저 1
			Scanner sc = new Scanner(System.in);
			System.out.print("1:가위, 2:바위, 3:보 = ");
			userN = sc.nextInt();
			
			//결과 승 패 무
			// 1 (2승 3패) -1 -2  1 0
			// 2 (3승 1패) -1  1  1 3
			// 3 (1승 2패)  2  1  4 3
			/*if(random == user) {
				draw++;
			}else if(random==1) {
				if(user==2) {
					win++;
				}else if(user==3) {
					lose++;
				}
			}else if(random==2) {
				if(user==3) {
					win++;
				}else if(user==1) {
					lose++;
				}
			}else if(random==3) {
				if(user==1) {
					win++;
				}else if(user==2) {
					lose++;
				}
			}*/
			//결과 승 패 무
			// 1 (2승 3패) -1 -2  1 0
			// 2 (3승 1패) -1  1  1 3
			// 3 (1승 2패)  2  1  4 3
			
			result = (random - userN + 2) %3;
			
			
			//출력
			String msg = "";
			switch(result) {
				case 1: msg = "승 리"; win++; break;
				case 0: msg = "패 배"; lose++; break;
				case 2: msg = "무승부"; draw++; break;
			}
			
			String user = "";
			switch(userN) {
				case 1: user = "가위"; break;
				case 2: user = "바위"; break;
				case 3: user = "보"; break;
			}
			
			String com = "";
			switch(random) {
				case 1: com = "가위"; break;
				case 2: com = "바위"; break;
				case 3: com = "보"; break;
			}
			
			System.out.println("당신:" + user);
			System.out.println("컴퓨터:" + com);
			//몇승 몇패 몇 무 계속
			System.out.println(win + "승 / " + lose + "패 / " + draw + "무");
			
			System.out.println("한판 더 하시겠습니까?(Y/N)");
			String replay = sc.next();
			
			if (replay.equals("n") || replay.equals("N")) {
				System.out.println("감사합니다.");
				break;
			}
			System.out.println("다시 시작합니다.");
			// 알고리즘 4대요소 : 셔플 정렬sort 이진트리 탐색
			// stack queue
		}
	}

}
