package work;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class file {

	public static void main(String[] args) {
		// 파일생성    이름나이주소1명분    데이터 저장
		// 읽기
		// 쓰기 읽기가 목적 어떻게 하면 효율적으로 2차배열로 사용할 수 있을까?
		
		String adr[] = {"홍길동", "24", "경기도"};
		
		File file = creatFile("address");
		saveFile(file, adr);
		readFile(file);
	}

	static void readFile(File file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = "";
			while((str = br.readLine()) != null) {
				System.out.println(str);			
			}
			br.close();
		} catch (IOException e) { e.printStackTrace(); }
	}

	static void saveFile(File file, String[] adr) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			for (int i = 0; i < adr.length; i++) {
				pw.print(adr[i]);
				pw.print(" ");
			}
			pw.close();
		} catch (IOException e) {e.printStackTrace();}
	}

	static File creatFile(String title) {
		File file = new File("c:\\Java\\tmp\\"+title+".txt");
		try {
			file.createNewFile();
		} catch (IOException e) {e.printStackTrace();}
		return file;
	}
}
