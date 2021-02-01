import java.util.Scanner;

public class ex3_operator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		int num = 5;
		int n;
		
		n = (num>0) ? 100 : 200;
		System.out.println(n);
		*/
		/*
		편의점
		금액 3,210원
		본인 10,000원
		거스름돈 ?
		*/
		/*
		int price;
		int money;
		int rMoney;
		
		System.out.print("지불금액 : ");
		price=sc.nextInt();
		
		System.out.print("본인금액 : ");
		money=sc.nextInt();
		
		rMoney = money - price;
		int m5000 = rMoney/5000;
		int m1000 = (rMoney%5000)/1000;
		int m500 = (rMoney%1000)/500;
		int m100 = (rMoney%500)/100;
		int m50 = (rMoney%100)/50;
		int m10 = (rMoney%50)/10;
		
		System.out.println("거스름 : " + rMoney + "원");
		System.out.println("5000원 : " + m5000 + "장");
		System.out.println("1000원 : " + m1000 + "장");
		System.out.println("500원 : " + m500 + "개");
		System.out.println("100원 : " + m100 + "개");
		System.out.println("50원 : " + m50 + "개");
		System.out.println("10원 : " + m10 + "개");
		*/
		/*
		int number = 5; 	 // 0101   5 * 2e4 16 5 80
		number = number << 4; // 1010   0001 0100  0010 1000  0101 0000  50   
		System.out.printf("%x", number);
		
		number = number >> 3; //1010
		System.out.print(number);
		
		number = number << 1; //1010
		System.out.printf("%x", number);
		*/
		/*
		int num1, num2;
		num1 = 128; // 8421 8421  1 2 4 8  16 32 64 128
					// 1000 0000
		
		num2 = 56;  // 8421 8421
					// 0011 1000
		num1 = (num1 & num2)|(num1 & num2); //0
				//0000 0000 |  0000 0000
		System.out.printf("%x\n", num1);
		num2 = ~(num1^num2); //1100 0111 c7
				// 0000 0000
				// 0011 1000
				// 0011 1000
		System.out.printf("%x", num2);
		*/
		/*
		int ma = -1;
		String msg = ( ma > 0 ) ? "양수입니다." : ( ma < 0 ) ? "음수입니다." : "0입니다.";
		System.out.print(msg);
		*/
		/*
		int ran;
		ran = (int)(Math.random()*100);
		System.out.println(ran);
		
		ran = (int)(Math.random()*5)+11;
		System.out.println(ran);
		
		int ran1 = (int)(Math.random()*45)+1;
		int ran2 = (int)(Math.random()*45)+1;
		int ran3 = (int)(Math.random()*45)+1;
		int ran4 = (int)(Math.random()*45)+1;
		int ran5 = (int)(Math.random()*45)+1;
		int ran6 = (int)(Math.random()*45)+1;
		System.out.printf("%d, %d, %d, %d, %d, %d", ran1, ran2, ran3, ran4, ran5, ran6);
		*/
		
	}

}
