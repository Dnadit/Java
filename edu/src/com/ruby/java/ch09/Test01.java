package com.ruby.java.ch09;
//JAVA api 수업
public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();	
		
		//hashCode 객체를 표현하는 대푯값, 주소와 관련이 있음(주소를 해쉬코드로 인코딩하여 보내줌)
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());
		
		Class c = obj1.getClass();
		System.out.println(c.getName()); 
		// 위 2줄과 같은 코드
		System.out.println(obj1.getClass().getName());
		
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		System.out.println(obj3.toString());
		
		MyObject obj4 = new MyObject(123);
		MyObject obj5 = new MyObject(123);
		
		if(obj4.equals(obj5)) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		
		if(obj4 == obj5) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		
	}
	

}
