package com.ruby.java.ch07.inheritance;

public class Employee extends Person {
	private String dept;
	
	public Employee () {
//		super(); // 코드가 없어도 실행 시 컴파일러가 자동으로 추가하여 실행함.
		System.out.println("Employee 생성자 실행!");
	}
	public Employee(String name, int age, String dept) {
		super(name, age);
		this.dept = dept;		
		System.out.println("Employee(name, age, dept) 생성자 실행!");
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public String toString() {
		return super.toString() + " dept = " + this.dept;
	}
}