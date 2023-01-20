package com.ruby.java.ch09;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = new String("java");
		String s2 = "java";
		String s3 = new String("java");
		String s4 = "java";
		
		if(s1 == s3) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		if(s2 == s4) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		
		if(s1.equals(s3)) {
			System.out.println("동일 문자열을 가진다.");
		} else {
			System.out.println("다른 문자열을 가진다.");
		}
		if(s2.equals(s4)) {
			System.out.println("동일 문자열을 가진다.");
		} else {
			System.out.println("다른 문자열을 가진다.");
		}
		
		String s5 = "JAVA";
		if(s1.equals(s5)) {
			System.out.println("동일 문자열을 가진다.");
		} else {
			System.out.println("다른 문자열을 가진다.");
		}
		if(s1.equalsIgnoreCase(s5)) {
			System.out.println("동일 문자열을 가진다.");
		} else {
			System.out.println("다른 문자열을 가진다.");
		}
	}

}
