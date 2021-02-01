import java.util.Arrays;
import java.util.Scanner;

public class ex7_sorting {

	public static void main(String[] args) {
		/*
		int num[] = {5,9,1,8,2,6,4,7,3,10};
		int temp;
		for (int i = 0; i < num.length-1; i++) {
			for (int j = i+1; j < num.length; j++) {
				if(num[i] < num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(num));
		*/
		
		//int user[] = {5,8,2,9,3};
		//입력
		boolean updown[] = new boolean[1];
		int user[] = userInput(updown);

		//정렬
		setsort(user, updown[0]);
		
		//출력
		reaultPrint(user, updown[0]);
		//System.out.println(Arrays.toString(user));
		
		// 피보나치 수열 fibonnaci
		// 0 1 1 2 3 5 8 13
		/*
		long a, b, c;
		int index = 30;
		
		long fiv[] = new long[index];
		fiv[0] = a = 0;
		fiv[1] = b = 1;
		
		for (int i = 2; i < index; i++) {
			fiv[i] = fiv[i-2] + fiv[i-1];
		}
		int w = 2;
		while(w<index) {
			c = a + b;
			fiv[w] = c;
			a=b;
			b=c;
			w++;
		}
		
		System.out.println(Arrays.toString(fiv));
		System.out.println(fiv.length);
		System.out.println(fiv[index-1]);
		 */
		/*
		//퀵 정렬
		int[] arr = {3,1,4,5,7,9,2,6,8};
		quick(0,8,arr);
		System.out.println(Arrays.toString(arr));
		*/
		
	}
	
	static void reaultPrint(int[] user, boolean updown) {
		if(updown) {
			System.out.println("오름차순 정렬");
		} else {
			System.out.println("내림차순 정렬");
		}
		System.out.println("숫자의 갯수 :" + user.length);
		
		for (int i = 0; i < user.length; i++) {
			System.out.println((i+1)+ "번째수 " +user[i]);
		}
		
	}

	static void setsort(int[] user, boolean updown) {
		for (int i = 0; i < user.length-1; i++) {
			for (int j = i+1; j < user.length; j++) {
				if(updown==true && (user[i] > user[j])) {
					swap(user, i, j);
				}else if(updown==false && (user[i] < user[j])) {
					swap(user, i, j);
				}
			}
		}
	}

	static void swap(int[] user, int i, int j) {
		int tmp;
		tmp = user[i];
		user[i] = user[j];
		user[j] = tmp;
		
	}

	private static int[] userInput(boolean updown[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 몇 개 입력할건가요?");
		int count = sc.nextInt(); // 0보다 크게
		
		int user[] = new int[count];
		for (int i = 0; i < user.length; i++) {
			System.out.println((i+1) +"숫자:");
			user[i] = sc.nextInt();
		}
		
		System.out.print("정렬(오름:1, 내림:2)?");
		int n = sc.nextInt();
		if(n == 1) {
			updown[0] = true;
		}else {
			updown[0] = false;
		}
		return user;
	}

	static void quick(int left, int right, int[] arr) {
		if(left>=right) {
			return;
		}
		
		int pivot = left; //0 피벗을 첫번째 값으로 지정
		int i = pivot+1;    //0 왼쪽 출발지점
		int j = right;   //1 오른쪽 출발지점
		int temp; 
		
		while(i<=j) { // 포인터가 엇갈리때 까지 반복
			while(i<=right && arr[i]<=arr[pivot]) {
				i++;
			}
			while(j>left && arr[j]>=arr[pivot]) {
				j--;
			}
		
			if(i>j) { //포인터가 엇갈려서 피벗이랑 오른쪽에서 온 녀석(j)이랑 바꿈
				temp = arr[j];
				arr[j] = arr[pivot];
				arr[pivot] = temp;
			}else { // i <= j  서로 엇갈리지 않음, 서로 스왑 
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}

		} //System.out.println(Arrays.toString(arr));

		// 정렬과정
		quick(left, j-1, arr);
		quick(j+1,right, arr);
		
	}
	static void quickSort(int[] arr, int left, int right) {
	    int i, j, pivot, tmp;

	    if (left < right) {
	        i = left;
	        j = right;
	        pivot = arr[left]; //기준점
	        //분할 과정
	        while (i < j) {
	            while (arr[j] > pivot) j--;
	            // 이 부분에서 arr[j-1]에 접근해서 익셉션 발생가능함
	            while (i < j && arr[i] <= pivot) i++;
	            tmp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = tmp;
	        }
	        arr[left] = arr[i];
	        arr[i] = pivot;
	        //정렬 과정
	        quickSort(arr, left, i - 1);
	        quickSort(arr, i + 1, right);
	    }
	}
	

}
