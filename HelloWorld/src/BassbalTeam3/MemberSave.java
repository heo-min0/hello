package BassbalTeam3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class MemberSave {

	File file;
	
	public MemberSave() {
		creatfile("C:\\Java\\tmp\\BaseballTeam.txt");
	}
	
	public void creatfile(String path) {
		file = new File(path);
		try { 
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void clearfile() { //저장하기 전에 파일에 있는거 다 지우기
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write("");
			bw.close();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void writefile(String text) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			pw.println(text);
			pw.close();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public int readfile(File file, Map human) { //파일에서 읽어서 객체에 다시 넣기
		HumanDto hp = null;
		int number = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str;
			while((str = br.readLine()) != null) {
				String s[] = str.split(","); // 분리하여 배열에 넣기
				if(s[0].equals("0")) { //aaaaa0은 투수 1은 타자
					number = Integer.parseInt(s[1]);
					String name = s[2];
					int age = Integer.parseInt(s[3]);
					double height = Double.parseDouble(s[4]);
					int win = Integer.parseInt(s[5]);
					int lose = Integer.parseInt(s[6]);
					double defence = Double.parseDouble(s[7]);
					hp = new Pitcher(number, name, age, height, win, lose, defence);
				}
				else if (s[0].equals("1")) {
					number = Integer.parseInt(s[1]);
					String name = s[2];
					int age = Integer.parseInt(s[3]);
					double height = Double.parseDouble(s[4]);
					int batCounter = Integer.parseInt(s[5]);
					int hit = Integer.parseInt(s[6]);
					double hitAvg = Double.parseDouble(s[7]);
					hp = new Batter(number, name, age, height, batCounter, hit, hitAvg);
					number -= 1000;
				}
				human.put(number, hp);
			} br.close();
		} catch (IOException e) {e.printStackTrace();}
		//if (number>2000) { number -= 1000; }
		return number;
	}

}
