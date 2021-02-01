
public class ex4_arrayString {

	public static void main(String[] args) {
		
		/*int Array[] = new int[5];
		
		System.out.println(Array);
		// [I@ 28 a4 18 fc > 4byte 배열의 heap영역 주소
		
		
		char cArray[] = new char[5];
		cArray[0] = 'h';
		cArray[1] = 'e';
		cArray[2] = 'l';
		cArray[3] = 'l';
		cArray[4] = 'o';
		
		char ch[] = {'w', 'o', 'r', 'l', 'd'};
		*/
		/*
		char c = 'c';
		c = (char)(c-32);
		System.out.println(c);
		
		c='D';
		c = (char)(c+32);
		System.out.println(c);
		*/
		/*
		int array[] = {3,7,8,9,14};
		int ran = (int)(Math.random()*5);
		int ran1 = array[ran];
		System.out.println(ran1);
		*/
		/*
		int a[] = {111,222,333};
		int b[] = a;
		System.out.println(b.length);
		*/
		/*
		String str = "world";
		String str1 = "worl";
		System.out.println();
		*/
		
		int num = 10;
		System.out.println(num);
		
		String n2 = Integer.toBinaryString(num);
		String n8 = Integer.toOctalString(num);
		String n16 = Integer.toHexString(num);
		
		System.out.println(n2);  //
		System.out.println(n8);  //8
		System.out.println(n16);  //16
		
		int m2 = Integer.parseInt(n2, 2);
		int m16 = Integer.parseInt(n16, 16);
		System.out.println(m2);
		System.out.println(m16);
	}

}
