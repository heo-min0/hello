package work;

public class Stack {
	public static void main(String[] args) {
		

	}
}

class arrStack{
	private int top;
	private Object arr[];
	private int maxSize;
	
	// 배열 결정, 들어가는거, 나가는거, 없는지, 풀인지, 값나오는거
	public arrStack(int maxSize) { //배열 선언 및 맨위에 보이는 값 초기화
		arr = new Object[maxSize];
		top = -1;
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean full() {
		return (top == maxSize-1);
	}
	
	public void push(Object item) {
		if(full()) {
			System.out.println("가득차있음");
			return;
		}
		top++;
		arr[top] = item;
	}
	public Object pop() {
		Object item = arr[top];
		top--;
		return item;
	}	
	public Object peek() {
		if(isEmpty()) {
			System.out.println("아무것도 없음");
			return null;
		}
		return arr[top];
	}
}

class arrQueue{ //배열 결정 초기화, 없는지, 풀인지, 값나오는거, 들어가는거, 나가는거
	private int front;
	private int rear;
	private int max;
	private Object arr[];
	
	public arrQueue(int max) {
		front = 0;
		rear = -1;
		this.max = max;
		arr = new Object[max];
	}
	public boolean isEmpty() {
		return front == rear+1; 
	}
	public boolean full() {
		return rear == max-1;
	}
	public void push(Object item) {
		if (full()) {
			System.out.println("가득참");
			return;
		}
		rear++;
		arr[rear] = item;
	}
	public Object pop() {
		Object item = peek();
		front++;
		return item;
	}
	public Object peek() {
		if (isEmpty()) {
			System.out.println("비어있음");
			return null;
		}
		return arr[front];
	}
	
	
	
	
	
	
	
	
}
