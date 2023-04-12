package Chap09_Tree;

import java.util.Scanner;

//정수를 저정하는 이진트리 만들기 실습
class TreeNode {
	TreeNode LeftChild;
	int data;
	TreeNode RightChild;
	public TreeNode() {
		LeftChild = RightChild = null;
	}
	public TreeNode(int x) {
		data = x;
		LeftChild = RightChild = null;
	}
}

class Tree {
	TreeNode root;
	
	Tree() {
		root = null;
	}
	
	TreeNode inorderSucc(TreeNode current) {
		TreeNode temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null)
				temp = temp.LeftChild;		
		return temp;
	}
	
	boolean isLeafNode(TreeNode current) {
		if (current.LeftChild == null && current.RightChild == null) return true;
		else return false;
	}
	
	void inorder() {
		inorder(root);
	}
	void preorder() {
		preorder(root);
	}
	void postorder() {
		postorder(root);
	}
	void inorder(TreeNode CurrentNode) { 
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.RightChild);
		}
	}
	void preorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}
	void postorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	boolean insert(int x) {// binary search tree를 만드는 입력 => A + B * C을 tree로 만드는 방법: 입력 해결하는 알고리즘 작성 방법을
							// 설계하여 구현
		TreeNode NodeX = new TreeNode(x);
		TreeNode p = root;
		TreeNode q = null;		
		if (p == null) {
			root = NodeX;
			return true;
		}
		while (p != null) {
			if (NodeX.data < p.data) {
				if (p.LeftChild == null) {
					p.LeftChild = NodeX;
					return true;				
				}
				q = p;
				p = p.LeftChild;
				continue;
			}
			if (NodeX.data > p.data) {
				if (p.RightChild == null) {
					p.RightChild = NodeX;
					return true;				
				}
				q = p;
				p = p.RightChild;
				continue;
			}
		}
		return false;
	}
	
	boolean delete(int num) {
		TreeNode p = root, q = null;		
		boolean isLeft = true;	// 왼쪽 or 오른쪽
		
		// 위치 찾기.
		while (true) {
			if (p == null) {	// root가 null 이면 데이터가 아무것도 없음.
				return false;
			}			
			if (num == p.data) {
				break;
			}
			
			if (num > p.data) {
				q = p;
				p = p.RightChild;
				isLeft = false;
			}			
			if (num < p.data) {
				q = p;
				p = p.LeftChild;
				isLeft = true;
			}
		}
		
		// 삭제하기. 1.leafNode 2.non-leafNode
		// 1.leafNode(자식이 없음)
		if (isLeafNode(p)) {
			if (p == root)
				root = null;
			else if (isLeft)
				q.LeftChild = null;
			else 
				q.RightChild = null;
		}
		// 2.non-leafNode(자식이 있음.) >> 1.왼쪽자식이 하나 2.오른쪽자식이 하나 3.자식이 둘
		else {
			// 1.왼쪽자식이 하나.			
			if (p.RightChild == null) {
				if (isLeft)
					q.LeftChild = p.LeftChild;
				else
					q.RightChild = p.LeftChild;
			}
			// 2.오른쪽자식이 하나.
			if (p.LeftChild == null) {
				int temp = inorderSucc(p).data;
				delete(temp);
				p.data = temp;
			}
			// 3.자식이 둘다 있음.
			if (p.LeftChild != null && p.RightChild != null) {
				int temp = inorderSucc(p).data;
				delete(temp);
				p.data = temp;
			}
		}		
		return true;
	}
	
	boolean search(int num) {
		TreeNode p = root;
		TreeNode q = null;
		if (p == null)
			return false;
		
		while (p != null) {
			if (num > p.data) {
				if (p.RightChild == null) 
					return false;
				if (p.RightChild.data == num)
					return true;
				q = p;
				p = p.RightChild;
			}
			else if (num < p.data) {
				if (p.LeftChild == null)
					return false;
				if (p.LeftChild.data == num)
					return true;
				q = p;
				p = p.LeftChild;
			}
			else {
				return true;
			}
		}
		return true;
	}
}

public class BinaryTreeInt {
	enum Menu {
	     Add(      "삽입"),
	     Delete(   "삭제"),
	     Search(   "검색"),
	     InorderPrint(    "표시"),
	     Exit("종료");
	     private final String message;        // 표시할 문자열
	     static Menu MenuAt(int idx) {        // 순서가 idx번째인 열거를 반환
	         for (Menu m : Menu.values())
	             if (m.ordinal() == idx)
	                 return m;
	         return null;
	     }
	     Menu(String string) {                // 생성자(constructor)
	         message = string;
	     }
	     String getMessage() {                // 표시할 문자열을 반환
	         return message;
	     }
	 }

	 //--- 메뉴 선택 ---//
	 static Menu SelectMenu() {
		 Scanner stdIn = new Scanner(System.in);
	     int key;
	     do {
	         for (Menu m : Menu.values())
	             System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
	         System.out.print(" : ");
	         key = stdIn.nextInt();
	     } while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

	     return Menu.MenuAt(key);
	 }

	 public static void main(String[] args) {		 
		 Scanner stdIn = new Scanner(System.in);
		 Tree t = new Tree();
	     Menu menu;                                // 메뉴 
	     int count = 0;
	     int num;
	     boolean result;
	     do {
	         switch (menu = SelectMenu()) {
	          case Add :              // 노드 삽입
					System.out.println("The number of items = ");

					count = stdIn.nextInt();
					int[] input = new int[10];
					for (int ix = 0; ix < count; ix++) {
						int d = (int)(Math.random()*100);
						input[ix] = d ;
					}
					for (int i = 0; i < count; i++) {
						if (t.insert(input[i]) == false)
							System.out.println("Insert Duplicated data");
					}	    
	                break;

	          case Delete :           // 노드 삭제 - 어렵다: 난이도 상
	        	    System.out.println("삭제할 데이터:: ");
	        	  	num = stdIn.nextInt();
	                if (t.delete(num) == false) {
	                	System.out.println("삭제할 데이터 " + num + "은 없습니다.");
	                	break;
	                }
	                System.out.println("데이터 " + num + " 삭제 완료.");
	                break;

	          case Search :           // 노드 검색
	        	  	System.out.println("검색할 데이터:: ");

					num = stdIn.nextInt();
	                result = t.search(num);
	                  if (result == true)
	                     System.out.println(" 데이터 = " + num + "존재합니다.");
	                 else
	                      System.out.println("해당 데이터가 없습니다.");
	                  break;

	          case InorderPrint :            // 전체 노드를 키값의 오름차순으로 표시
	                 t.inorder();
	                 System.out.println();
	                 break;
	         }
	     } while (menu != Menu.Exit);
	 }
}

