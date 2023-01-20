package edu.mission;

import java.util.Scanner;

public class BinaryNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("이진수로 변환할 수를 입력해주세요.");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		
		
		String str = "";
		while(n >= 1) {
			int remainder = n % 2;
			int quotient = n / 2;
			n = quotient;
			//str = str + remainder; 0(remainder) 0+1(remainder) 01+0(remainder) 010+1(remainder)
			str = remainder + str; // (remainder)0 (remainder)1+0 (remainder)0+10 (remainder)1+010							
		}
		System.out.println(str);
	}

}
