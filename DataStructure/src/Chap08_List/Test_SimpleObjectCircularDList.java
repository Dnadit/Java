package Chap08_List;

import java.util.Comparator;
import java.util.Scanner;

class SimpleObject1 {

	String sno; // 회원번호
	String sname; // 이름

	public SimpleObject1(String sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + sno + ") " + sname;
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject1> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject1> {
		public int compare(SimpleObject1 d1, SimpleObject1 d2) {
			return (d1.sno.compareTo(d2.sno) > 0) ? 1 : (d1.sno.compareTo(d2.sno) < 0) ? -1 : 0; // d1.no 가 크면 1 작으면 -1 같으면 0
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject1> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject1> {
		public int compare(SimpleObject1 d1, SimpleObject1 d2) {
			return d1.sname.compareTo(d2.sname); // d1이 크면 양수 반환
		}
	}
}

class Node2 {
	SimpleObject1 data; // 데이터
	Node2 llink; // 좌측포인터(앞쪽 노드에 대한 참조)
	Node2 rlink; // 우측포인터(뒤쪽 노드에 대한 참조)

	// --- 생성자(constructor) ---//
	Node2(SimpleObject1 so) {
		this.data = so;
		llink = rlink = this;
	}
	Node2() {
		this.data = null;
		llink = rlink = this;
	}
	Node2(String sno, String sname) {
		data = new SimpleObject1(sno, sname);
		llink = rlink = this;
	}
	public int compareNode(Node2 n2) {
		SimpleObject1 so1 = this.data;
		if (SimpleObject1.NO_ORDER.compare(so1, n2.data) < 0) return -1;
		else if (SimpleObject1.NO_ORDER.compare(so1, n2.data) > 0)return 1;
		else return 0;
	}
}

class DoubledLinkedList2 {
	private Node2 first; // 머리 포인터(참조하는 곳은 더미노드)

// --- 생성자(constructor) ---//
	public DoubledLinkedList2() {
		first = new Node2(); // dummy(first) 노드를 생성
		
	}

// --- 리스트가 비어있는가? ---//
	public boolean isEmpty() {
		return first.rlink == first;
	}

// --- 노드를 검색 ---//
	public boolean search(SimpleObject1 obj, Comparator<? super SimpleObject1> c) {
		Node2 ptr = first; // 현재 스캔 중인 노드
		while (ptr.rlink != first.rlink) {
			if (c.compare(obj, ptr.data) == 0) {
				return true;
			} else {
				ptr = ptr.rlink;
			}
		}
		return false;
	}

// --- 전체 노드 표시 ---//
	public void show() {
		Node2 ptr = first;
		while (ptr != first) {
			System.out.print(ptr + " ");
			ptr = ptr.rlink;
		}
	}

// --- 올림차순으로 정렬이 되도록 insert ---//
	public void add(SimpleObject1 obj, Comparator<? super SimpleObject1> c) {
		Node2 temp = new Node2(obj);
		Node2 ptr = first;
		if (ptr.rlink == first) {
			//first = temp;			
			//return;
		}
		
		while (ptr.rlink != first) {
			if (c.compare(temp.data, ptr.data) > 0) {
				if (ptr.rlink == first) {					
					temp.rlink = first;
					ptr.rlink = temp;
					temp.llink = ptr;					
					return;
				}
				temp.rlink = ptr.rlink;
				ptr.rlink = temp;
				temp.llink = ptr;
				return;
			} 
			else {
				temp.rlink = ptr;
				temp.llink = ptr.llink;
				ptr.llink = temp;
				return;
			}
		}		
	}

// --- list에 삭제할 데이터가 있으면 해당 노드를 삭제 ---//
	public void delete(SimpleObject1 obj, Comparator<? super SimpleObject1> c) {

	}
	public DoubledLinkedList2 merge(DoubledLinkedList2 lst2) {
		DoubledLinkedList2 lst3 = new DoubledLinkedList2();
		Node2 ai = this.first.rlink, bi = lst2.first.rlink;
	


		return lst3;

	}
}
public class Test_SimpleObjectCircularDList {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Merge("병합"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc1 = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc1.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		System.out.println("Linked List");
		DoubledLinkedList2 lst1 = new DoubledLinkedList2();
		String sno1 = null, sname1 = null;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 머리노드 삽입
				Scanner sc = new Scanner(System.in);
				System.out.println(" 회원번호: ");
				sno1 = sc.next();
				System.out.println(" 회원이름: ");
				sname1 = sc.next();
				SimpleObject1 so = new SimpleObject1(sno1, sname1);
				lst1.add(so, SimpleObject1.NO_ORDER);
				break;
			case Delete: // 머리 노드 삭제
				Scanner sc2 = new Scanner(System.in);
				System.out.println(" 회원번호: ");
				sno1 = sc2.next();
				System.out.println(" 회원이름: ");
				sname1 = sc2.next();
				SimpleObject1 so2 = new SimpleObject1(sno1, sname1);
				lst1.delete(so2, SimpleObject1.NO_ORDER);
				

				break;
			case Show: // 꼬리 노드 삭제
				lst1.show();
				break;
			case Search: // 회원 번호 검색
				Scanner sc3 = new Scanner(System.in);
				System.out.println(" 회원번호: ");
				sno1 = sc3.next();
				SimpleObject1 so3 = new SimpleObject1(sno1, null);
				boolean result = lst1.search(so3, SimpleObject1.NO_ORDER);
				if (result == false)
					System.out.println("검색 값 = " + sno1 + "데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + sno1 + "데이터가 존재합니다.");
				break;
				
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}

