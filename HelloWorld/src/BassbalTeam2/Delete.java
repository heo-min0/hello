package BassbalTeam2;

public class Delete {

	public Delete() {
		Singleton sc = Singleton.getinstance();
		sc.search();
		if (sc.index[0] < 0) { // 전부 -1, 일치하는게 없는거
			System.out.println("해당 선수를 찾을 수 없습니다.");
			return;
		} else if (sc.index[1] > 0) { // 1번지가 값이 있을때, 최소 2개 이상
			int num = (int)sc.chkNum("몇 번째 선수를 삭제할까요?") - 1;
			int n = sc.index[num];
			sc.human.remove(n);
			System.out.println("삭제가 완료되었습니다.");
			return;
		} // 지나왔다면 값이 1개라는거라서 바로 삭제
		sc.human.remove(sc.index[0]);
		System.out.println("삭제가 완료되었습니다.");
	}

}
