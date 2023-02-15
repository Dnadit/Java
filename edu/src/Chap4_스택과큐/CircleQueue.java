package Chap4_스택과큐;

import java.util.Random;
import java.util.Scanner;

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
	}
	// 인큐
	public Point enque(Point x) throws OverflowIntQueueException {
		if (rear == front && !isEmpty) 
			throw new OverflowIntQueueException();	
		isEmpty = false;
		que[rear++] = x;		
		return x ;
	}
	//디큐
	public Point deque(Point x) throws OverflowIntQueueException {
		if (rear == front) 
			throw new EmptyIntQueueException();	
		isEmpty = true;
		que[front++] = x;	
		return x ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rndx, rndy ;
		Random random = new Random();
		Point p = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("1.인큐 2.디큐");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			rndx = random.nextInt() % 20;
			rndy = random.nextInt() % 20;
			p = new Point(rndx, rndy);
		}
	}
}
