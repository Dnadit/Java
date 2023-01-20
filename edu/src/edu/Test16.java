package edu;
// type casting을 연습하는 코드입니다.
public class Test16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte a = 23;
		int b = a;
		System.out.println(b);
		
		byte c = 23;
		short d = 47;
		int e = 65;
		int f = c + d + e;
		System.out.println(f);
		
		int g = 23;
		byte h = (byte) g;
		System.out.println(h);
		
		byte i = 10;
		byte j = 20;
		byte k = (byte) (i + j);
		System.out.println(k);
	}

}
