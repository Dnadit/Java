package Chap05_recursive;

public class MyStack1 {
	private int top;
	private Point1[] data; // Point type 배열 만들어주는 이유 ?
	
	public MyStack1() {
		top = 0;
		data = new Point1[100];
	}
	
	public void push(Point1 p) {
		data[top++] = p;
	}
	
	public Point1 pop() {
		return data[--top];
	}	
	
	public boolean isEmpty() {
		if(top == 0)
			return true;
		return false;
	}
}
