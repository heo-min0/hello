package BassbalTeam;

public class MainClass {
	
	public static void main(String[] args) {
		new MainClass().menu();
	}

	void menu() {
		MemberDao mDao = new MemberDao("C:\\Java\\tmp\\BaseballTeam.txt"); //D:\\temp\\BaseballTeam.txt"
		while(true) {
			int workNum = mDao.printMenu();
			boolean close = false;
			switch(workNum) {
				case 1 : mDao.insert(); 	break;
				case 2 : mDao.delete(); 	break;
				case 3 : mDao.select(); 	break;
				case 4 : mDao.update();	 	break;
				case 5 : mDao.printAll();	break;
				case 6 : mDao.save();		break;
				case 7 : mDao.sorting();	break;
				case 8 : close = true;		break;
			}
			if(close) {
				System.out.println("종료합니다.");
				break;
			}
		}
	}
	
}
