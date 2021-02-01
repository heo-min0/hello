package work;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Binary {

	public static void main(String[] args) {
		/*
		File file = new File("c:\\");
		String filelist[] = file.list(); // 파일조사
		
		File list[] = file.listFiles();
		 
		//파일포인터생성 얻어오기
		File newfile = new File("c:\\tmp\\newfile.txt");
		
		//newfile.createNewFile(); 파일생성
		File newDir = new File("c:\\tmp\\tmp1\\sub");
		newDir.mkdirs();//폴더생성
		
		if(newfile.exists()) {} //파일 존재 여부
		if(newfile.canWrite()) {} //쓰기가능여부 
		newfile.setReadOnly(); //읽기전용만들기
		newfile.delete(); //삭제
		
		try {
			FileWriter fw = new FileWriter(file); //파일이 없어도 자동생성함
			fw.write("안녕하세요\n");
			fw.close();
			
			BufferedWriter bw = new BufferedWriter(fw); //버퍼는 저장공간
			PrintWriter pw = new PrintWriter(bw);// 그 저장공간에 라이터 하겠다
			pw.println("안녕하세요");
			pw.close();
			bw.close();
			fw.close();
			// FileWriter fw = new FileWriter(file, true); 추가쓰기
			//읽기
			//한글자씩
			FileReader fr = new FileReader(file);
			int ch = fr.read();
			//문장으로
		} catch (IOException e) {e.printStackTrace();}
		*/
		//10진수 2진수 함수
		int num10 = 23;
		String num2 = num10t02(num10);
		//System.out.println(num2);
		int num1010 = num2to10(num2);
		System.out.println(num1010);
	}
		
	static String num10t02 (int num10) {
		String num2 = "";
		while(true) {
			int k = num10%2;
			num2 = k + num2;
			if(num10/2 == 0) break;
			num10 = num10/2;
		} return num2;
	}

	static int num2to10(String num2) {
		int len = num2.length()-1;
		int num10 = 0;
		for (int i = 0; i < num2.length(); i++) {
			char c = num2.charAt(i);
			
			int n = Integer.parseInt(c+"");
			int n1 = (int)Math.pow(2, len);
			
			n = n*n1;
			len--;
			num10 = num10 + n;
		}
		return num10;
	}

	
	
	
}
