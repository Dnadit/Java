//포인트 타입의 객체를 포함한 배열로 원형큐 구현하기.

package Chap04_스택과큐;

import java.util.Random;
import java.util.Scanner;

class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	public String toString() {
		return "<" + ix + ", " + iy + ">";
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
}

public class CircleQueue {
	private Point[] que ; // Point 타입인 배열 que.
	private int front, rear ;
	private int capacity;
	private boolean isEmpty;
	
	public int getCapacity() {
		return capacity;
	}
	public int size() {
		if (isEmpty && rear == front)
			return 0;
		if (rear <= front)
			return rear+capacity - front;
		return rear - front;
	}
	
	
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
	public CircleQueue(int maxlen) {	
		capacity = maxlen;
		isEmpty = true ;		
		que = new Point[capacity];		
	}
	// 인큐
	public Point enque(Point temp) throws OverflowIntQueueException {		
		if (rear == front && !isEmpty) {
			System.out.println("rear : " + rear + ", front : " + front);			
			throw new OverflowIntQueueException();
		}
		isEmpty = false;
		que[rear++] = temp;
		rear = rear%capacity;
		System.out.println("rear : " + rear + ", front : " + front);
		return temp ;
	}
	//디큐
	public Point deque() throws OverflowIntQueueException {		
		if (rear == front && isEmpty) {
			rear = 0;
			front = 0;
			isEmpty = true;
			System.out.println("rear : " + rear + ", front : " + front);
			throw new EmptyIntQueueException();
		}
		isEmpty = true;
		Point temp = que[front++];
		front = front % capacity;
		System.out.println("rear : " + rear + ", front : " + front);
		return temp ;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleQueue s = new CircleQueue(6);
		int rndx, rndy ;
		Random random = new Random();
		Point p = null;		
		Scanner sc = new Scanner(System.in);		
		while (true) {
			System.out.printf("현재 데이터 : %d / %d\n", s.size(), s.getCapacity());
			System.out.println("1 인큐 2 디큐");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				rndx = random.nextInt() % 20;
				rndy = random.nextInt() % 20;
				p = new Point(rndx, rndy);
				try {
					s.enque(p);
					System.out.println("인큐한 데이터는 " + p + "입니다.");
				} catch(CircleQueue.OverflowIntQueueException e) {	
					System.out.println("que가 가득찼습니다.");
				}
				break;
			case 2: 
				try {
					p = s.deque();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch(CircleQueue.EmptyIntQueueException e) {
					System.out.println("que가 비었습니다.");
				}
			}
		}
	}
}
