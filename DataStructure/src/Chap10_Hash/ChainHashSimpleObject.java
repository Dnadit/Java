package Chap10_Hash;

import java.util.Comparator;
//hash node가 student 객체일 때를 구현하는 과제
//체인법에 의한 해시
import java.util.Scanner;

class SimpleObject2 {

	String sno; // 회원번호
	String sname; // 이름

	public SimpleObject2(String sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}

	public SimpleObject2(SimpleObject2 s) {
		this.sno = s.sno;
		this.sname = s.sname;
	}

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + sno + ") " + sname;
	}

	public int keyCode() {
		return Integer.parseInt(sno);
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject2> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject2> {
		public int compare(SimpleObject2 d1, SimpleObject2 d2) {
			return (d1.sno.compareTo(d2.sno) > 0) ? 1 : ((d1.sno.compareTo(d2.sno) < 0)) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject2> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject2> {
		public int compare(SimpleObject2 d1, SimpleObject2 d2) {
			return (d1.sname.compareTo(d2.sname) > 0) ? 1 : ((d1.sname.compareTo(d2.sname) < 0)) ? -1 : 0;
		}
	}
}

class ChainHash2 {
//--- 해시를 구성하는 노드 ---//
	class Node2 {
		private SimpleObject2 data; // 키값
		private Node2 next; // 뒤쪽 포인터(뒤쪽 노드에 대한 참조)

		// --- 생성자(constructor) ---//
		public Node2(SimpleObject2 s) {
			this.data = s;
			this.next = null;
		}

		Node2(SimpleObject2 s, Node2 p) {
			this.data = s;
			this.next = p;
		}

		Node2() {
			this.data = null;
			this.next = null;
		}

		// --- 키값을 반환 ---//
		Integer getKey() {
			return data.keyCode();
		}

		// --- 키의 해시값을 반환 ---//
		public int hashCode() {
			int hash = 31;
			hash = 31 * hash * getKey();
			hash = hash * hash;
			return hash;
		}
	}

	private int size; // 해시 테이블의 크기
	private Node2[] table; // 해시 테이블

//--- 생성자(constructor) ---//
	public ChainHash2(int capacity) {
		try {
			table = new Node2[capacity];
			this.size = capacity;
		} catch (OutOfMemoryError e) { // 테이블을 생성할 수 없음
			this.size = 0;
		}
	}

//--- 해시값을 구함 ---//
	public int hashValue(Object key) {
		int hash = 31;
		hash = 31 * hash * (int) key;
		hash = hash * hash;
		return hash;

	}

//--- 키값이 key인 요소를 검색(데이터를 반환) ---//
	public int search(SimpleObject2 st, Comparator<SimpleObject2> c) {
		int hash = hashValue(st.keyCode()) % 11; // 검색할 데이터의 해시값
		Node2 p = table[hash]; // 선택 노드

		while (p != null) {
			if (c.compare(p.data, st) == 0)
				return 0; // 검색 성공
			p = p.next; // 다음 노드를 선택
		}
		return 1; // 검색 실패
	}

//--- 키값이 key인 데이터를 data의 요소로 추가 ---//
	public int add(SimpleObject2 st, Comparator<SimpleObject2> c) {
		int hash = hashValue(st.keyCode()) % 11; // 추가할 데이터의 해시값
		Node2 p = table[hash]; // 선택 노드
		
		while (p != null) {
			if (c.compare(p.data, st) == 0)		// 이미 존재하는 key(SimpleObject2)임.
				return 1;
			p = p.next;
		}
		Node2 temp = new Node2(st);		// st를 키로 가지고 있는 노드 생성.
		temp.next = table[hash];				// 기존 table[hash]의 주소값을 temp가 가르키게 함.
		table[hash] = temp;				// table[hash]는 temp의 주소값을 가르키게함.(맨 앞에 삽입)
		return 0;
	}

//--- 키값이 key인 요소를 삭제 ---//
	public int remove(SimpleObject2 st, Comparator<SimpleObject2> c) {
		int hash = hashValue(st.keyCode()) % 11; // 삭제할 데이터의 해시값
		Node2 p = table[hash]; // 선택 노드
		Node2 pp = null; // 바로 앞의 선택 노드
		if (p == null) {
			return 1;
		}
		while (p != null) {	
			if (c.compare(p.data, st) == 0) {
				if (pp == null)
					table[hash] = p.next;
				else 
					pp.next = p.next;
				return 0;		// 삭제 완료.				
			}			
			pp = p;			
			p = p.next;			
		}
		return 1; // 찾는 키값이 없음
	}

//--- 해시 테이블을 덤프(dump) ---//
	public void dump() {
		for (int i = 0; i < size; i++) {
			Node2 p = table[i];
			System.out.printf("%02d  ", i);
			while (p != null) {
				System.out.printf("→ %s ", p.getKey());
				p = p.next;
			}
			System.out.println();
		}
	}
}

public class ChainHashSimpleObject {
	static Scanner stdIn = new Scanner(System.in);

	public static void main(String[] args) {
		ChainHash2 hash = new ChainHash2(11);
		SimpleObject2 data;
		int select = 0;
		final int count = 1;		
		while (select != 5) {			
			System.out.println("SimpleChainHash. Select 1:Add, 2. Delete, 3:Search, 4. PrintDump, 5. Quit =>");

			select = stdIn.nextInt();
			switch (select) {
			case 1:
				SimpleObject2[] input = new SimpleObject2[count];
				String sno = null;
				String sname = null;
				for (int ix = 0; ix < count; ix++) {

					System.out.println("입력 데이터(sno, sname):: ");

					System.out.print("번호: ");
					sno = stdIn.next();

					System.out.print("이름: ");
					sname = stdIn.next();
					System.out.print("sno =  " + sno);
					input[ix] = new SimpleObject2(sno, sname);
					hash.add(input[ix], SimpleObject2.NO_ORDER);
					
					System.out.println(" " + input[ix]);
				}
				break;
			case 2:
				// Delete
				System.out.println("번호 : ");
				String no1 = stdIn.next();
				System.out.println("이름 : ");
				String name1 = stdIn.next();
				SimpleObject2 searchObj1 = new SimpleObject2(no1, name1);
				if (hash.remove(searchObj1, SimpleObject2.NO_ORDER) == 0)
					System.out.println("삭제 완료.");
				else 
					System.out.println("삭제요청한 데이터가 없습니다.");
				break;
			case 3:
				System.out.println("번호 : ");
				String no = stdIn.next();
				System.out.println("이름 : ");
				String name = stdIn.next();
				SimpleObject2 searchObj = new SimpleObject2(no, name);
				if (hash.search(searchObj, SimpleObject2.NO_ORDER) == 0)
					System.out.println("검색한 " + no + " 있습니다.");
				else 
					System.out.println("검색한 " + no + " 없습니다.");
				break;
			case 4:
				hash.dump();
				break;
			case 5:
				System.out.println("Quit");
				break;

			default:
				System.out.println("WRONG INPUT  ");
				System.out.println("Re-Enter");
				break;
			}
		}
	}
}
