package com.ruby.java.test1;

public class Armor {
	private String name;
	private int height;
	private int weight;
	private String color;
	private boolean isFly;
	double speed;	
	
	public void setHeight (int value) {
		height = value;
	}
	public void setName () {
		String value = "mark6";
		name = value;
	}
	public int takeoff (int value) {
		System.out.println("엔진 시동: value = " + value);		
		return value - 50; // return <<
	}
	
}
