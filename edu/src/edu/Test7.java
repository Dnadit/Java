package edu;

public class Test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		a++;
		System.out.println(a); // 11
		++a;
		System.out.println(a); // 12
		
		int b = 10;
		b--;
		System.out.println(b); // 9
		--b;
		System.out.println(b); // 8
		
		int c = 10;
		int d = 10;
		System.out.println(++c); // 11 line에서 먼저 더하고 처리
		System.out.println(d++); // 10 line을 처리하고(;끝나고 난 다음)다음 부터 1이 더해짐.
		System.out.println(d);
	}

}
