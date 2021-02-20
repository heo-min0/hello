package BassbalTeam2;

public class Print {
	Singleton sc = Singleton.getinstance();
	public Print() {}
	
	public void PrintAll() {
		for (int i = 0; i < sc.human.size(); i++) {
			HumanDto hd = (HumanDto) sc.human.get(i);
			System.out.println(hd.toString());
		}
	}
	public int printMenu() { // 추가 삭제 검색 수정, 출력, 저장, 정렬, 종료
		System.out.println("========================== M E N U =====================================");
		System.out.println("| 1.선수추가  2.선수삭제  3.선수검색  4.선수수정  5.선수출력  6.저장  7.정렬  8.종료 |");
		System.out.println("========================================================================");
		int workNum = (int) sc.chkNum("입력");
		if (workNum < 0) {
			workNum = 8; // 강제종료
			System.out.print("입력이 올바르지 않아 프로그램을 ");
		}
		return workNum;
	}
}
