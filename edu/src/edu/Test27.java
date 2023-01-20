package edu;
// for, while, do~while문 연습
public class Test27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// for 문
		for(int i = 8; i < 10; i++) {
			System.out.println("for OK");
		}
		// while 문
		int j = 10;
		while(j < 10) {
			System.out.println("while OK");
			j++;
		}
		// do~while 문
		int k = 10;
		do {
			System.out.println("do~while OK");
			k++;
		} while(k < 10);
	}
}
