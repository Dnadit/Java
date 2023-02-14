package Chap4_스택과큐;

public class CircleQueue {
	private Point[] que ; // Point 타입인 배열 que.
	private int front, rear ;
	private boolean isEmpty;
	
	
	// --- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {
		}
	}

	// --- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {
		}
	}
	
	// 생성자
	public CircleQueue() {
		isEmpty = true ;		
		que = new Point[6];
		que[0] = new Point(1,2);
		Point temp = new Point(1, 2); 
	}
	// 인큐
	public Point enque(Point x) throws OverflowIntQueueException {
		if (rear == front && !isEmpty) 
			throw new OverflowIntQueueException();	
		isEmpty = false;
		que[rear++] = x;
		if (rear%que. == front)
		return x ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
