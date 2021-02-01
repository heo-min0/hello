import java.util.Scanner;

public class ex5_if {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1-1000 더한 값
		/*int result = 0;
		for (int i = 1; i <= 1000; i++) {
			result = result + i;
		}
		System.out.println("1부터 100사이 수의 합은:" +result);
		*/
		//어느 범위
		/*
		System.out.print("0~100 사이의 수를 입력해주세요.\n숫자 = ");
		int num = sc.nextInt();
		
		int boundNum = 0;
		for (int i = 0; i <= 100; i++) {
			boundNum = 10*i;
			if(boundNum<num && (boundNum+10)>=num) {
				System.out.println("입력한 수는 "+ boundNum + "보다 크고 " + (boundNum+10) + "보다 작거나 같다");
			}
		}
		*/
		//*5개찍기
		/*for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}*/
		//*찍기
		/*int k = 0;
		for (int i = 0; i < 9; i++) {
			if(i<5) {
				k++;
			}else {
				k--;
			}
			for (int j = 0; j < k; j++) {
				System.out.print("*");
			}
			System.out.println();
		}*/
		/*int k=1;
		for (int i = 1; i > 0; i+=k) {
			System.out.print(i);
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			if(i>4) {
				k=-1;
			}
			System.out.println();
		}*/
		//구구단
		/*for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.print(i+"*"+j+"="+i*j+"\t");
			}
			System.out.println();
		}*/
		//입력수 구구단
		/*System.out.print("숫자 = ");
		int numGu = sc.nextInt();
		for (int i = 1; i < 10; i++) {
			System.out.print(numGu+"*"+i+"="+numGu*i+"\t");
		}*/
		//1-100 짝수 홀수 합
		/*int even, odd;
		even = odd = 0;
		for (int i = 0; i <= 100; i++) {
			if(i%2 == 0) {
				even = even + i;
			} else {
				odd = odd + i;
			}
		}
		
		System.out.println("1-100까지 짝수의 합은 : " + even);
		System.out.println("1-100까지 홀수의 합은 : " + odd);
		*/
		//입력받은 숫자 합계
		/*System.out.print("숫자를 몇개 입력하시겠습니까? = ");
		int count = sc.nextInt();
		
		int sums[] = new int[count];
		int resultSum = 0;
		
		System.out.println("숫자를 입력해주세요.");
		for (int i = 0; i < sums.length; i++) {
			System.out.print((i+1) +"번째 숫자:");
			sums[i] = sc.nextInt();
			resultSum = resultSum + sums[i];
		}
		System.out.print("합계 = "+ resultSum);
		*/
		
		
		
		
		sc.close();
	}

}
