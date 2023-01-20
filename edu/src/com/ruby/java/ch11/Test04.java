package com.ruby.java.ch11;

import java.io.FileInputStream;
import java.io.IOException;

public class Test04 {
	
	public static void test() {
		try {
			FileInputStream fi = new FileInputStream("a.txt");
			int c = fi.read();
			System.out.println((char) c);
		} catch(Exception e) {
			System.out.println("지정된 파일을 찾을 수 없습니다.");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

}
