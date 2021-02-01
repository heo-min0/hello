import java.util.Arrays;

public class ex9_method {

	public static void main(String[] args) {
		// 2차원배열 > 1차원배열
		int arr2[][] = { { 1, 2, 3, 4},
						 { 5, 6, 7, 8},
						 { 9,10,11,12} };
		
		int arr1[] = array2ToArray1(arr2);
		System.out.println(Arrays.toString(arr1));
		
		//암호화
		String src = "abc123";
		String result = encoding(src);
		System.out.println("result:" + result);
		
		//복호화
		String base = descrambling(result);
		System.out.println("basecode:"+base); //baseCode
	}

	static String descrambling(String result) {
		char[] abcCode = { '`','~','!','@','#','$','%','^','&','*',
				   '(',')','-','_','+','=','|','[',']','{',
				   '}',';',':',',','.','/'};
		char[] numCode = { 'q','w','e','r','t','y','u','i','o','p' };
		
		String basecode = "";
		for (int i = 0; i < result.length(); i++) {
			char ch = result.charAt(i); // a 97  z 122  0 48 9 57
			if(ch>=97 && ch<=122) {  //문자를 숫자로
				for (int j = 0; j < numCode.length; j++) {
					if(ch==numCode[j]) {
						basecode = basecode + (char)(48+j);
						break;
					}
				}
			}else {
				for (int j = 0; j < abcCode.length; j++) {
					if(ch==abcCode[j]) {
						basecode = basecode + (char)(97+j);
						break;
					}
				}
			}
		}
		return basecode;
	}

	static String encoding(String src) {
		String result = "";
		
		char[] abcCode = { '`','~','!','@','#','$','%','^','&','*',
				   '(',')','-','_','+','=','|','[',']','{',
				   '}',';',':',',','.','/'};
		char[] numCode = { 'q','w','e','r','t','y','u','i','o','p' };

		for (int i = 0; i < src.length(); i++) {
			char ch = src.charAt(i); // a 97  z 122  0 48 9 57
			if(ch>=97 && ch<=122) {
				result = result + abcCode[ch-97];
			}else if(ch>=48 && ch<=57) {
				result = result + numCode[ch-48];
			}
		}		
		return result;
	}

	static int[] array2ToArray1 (int[][] arr2) {
		int arr1[] = new int [arr2.length * arr2[0].length];
		
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				arr1[arr2[0].length*i + j] = arr2[i][j];
				System.out.print(arr2[0].length*i + j + " ");
			}
		}
		
		return arr1;
	}
	

	

}
