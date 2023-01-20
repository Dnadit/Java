package com.ruby.java.ch09;

public class MyObject {
//	public String toString() {		
//		return "MyObject " + super.toString(); //super는 부모클래스의 toString(); 호출
		
	int num;
	
	MyObject(int num) {
		this.num = num;
	}
	
	public String toString() {
		return "MyObject";
	}
	
	public boolean equals(Object obj) {
		boolean result = false;
		MyObject arg = (MyObject) obj;
		
		if(this.num == arg.num) {
			result = true;
		}
		return result;
	}
}
