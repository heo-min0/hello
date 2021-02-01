package work;

import java.util.Arrays;
import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		//
		// 2차원배열 1차원배열 바꿔 2차원 배열을 정렬할때 쓴다 sort
		// 람다
		/*int arr2[][] = { { 1, 2, 3, 4},
						 { 5, 6, 7, 8},
						 { 9,10,11,12} };
		
		int arr1[] = new int [arr2.length * arr2[0].length];
		
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				arr1[arr2[0].length*i + j] = arr2[i][j];
				System.out.println(arr2[0].length*i + j);
			}
		}
		System.out.println(Arrays.toString(arr1));
		*/
		// 학생성적관리
		// 몇명 ㅇㅂ력
		// 2차원배열
		// 과목 이름 국영수
		// 총점
		// 평균
		// 수학 1등
		// 수학 최하점수

		/*
		//2차 배열
		String grade[][] = new String[stuNum][4];

		//성적 입력
		String title[] = {"학생이름:", "국어점수:", "영어점수:", "수학점수:"};
		for (int i = 0; i < stuNum; i++) {
			for (int j = 0; j < title.length; j++) {
				System.out.print((i+1)+"."+title[j]);
				String str = sc.next();
				grade[i][j] = str;
			}
			System.out.println("-------------");
		}
		*/
		String grade[][];
		grade = userInput();
		/*String grade[][] = { {"홍길동", "70", "60", "50"},
							 {"이순신", "80", "70", "60"},
							 {"허균", "90", "80", "90"} };
		*/
		/*
		int stuNum = 3;
		String sumAvg[][] = new String[stuNum][3];
		
		for (int i = 0; i < grade.length; i++) {
			sumAvg[i][0] = grade[i][0];
		}
		*/
		int sum = getSum(grade);
		getAvg(grade, sum);
		/*
		double avg;
		for (int i = 0; i < grade.length; i++) {
			sum = 0;
			avg = 0;
			for (int j = 1; j < grade[i].length; j++) {
				sum = sum + Integer.parseInt(grade[i][j]);
			}
			avg=sum/(grade[0].length-1);
			sumAvg[i][1] = String.valueOf(sum);
			sumAvg[i][2] = String.valueOf(avg);
		}
		System.out.println(Arrays.deepToString(sumAvg));
		*/
		getMax(grade, "수학");
		getMin(grade, "영어");
	}

	static void getMin(String[][] grade, String str) {
		int index = 0;
		switch(str) {
		case "국어": index = 1; break;
		case "영어": index = 2; break;
		case "수학": index = 3; break;
		}
		int min=Integer.parseInt(grade[0][index ]);
		int indexEng=0;
		for (int i = 0; i < grade.length-1; i++) {
			int eng = Integer.parseInt(grade[i][index ]);
			if (min > eng) {
				min = eng;
				indexEng = i;
			}
		}
		System.out.println(str + " " + grade.length + "등:" + grade[indexEng][0] + " / 점수:" + min);
	}

	static void getMax(String[][] grade, String str) {
		int index = 0;
		switch(str) {
		case "국어": index = 1; break;
		case "영어": index = 2; break;
		case "수학": index = 3; break;
		}
		int max = Integer.parseInt(grade[0][index]);
		int indexMath=0;
		for (int i = 0; i < grade.length; i++) {
			int math = Integer.parseInt(grade[i][index]);
			if (max < math) {
				max = math;
				indexMath = i;
			}
		}
		System.out.println(str + " 1등:"+grade[indexMath][0]+" / 점수:"+max);
	}

	static void getAvg(String[][] grade, int sum) {
		double avg = (double) sum / grade.length;
		System.out.println("학생 점수의 평균 :"+ avg);
	}

	static int getSum(String[][] grade) {
		int sum=0;
		for (int i = 0; i < grade.length; i++) {
			for (int j = 1; j < grade[i].length; j++) {
				sum = sum + Integer.parseInt(grade[i][j]);
			}
		}
		System.out.println("학생 점수의 총합 :"+sum);
		return sum;
	}

	static String[][] userInput() {
		Scanner sc = new Scanner(System.in);
		//학생수
		System.out.print("학생수는 몇 명입니까? ");
		int stuNum = sc.nextInt();
		//int stuNum = 3;
		String grade[][] = new String[stuNum][4];

		//성적 입력
		String title[] = {"학생이름", "국어점수", "영어점수", "수학점수"};
		for (int i = 0; i < grade.length; i++) {
			for (int j = 0; j < title.length; j++) {
				System.out.print((i+1)+"."+title[j]+":");
				String str = sc.next();
				grade[i][j] = str;
			}
			System.out.println("-------------");
		}
		return grade;
	}

}
