package com.ruby.java.ch13;
/*
generic 은 데이터 타입을 매개변수로 지정, 
엄격한 타입검사를 통해 안전성을 높여줌, 
잘못된 코드이지만 컴파일러가 오류라고 해석하지 않는 코드도 제네릭을 사용하면 오류로 해석해줌.
*/
class Bag<T> {
	private T thing;

	public Bag(T thing) {
		this.thing = thing;
	}

	public T getThing() {
		return thing;
	}

	public void setThing(T thing) {
		this.thing = thing;
	}

	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
}

class Book {
}

class PencilCase {
}

class Notebook {
}

public class BagTest {

	public static void main(String[] args) {
		Bag<Book> bag = new Bag<>(new Book());
		Bag<PencilCase> bag2 = new Bag<>(new PencilCase());
		Bag<Notebook> bag3 = new Bag<>(new Notebook());

		bag.showType();
		bag2.showType();
		bag3.showType();
		
//		bag = bag2;
	}
}