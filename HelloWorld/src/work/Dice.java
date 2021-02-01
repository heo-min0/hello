package work;

import java.util.Scanner;

public class Dice {

	public static void main(String[] args) {
		/*Studentss s = new Studentss();
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		System.out.println("이름:"+s.name);
		System.out.println("총점:"+s.getTotal(s.kor, s.eng, s.math) );
		System.out.println("평균:"+s.getAverage( ) );*/

		/*MyTv2 t = new MyTv2();
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setVolume(20);
		System.out.println("VOL:"+t.getVolume());*/

		//2개의 주사위 합
		//랜덤 주사위가 필요1-6까지 그래서 두번 요청
		new Game().gamePlay();
	}
}

class Game{
	Scanner sc = new Scanner(System.in);
	int coin=20;
	int batCoin;
	int userSum;
	
	Die dice1 = new Die(); //composition(합성)
	Die dice2 = new Die();
	
	public void init() {
		dice1.setRandom();
		dice2.setRandom();
	}

	public void inputUser() { //입력 코인 합계
		while(true) {
			System.out.print("배팅할 코인 수:");
			batCoin = sc.nextInt();
			if(batCoin <= coin) {
				coin = coin - batCoin;
				break;
			}
			System.out.println("가진 코인수보다 많습니다.");
		}
		
		while(true) {
			System.out.print("두 주사위의 합:");
			userSum = sc.nextInt();
			if(userSum != 2 && userSum != 12) {
				break;
			}
			System.out.println("2와 12는 입력할 수 없습니다.");
		}
	}

	public void finding() { //몇배 계산
		int diceNum1 = dice1.getnumber();
		int diceNum2 = dice2.getnumber();
		int diceSum = diceNum1 + diceNum2;
		
		if(userSum==diceSum) {
				 if(diceSum==3 || diceSum==11) { batCoin = batCoin*18; }
			else if(diceSum==4 || diceSum==10) { batCoin = batCoin*12; }
			else if(diceSum==5 || diceSum== 9) { batCoin = batCoin* 9; }
			else if(diceSum==6 || diceSum== 8) { batCoin = batCoin* 7; }
			else if(diceSum==7) 			   { batCoin = batCoin* 6; }
			System.out.println("승리");
			coin = coin + batCoin;
		}
		System.out.println("패배");
	}

	public void print() { //결과출력
		System.out.println("주사위번호 : " + dice1.getnumber()+ ", " + dice2.getnumber());
		System.out.println("합계 : " + (dice1.getnumber()+dice2.getnumber()));
		System.out.println("현재 코인수 : " + coin);
	}
	
	public void gamePlay() {
		while(true) {
			init();
			inputUser();
			finding();
			print();
			
			if(coin == 0) {
				System.out.println("코인이 없습니다.");
				break;
			}
			System.out.println("한판더(y/n)");
			String again = sc.next();
			
			if(again.equals("n")) {
				System.out.println("감사합니다.");
				break;
			}
			System.out.println("다시 시작합니다.");
		}
	}
}

class Die{
	int number;
	public void setRandom() {
		number = (int)(Math.random()*6)+1;
	}
	public int getnumber() {return number;}
}

/*class MyTv2 {
	boolean isPowerOn;
	int channel;
	int volume;
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
}*/

/*class Studentss {
	String name;	
	int ban, no, kor, eng, math;
	
	int getTotal(int kors, int engs, int maths) {
		return kor + eng + math;
	}
	public double getAverage() {
		double a = (double)getTotal(kor, eng, math) / 3;
		double b = (double)Math.round(a*10)/10;
		return b;
	}
}*/



