package edu.mission;


import java.util.Scanner;

//소수 판단
//임의의 수를 입력 받아서 해당 수가 소수인지 확인하는 프로그램을 작성해 보세요.
//출력 예 입력 7 >> 소수입니다. 입력 9 >> 소수가 아닙니다.
public class PrimeNum {
	static int num;
	public static String result() {
		for(int i=2; i < num; i++) {
			if(num%i == 0) {         //소수가 아님.
				return "소수가 아닙니다."; //2~(num-1)의 수로 차례대로 나누었을때 나머지가 0인 경우가 나오면 반환.(나누어 떨어지는 수가 하나라도 있으면)
			}
		}
		return "소수입니다.";	// 위의 조건식에 해당되지 않을 때, 반환. (모두 다 안나누어 떨어질때)
	}
	public static void main(String[] args) {
		try (Scanner kb = new Scanner(System.in)) {
			System.out.println("Number:");			
			while((num = kb.nextInt()) > 1) {
				result();
				System.out.println(num + " is " + result());
				System.out.println("Number:");
			}
		}
		System.out.println("1보다 큰 자연수를 입력해주세요.");
	}
}
