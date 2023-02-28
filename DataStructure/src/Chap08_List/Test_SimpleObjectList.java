package Chap08_List;

import java.util.Comparator;
import java.util.Scanner;

class SimpleObject {
	
	private String no; // 회원번호
	private String name; // 이름
	
	public SimpleObject(String no, String name) {
		this.no = no;
		this.name = name;
	}
	
	public String getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + no + ") " + name;
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject> {
		public int compare(SimpleObject d1, SimpleObject d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : (d1.no.compareTo(d2.no) < 0) ? -1 : 0; // d1.no 가 크면 1 작으면 -1 같으면 0
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject> {
		public int compare(SimpleObject d1, SimpleObject d2) {
			return d1.name.compareTo(d2.name); // d1이 크면 양수 반환
		}
	}
}
class Node1 {
	SimpleObject data;
	Node1 link;
	public Node1(String no, String name) {
		link = null;
		data = new SimpleObject(no, name);
	}
}

class LinkedList1 {
	Node1 first;
	public LinkedList1() {
		first = null;
	}
	public boolean Delete(SimpleObject element, Comparator<? super SimpleObject> c) //delete the element
	{		
		Node1 p = first, q = null;
		while (p != null) {
			if (c.compare(p.data, element) == 0) {
				if (q == null) {
					first = p.link;
					return true;
				}
				q.link = p.link;				
				return true;
			} else {
				q = p;
				p = p.link;
			}
		}
		return false;
	}
	public void Show() { // 전체 리스트를 순서대로 출력한다.
		Node1 p = first;
		while(p != null) { 
			System.out.print(p.data.toString() + " ");
			p = p.link;
		}
		System.out.println();
	}
	public void Add(SimpleObject element, Comparator<? super SimpleObject> c) //임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다 
	{
		Node1 newNode = new Node1(element.getNo(), element.getName());
		Node1 p = first, q = null;
		if (p == null) {
			first = newNode;
			return;
		}
		while(p != null) {
			if (c.compare(p.data, element) > 0) {
				newNode.link = p;
				q.link = newNode;
				return;
			} else {
				q = p;
				p = p.link;
			}
			if (p == null) {
				q.link = newNode;
				return;
			}
		}
		
	}
	public boolean Search(SimpleObject data, Comparator<? super SimpleObject> c, Comparator<? super SimpleObject> c1) { // 전체 리스트를 순서대로 출력한다.
		Node1 p = first;
		while (p != null) {
			if (c.compare(p.data, data) == 0 && c1.compare(p.data, data) == 0) {
				return true;				
			}
			p = p.link;
		}
		return false;
	}
}
public class Test_SimpleObjectList {

	 enum Menu {
	        Add( "삽입"),
	        Delete( "삭제"),
	        Show( "인쇄"),
	        Search( "검색"),
	        Exit( "종료");

	        private final String message;                // 표시할 문자열

	        static Menu MenuAt(int idx) {                // 순서가 idx번째인 열거를 반환
	            for (Menu m : Menu.values())
	                if (m.ordinal() == idx)
	                    return m;
	            return null;
	        }

	        Menu(String string) {                        // 생성자(constructor)
	            message = string;
	        }

	        String getMessage() {                        // 표시할 문자열을 반환
	            return message;
	        }
	    }

	    //--- 메뉴 선택 ---//
	    static Menu SelectMenu() {
			Scanner sc = new Scanner(System.in);
	        int key;
	        do {
	            for (Menu m : Menu.values()) {
	                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
	                if ((m.ordinal() % 3) == 2 &&
	                      m.ordinal() != Menu.Exit.ordinal())
	                    System.out.println();
	            }
	            System.out.print(" : ");
	            key = sc.nextInt();
	        } while (key < Menu.Add.ordinal() || 
	                                            key > Menu.Exit.ordinal());
	        return Menu.MenuAt(key);
	    }

	public static void main(String[] args) {
       Menu menu;                                // 메뉴 
		System.out.println("Linked List");
		LinkedList1 l = new LinkedList1();
		Scanner sc = new Scanner(System.in);
		SimpleObject data = new SimpleObject("초기화", "초기화");
    System.out.println("inserted");
	     l.Show();		
	        do {
	            switch (menu = SelectMenu()) {	             
	             case Add :                           // 머리노드 삽입
	            	 System.out.print("회원번호 입력 : ");
	            	 String no = sc.nextLine();
	            	 System.out.print("회원이름 입력 : ");
	            	 String name = sc.nextLine();
	            	 
	            	 data.setNo(no);
	            	 data.setName(name);
	            	 
	    	         l.Add(data, SimpleObject.NO_ORDER);            
	                     break;
	             case Delete :                          // 머리 노드 삭제
	            	 System.out.print("회원번호 입력 : ");
	            	 String no1 = sc.nextLine();
	            	 System.out.print("회원이름 입력 : ");
	            	 String name1 = sc.nextLine();
	            	 data.setNo(no1);
	            	 data.setName(name1);
	            	 boolean result1 = l.Delete(data, SimpleObject.NO_ORDER);	            	
	            	 if (result1) {
		            	 System.out.println("삭제된 데이터는 " + "(" + no1 + ") " + name1);		                 
	            	 } else {
	            		 System.out.println("입력한 데이터 " + "(" + no1 + ") " + name1 + "는 없습니다.");
	            	 }
	            	 break;
	             case Show :                           // 꼬리 노드 삭제
	                    l.Show();
	                    break;
	             case Search :                           // 회원 번호 검색
	            	 System.out.print("회원번호 입력 : ");
	            	 String no2 = sc.nextLine();
	            	 System.out.print("회원이름 입력 : ");
	            	 String name2 = sc.nextLine();
	            	 data.setNo(no2);
	            	 data.setName(name2);
	                boolean result = l.Search(data, SimpleObject.NO_ORDER, SimpleObject.NAME_ORDER);
	                    if (result == false)
	                        System.out.println("검색 값 = " + "(" + data.getNo() + ") " + data.getName() + "데이터가 없습니다.");
	                    else
	                        System.out.println("검색 값 = " + "(" + data.getNo() + ") " + data.getName() + "데이터가 존재합니다.");
	                    break;
	             case Exit :                           // 꼬리 노드 삭제
	                    break;
	            }
	        } while (menu != Menu.Exit);
	    }
}



