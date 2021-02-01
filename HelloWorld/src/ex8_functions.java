import java.util.Arrays;

public class ex8_functions {

	public static void main(String[] args) {
		
		/*char c = alpa(65);
		System.out.println(c);
		
		int a = acs('a');
		System.out.println(a);
		
		boolean b = chk(65);
		System.out.println(b);*/
		
		double s = getDistance(1,1,2,2);
		System.out.println(s);
		
		int ori[] = {1,2,3,4,5,6,7,8,9};
		int[] res = shuffle(ori);
		System.out.println(Arrays.toString(res));
		
		int data[] = {3,2,9,4,7};
		int maxN = max(data);
		System.out.println("최대값:" + maxN);
		
		String str = "123";
		System.out.println(str+ "는 숫자입니까?" + isNumber(str));
		str = "1234o";
		System.out.println(str+ "는 숫자입니까?" + isNumber(str));
		
		int num1[] = {1,2,3,4,5};
		getDouble(num1);
		System.out.println(Arrays.toString(num1));
		
		int nuM1, nuM2;
		int result, tag[] = new int[1];
		nuM1 = 55;
		nuM2 = 3;
		result = getResult(nuM1, nuM2, tag);
		System.out.println("몫:" + result +"  나머지:"+ tag[0]);
	}

	static int getResult(int nuM1, int nuM2, int[] t) {
		int a = nuM1/nuM2;
		t[0] = nuM1%nuM2;
		return a;
	}

	static void getDouble(int[] num1) {
		for (int i = 0; i < num1.length; i++) {
			num1[i] = num1[i]*2;
		}
	}

	static boolean isNumber(String str) {
		boolean b = true;
		if(str==null || str.length()==0) {
			b=false;
		}else {
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if(ch<48 || ch>57) {  //0 48   9 57
					b=false;
					break;
				}
			}
		}
		return b;
	}

	static int max(int[] data) {
		int m;
		if (data == null || data.length==0) {
			m=-999999;
		}else {
			m = data[0];
			for (int i = 1; i < data.length; i++) {
				if(m<data[i]) {
					m = data[i];
				}
			}
		}
		return m;
	}

	static int[] shuffle(int[] ori) {
		int tmp;
		for (int i = 0; i < 100; i++) {
			int r = (int)(Math.random()*9);
			tmp = ori[r];
			ori[r] = ori[0];
			ori[0] = tmp;
		}
		return ori;
	}

	static double getDistance(int x, int y, int x1, int y1) {
		double a = Math.pow(x1-x, 2) + Math.pow(y1-y, 2);
		double b = Math.sqrt(a);
		return b;
	}
	
	
	
	
	
	/*
	static boolean chk(double d) {
		boolean b = false;
		
		String str = Double.toString(d);
		int index = str.indexOf(".");
		String str1 = str.substring(index+1, str.length());
	
		if(Integer.parseInt(str1) > 0) {
			b = true;
		}
		return b;
	}
	
	static int acs(char c) {
		int a = (int)c;
		return a;
	}
	
	static char alpa(int code) {
		return  (char)code;
	}
	*/
}
