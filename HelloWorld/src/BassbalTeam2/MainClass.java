package BassbalTeam2;

public class MainClass {
	
	public static void main(String[] args) {
		new MainClass().menu();
	}

	void menu() {
		new Load("C:\\Java\\tmp\\BaseballTeam.txt"); //D:\\temp\\BaseballTeam.txt"
		while(true) {
			Print p = new Print();
			int workNum = p.printMenu();
			switch(workNum) {
				case 1 : new Insert(); 	break;
				case 2 : new Delete(); 	break;
				case 3 : new Select(); 	break;
				case 4 : new Update();	break;
				case 5 : p.PrintAll();	break;
				case 6 : new Save();	break;
				case 7 : new Soorting();break;
				case 8 : System.exit(0);break;
			}
			
		}
	}
	
}
