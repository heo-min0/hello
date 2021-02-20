package BassbalTeam2;

import java.io.File;

public class Load {
	Singleton sc = Singleton.getinstance();
	public Load() {
	}
	public Load(String path) {
		File file = new File(path);
		if(file.exists()) {
			Fileproc ms = new Fileproc();
			sc.number = ms.readfile(file, sc.human)+1;
		}else sc.number = 1001;
	}

}
