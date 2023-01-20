package edu.mission;

import java.util.Scanner;

// 최소 지폐 수 계산
// 상품 가격 152,365원을 지불하기 위해 필요한 최소 지폐 장수는 아래와 같다.
// 천원 미만은 할인하고 임의의 금액을 지불하기 위해 필요한 지폐 장수를 구하는 프로그램을 작성하세요.
public class MinBill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 변수 선언 및 초기화		
		Scanner sc = new Scanner(System.in);
		System.out.println("금액 입력");
		int total = sc.nextInt();

		int oman = 50000;
		int man = 10000;
		int ocheon = 5000;
		int cheon = 1000;
		//5만원권 매수 계산 및 토탈 초기화
		int cnt50 = total / oman;
		System.out.println("5만원 * " + cnt50 + "장");
		total -= oman * cnt50;
		//1만원권 매수 계산 및 토탈 초기화
		int cnt10 = total / man;
		System.out.println("1만원 * " + cnt10 + "장");
		total -= man * cnt10;
		//5천원권 매수 계산 및 토탈 초기화
		int cnt5 = total / ocheon;
		System.out.println("5천원 * " + cnt5 + "장");
		total -= ocheon * cnt5;
		//1천원권 매수 계산 및 토탈 초기화
		int cnt1 = total / cheon;
		System.out.println("1천원 * " + cnt1 + "장");
		total -= cheon * cnt1;		
	}

}
