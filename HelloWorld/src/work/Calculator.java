package work;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// 계산기
		int num1, num2;
		String oper;
		double result = 0;
				
		//입력
		num1 = inputNum("첫번째 수");
		oper = operator("연산자( + - * / )");		
		num2 = inputNum("두번째 수");
		
		//연산
		result = operation(num1, num2, oper);
		
		//출력
		if (oper.equals("/")) {
			System.out.printf("%d %s %d = %.2f", num1, oper, num2, result);
		}else {
			System.out.printf("%d %s %d = %d", num1, oper, num2, (int)result);
		}
		
	}

	static String operator(String str) {
		String oper = "";
		while(true) {
			oper = input("연산자( + - * / )");
			if(oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/")) {
				break;
			}
			System.out.println("다시 입력해주세요");
		}
		return oper;
	}

	static int inputNum(String str) {
		String sNum = "";
		boolean b = true;
		while(true) {
			sNum = input(str);
			b=isNumber(sNum);
			if(b) {	break; }
			System.out.println("숫자가 아닙니다.");
		}
		int num = Integer.parseInt(sNum);
		return num;
	}

	static double operation(int num1, int num2, String oper) {
		double result = 0;
		switch(oper) {
		case "+" : result = num1 + num2; break;
		case "-" : result = num1 - num2; break;
		case "*" : result = num1 * num2; break;
		case "/" : result = (double)num1 / num2; break;
		}
		return result;
	}

	static boolean isNumber(String str) {
		boolean b = true;
		if (str.length()==0 || str == null) {
			b=false;
			return b;
		}
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			int asc = (int)ch;
			if(asc<48 || asc>57) { // 0 48  9 57
				b=false;
				break;
			}
		}
		return b;
	}

	static String input(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.print(str + "=");
		String num = sc.nextLine();
		num = num.replace(" ", "");
		return num;
	}

}
