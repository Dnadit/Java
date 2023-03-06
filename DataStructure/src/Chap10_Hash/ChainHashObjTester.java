package Chap10_Hash;

import java.util.Comparator;

//체인법에 의한 해시 사용 예

import java.util.Scanner;

public class ChainHashObjTester {
	static Scanner stdIn = new Scanner(System.in);

	// --- 데이터(회원번호＋이름) ---//
	static class HashObject {
		static final int NO = 1; // 번호를 읽어 들일까요?
		static final int NAME = 2; // 이름을 읽어 들일까요?

		private String no; // 회원번호(키값)
		private String name; // 이름
		
		public String getNo() {
			return no;
		}
		
		public String getName() {
			return name;
		}

		// --- 키값 ---//
		Integer keyCode() {
			return Integer.parseInt(no);
		}

		// --- 문자열 표현을 반환 ---//
		public String toString() {
			return name;
		}

		// --- 데이터를 읽어 들임 ---//
		void scanData(String guide, int sw) {
			System.out.println(guide + "할 데이터를 입력하세요.");

			if ((sw & NO) == NO) {
				System.out.print("번호: ");
				no = stdIn.next();
			}
			if ((sw & NAME) == NAME) {
				System.out.print("이름: ");
				name = stdIn.next();
			}
		}

		public static final Comparator<HashObject> NO_ORDER = new NoOrderComparator();

		private static class NoOrderComparator implements Comparator<HashObject> {
			public int compare(HashObject d1, HashObject d2) {
				return (d1.no.compareTo(d2.no) > 0) ? 1 : (d1.no.compareTo(d2.no) < 0) ? -1 : 0; // d1.no 가 크면 1 작으면 -1
																									// 같으면 0
			}
		}

		public static final Comparator<HashObject> NAME_ORDER = new NoOrderComparator();

		private static class NameOrderComparator implements Comparator<HashObject> {
			public int compare(HashObject d1, HashObject d2) {
				return (d1.name.compareTo(d2.name) > 0) ? 1 : (d1.name.compareTo(d2.name) < 0) ? -1 : 0; // d1.no 가 크면 1 작으면 -1
																									// 같으면 0
			}
		}
	}

	// --- 메뉴 열거형 ---//
	enum Menu {
		ADD("추가"), REMOVE("삭제"), SEARCH("검색"), DUMP("표시"), TERMINATE("종료");

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
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		HashObject data; // 추가용 데이터 참조
		HashObject temp = new HashObject(); // 읽어 들일 데이터

		ChainHashObj<HashObject> hash = new ChainHashObj<HashObject>(13);

		do {
			switch (menu = SelectMenu()) {
			case ADD: // 추가
				data = new HashObject();
				data.scanData("추가", HashObject.NO | HashObject.NAME);
				hash.add(data);
				break;

			case REMOVE: // 삭제
				temp.scanData("삭제", HashObject.NO);
				hash.remove(temp);
				break;

			case SEARCH: // 검색
				temp.scanData("검색", HashObject.NO);
				HashObject t = hash.search(temp);
				if (t != null)
					System.out.println("그 키를 갖는 데이터는 " + t + "입니다.");
				else
					System.out.println("해당 데이터가 없습니다.");
				break;

			case DUMP: // 표시
				hash.dump();
				break;
			}
		} while (menu != Menu.TERMINATE);
	}
}
