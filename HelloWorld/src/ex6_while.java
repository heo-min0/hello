import java.util.Scanner;

public class ex6_while {

	public static void main(String[] args) {
		/*
		int array[] = {1,2,3,-4,5};
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
			if(array[i]<0) {
				break;
			}
		}
		*/
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("양수인 숫자 5개를 입력해주세요.");
		int numArr[] = new int[5];
		int w=0;
		while(w<5) {
			System.out.printf("숫자입력(%d)=",w+1);
			numArr[w] = sc.nextInt();	
			if(numArr[w]<=0) {
				System.out.println("양수를 입력해주세요");
				continue;
			}
			w++;
		}
		*/
		/*random 산출
		 * 10번
		 * user input
		 * 비교
		 * 메세지
		 * 결과
		 */
		//1. 랜덤수
		/*
		Scanner sc = new Scanner(System.in);
		int ranNum;
		int inputNum;
		
		while(true) {
			ranNum = (int)(Math.random()*100)+1;
			System.out.println(ranNum);
			
			int w = 0;
			while(w<10) {
				System.out.printf("숫자입력(%d)=",w+1);
				inputNum = sc.nextInt();
				
				if(inputNum>ranNum) {
					System.out.println("큽니다.");
				}else if(inputNum<ranNum) {
					System.out.println("작습니다.");
				}else if(inputNum==ranNum) {
					System.out.println("정답입니다.");
					break;
				}
				
				w++;
				if(w==10) {
					System.out.println("실패했습니다.");
				}
			}
			
			System.out.println("다시 하시겠습니까(Y/N)? ");
			String replay = sc.next();
			if(replay.equals("N")) {
				System.out.println("감사합니다.");
				break;
			}
			
		}*/
		/*
		int arr[] = {10, 20, 30, 40, 50};
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		System.out.println("sum="+sum);
		*/
		/*
		int arr[][] ={{5,5,5,5,5},
					  {10,10,10,10,10},
					  {20,20,20,20,20},
					  {30,30,30,30,30} };
		int total=0;
		float average=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				total += arr[i][j];
			}
		}
		average = (float)total/(arr.length*arr[0].length);
		
		System.out.println("total="+total);
		System.out.println("average="+average);
		*/
		/*
		int coinUnit[] = {500, 100, 50, 10};
		int money = 2680;
		int cu[] = new int[4];
		int m = money;
		for (int i = 0; i < coinUnit.length; i++) {
			cu[i] = m/coinUnit[i];
			m = m%coinUnit[i];
		}
		
		System.out.println("money=" + money);
		for (int i = 0; i < cu.length; i++) {
			System.out.println(coinUnit[i]+"원:"+cu[i]);
		}
		*/
		/*
		char[] abcCode = { '`','~','!','@','#','$','%','^','&','*',
						   '(',')','-','_','+','=','|','[',']','{',
						   '}',';',':',',','.','/'};
		char[] numCode = { 'q','w','e','r','t','y','u','i','o','p' };
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력:");
		String src = sc.next();
		//String src = "abc123";
		String result = "";
		
		for (int i = 0; i < src.length(); i++) {
			char ch = src.charAt(i); // a 97  z 122  0 48 9 57
			if(ch>=97 && ch<=122) {
				result = result + abcCode[ch-97];
			}else if(ch>=48 && ch<=57) {
				result = result + numCode[ch-48];
			}
		}		
		System.out.println("src:" + src);
		System.out.println("result:" + result);
		
		//복호화
		String re = "";
		for (int i = 0; i < result.length(); i++) {
			char ch = result.charAt(i); // a 97  z 122  0 48 9 57
			if(ch>=97 && ch<=122) {  //문자를 숫자로
				for (int j = 0; j < numCode.length; j++) {
					if(ch==numCode[j]) {
						re = re + (char)(48+j);
						break;
					}
				}
			}else {
				for (int j = 0; j < abcCode.length; j++) {
					if(ch==abcCode[j]) {
						re = re + (char)(97+j);
						break;
					}
				}
			}
		}
		System.out.println("re:"+re); //baseCode
		*/
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력=");
		String str = sc.nextLine();
		
		boolean b = false;
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			int asc = (int)ch;
			if(asc<48 || asc>57) { // 0 48  9 57
				b=true;
				break;
			}
		}
		if(b) {
			System.out.println("숫자가 아닙니다.");
		}else {
			System.out.println("모두 숫자입니다.");
		}
		/*
		박정윤 정지민 이주영 김동현 장현성
		이다솜 이안근 고명우 곽태민 박선양 이태민
		이수빈 우정현 김윤아 이정우 원종훈
		이민선 정연우 최은지 허 민
		*/
    
	}
}
