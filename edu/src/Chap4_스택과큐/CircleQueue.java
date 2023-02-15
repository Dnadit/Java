package Chap4_스택과큐;

import java.util.Random;
import java.util.Scanner;

public class CircleQueue {
	private Point[] que ; // Point 타입인 배열 que.
	private int front, rear ;
	private int capacity;
	private boolean isEmpty;
	
	public int getCapacity() {
		return capacity;
	}
	public int size() {
		return rear - front ;
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
		if (rear%capacity == front && !isEmpty) 
			throw new OverflowIntQueueException();	
		isEmpty = false;		
		que[rear++] = temp;
		System.out.println("rear : " + rear + ", front : " + front);
		return temp ;
	}
	//디큐
	public Point deque() throws OverflowIntQueueException {
		if (rear == front) {
			rear = 0;
			front = 0;
			throw new EmptyIntQueueException();
		}
		isEmpty = true;
		Point temp = que[front++];
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
