package Singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hash {
	
	public hash() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String[] participant = null; //1000
		String[] completion = null; //1000-1
		new hash().solution(participant,completion);

	}
	public String solution(String[] p, String[] c) {
        String answer = "";
        //List<String> list = new ArrayList<String>();
        Arrays.sort(p);
        Arrays.sort(c);
        
        String last = null;
        for (int i = 0; i < c.length; i++) {
			if(!p[i].equals(c[i])) {
				last=p[i];
			}
		}
        
        int count = 0;
        for (int i = 0; i < c.length; i++) {
			if(last.equals(p[i])) {
				count++;
			}
		}
        answer = "못들어온 선수는 " + last + " 이고" + count + "명 이다.";
        return answer;
    }

}

class BinarySearch {

	static int binarySearch(int[] arr, int num) {
		Arrays.sort(arr);
		int l = 0, r = arr.length-1;

		while(l <= r) {
			int mid = (l + r)/2; // 중간 위치 구함
			if(arr[mid] == num) return mid; // 위치를 찾았을 경우
		    
		    if(arr[mid] < num) { // 중간 값이 찾고자하는 값보다 작을 경우 == 중간 값 보다 오른쪽에 위치해있다
		    	l = mid + 1;
		    }else {	// 중간 값이 찾고자하는 값보다 큰 경우 == 중간 값 보다 왼쪽에 위치해있다
		    	r = mid - 1;
		    }
		    System.out.println("mid:" + mid);
		}

		  // 찾는 값이 없을 경우 -1을 반환(-1이라는 index는 없기 때문)
		return -1;
	}
    
    public static void main(String[] args) {
    	
    	int array[] = { 0, 4, 7, 10, 14,  23, 45, 47, 53 };
    	
    	int mid = binarySearch(array, 47);
    	System.out.println("mid:" + mid);
    }

}












