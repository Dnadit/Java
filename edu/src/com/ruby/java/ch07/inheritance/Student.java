package com.ruby.java.ch07.inheritance;

public class Student extends Person {
	public Student(String name, int age, String major) {
//		super.setName(name);
//		super.setAge(age);
		super(name, age);
		this.major = major;
		System.out.println("Student(name, age, major) 생성자 실행!");
	}
	public Student() {
		super();
		System.out.println("Student 생성자 실행!");
	}
	private String major;

	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String toString() {
		return super.toString() + " major = " + major;
	}
}