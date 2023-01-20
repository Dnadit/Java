package edu.mission;

import java.util.Scanner;

// 최대공약수 & 최소공배수
// 두 개의 정수를 입력 받아서 최대공약수와 최소공배수를 구해서 출력.
/* 유클리드 호제법
 * 1. 입력 받은 두 개의 정수 중 큰 정수를 max, 작은 정수를 min
 * 2. max%min = rem
 * 3. rem이 0이면 최대공약수=작은 정수, 최소공배수 = 두 정수의 곱/최대공약수
 * 4. rem이 0이 아니면 max = min, min = rem, 2번 반복*/
public class GcdLcm {
//메소드 만들어서, 클래스 만들어서, main안에 넣어서..
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("첫 번째 숫자를 입력하세요.");
		int num1 = sc.nextInt();
		System.out.println("두 번째 숫자를 입력하세요.");
		int num2 = sc.nextInt();		
		
		int maxnum, minnum;		
		if(num1/num2 > 1) {
			maxnum = num1;
			minnum = num2;
		}
		else {
			maxnum = num2;
			minnum = num1;
		}
		
		int rem, gcd, lcm;		
		while(true) {
			rem = maxnum%minnum;
			if(rem == 0) {
				gcd = minnum;
				lcm = (num1*num2)/gcd;
				break;				
			}
			else {
				maxnum = minnum;
				minnum = rem;
				rem = maxnum%minnum;
			}
		}
		System.out.println("최대공약수 : " + gcd + ", 최소공배수 : " + lcm);
	}

}
