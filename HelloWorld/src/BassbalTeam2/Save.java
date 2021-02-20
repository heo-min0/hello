package BassbalTeam2;

public class Save {

	public Save() {
		Singleton sc = Singleton.getinstance();
		Fileproc ms = new Fileproc();
		ms.clearfile(); // 저장 전 파일 초기화
		for (int i = 0; i < sc.human.size(); i++) {
			if (sc.human.get(i) instanceof Pitcher) {
				String text = ((Pitcher) sc.human.get(i)).saveString();
				ms.writefile(text);
			} else if (sc.human.get(i) instanceof Pitcher) {
				String text = ((Pitcher) sc.human.get(i)).saveString();
				ms.writefile(text);
			}
		}System.out.println("저장되었습니다.");
	}

}
