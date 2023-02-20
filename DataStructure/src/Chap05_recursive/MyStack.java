package Chap05_recursive;

class MyStack {		
	//--- 실행시 예외: 스택이 비어있음 ---//		
	public class EmptyMyStackException extends Exception {
		private static final long serialVersionUID = 1L;
		public EmptyMyStackException() {			
		}
	}

	//--- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowMyStackException extends RuntimeException {			
		private static final long serialVersionUID = 1L;
		public OverflowMyStackException() {
		}
	}

    private Point data[];           // 스택용 배열
	//private List<T> data;
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	//--- 생성자(constructor) ---//
	public MyStack(int capacity) {
		top = 0;
		this.capacity = capacity;
		// this.data = new T[capacity]; // 스택 본체용 배열을 생성
		try {
			data = new Point[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}	
	}

	//--- 스택에 x를 푸시 ---//
	public Point push(Point x) throws OverflowMyStackException {		
		if (top >= capacity)
			throw new OverflowMyStackException();
		return data[top++] = x;			
	}
	
	//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point pop() throws EmptyMyStackException  {
		if (top <= 0)
			throw new EmptyMyStackException();
		return data[--top];
	}
	
	public void clear() {
		top = 0;
	}
}
