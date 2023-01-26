package com.ruby.java.ch13;
// non Generic
class Bag2 {
	private Object thing;

	public Bag2(Object thing) {
		this.thing = thing;
	}

	public Object getThing() {
		return thing;
	}

	public void setThing(Object thing) {
		this.thing = thing;
	}

	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
}

class Book2 {
}

class PencilCase2 {
}

class Notebook2 {
}

public class BagTest2 {

	public static void main(String[] args) {
		Bag2 bag = new Bag2(new Book2());
		Bag2 bag2 = new Bag2(new PencilCase2());
		Bag2 bag3 = new Bag2(new Notebook2());

		bag.showType();
		bag2.showType();
		bag3.showType();
		
		bag = bag2;//error를 발생시키지 않지만 잘못된 코드이다, 논리적 모순이 있음. << 제네릭을 쓰면 오류를 잡을 수 있음.
		/*
		Book book = bag.getThing();  // Object Type을 하위클래스인, Book Type으로 할당 못함.
		PencilCase pc = bag2.getThing();
		Notebook nb = bag3.getThing();
		*/
		Book book = (Book)bag.getThing();             // type casting
		PencilCase pc = (PencilCase)bag2.getThing();
		Notebook nb = (Notebook)bag3.getThing();
	}
}