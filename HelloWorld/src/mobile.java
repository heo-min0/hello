import java.util.Arrays;

public class mobile {
	
	public static void main(String[] args) {
			// 피보나치 수열 fibonnaci
			// 0 1 1 2 3 5 8 13
			long a, b, c;
			int index = 20;
			a=1; b=1;
			
			long fib[] = new long[index];
			fib[0] = a;
			fib[1] = b;
			
			int w = 2;
			while(w<index) {
				c = a + b;
				fib[w] = c;
				a=b;
				b=c;
				w++;
			}
			System.out.println(fib[19]);
			
			System.out.println(Arrays.toString(fib));
			System.out.println(fib.length);
			System.out.println("20번째 수 : " +fib[index-1]);
	}
	
}
interface Mova{
	double x = 0, y=0;

	
	void move(double dx,double dy);
}

class Movepoi implements Mova {
	Movepoi(){ }
	
	@Override
	public void move(double dx, double dy) {
		// TODO Auto-generated method stub
		
	}
	
}