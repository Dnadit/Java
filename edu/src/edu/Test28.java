package edu;
// 반복문 탈출하기
public class Test28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cnt = 0;
		while(true) {
			System.out.println("OK");
			cnt = cnt + 2;
			if(cnt == 10) {
				break;
			}
		}
	}

}
