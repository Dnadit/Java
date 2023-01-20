package edu;
// switch~case문 연습
public class Test22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 12;
		int b = 2;
		char op = '1';
		
		switch(op) {
		case '+' :
			System.out.println(a + b); break;
		case '-' :
			System.out.println(a - b); break;
		case '*' :
			System.out.println(a * b); break;
		case '/' :
			System.out.println(a / b); break;
		default:
			System.out.println("해당 연산이 없습니다."); break;
		}
	}

}
