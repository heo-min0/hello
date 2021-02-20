import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ex12_Hashmap {

	public static void main(String[] args) {
		//사과 복숭아 배 딸기 망고
		Map<String, String> h = new HashMap<String, String>();
		
		h.put("apple", "사과");
		h.put("peach", "복숭아");
		h.put("peal", "배");
		h.put("strawberry", "딸기");
		h.put("mango", "망고");
		
		Iterator<String> it = h.keySet().iterator();
		while (it.hasNext()) {
			String k = it.next();
			String v = h.get(k);
			System.out.println(k + ": " + v);
		}
		
		

	}

}
