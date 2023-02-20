//* 문제 해결형 자바 코딩 실습이 필요
//- main()의 작성 방법 훈련 - 
//  main() {
//	int [][]data;
// 	배열 초기화
//	SolveQueen(data);
//	배열열 출력: 8개의 queen 배치(여러가지 해를 구해 보여주기)
//  }
//- 함수 호출로 구현 훈련
//    void SolveQueen(int [][]d) {
//       //코딩 완성하기 
//    }
//  => 8  Queen 문제 풀기: 스택 사용하여 backtracking 코딩 실습
//    -> 2차원 배열에 0으로 초기화, Queen을 배치하면 1로 설정, 8 X 8 배열에 8개 퀸이 가로 세로 대각선에 충돌이 없으면 성공
//
//    -> stack에 Point 객체를 생성하여 push, pop::(x, y, move) => move는 다음 이동 가능 candidate의 column임
//        class MyStack {
// 	int top;
//	Point [] data
//	void Push(Point p);
//	Point Pop();
//         }
//         void NextMove(int[] move, int row); // current row에 대한 다음 배치 가능한 모든 column을 조사하고 move[]에 1로 설정
//         boolean CheckMove(int currentRow, int row, int col) //currentRow에 대하여 queen을 (x,y)에 배치 가능하면 true
//
//        => backtracking을 stack을 이용하여 push/pop으로 해결하는 것을 보이는 것임
//
//    -> 가로, 세로, 대각선에 대한 충돌 체크 함수 코딩
//     boolean CheckMove(x,y) {
//	checkRow(x);
//	checkCol(y);
//	checkDiagSW(x,y); //x++, y-- or x--, y++ where 0<= x,y <= 7
//	checkDiagSE(x,y); //x++, y++ or x--, y--
//     }


package Chap05_recursive;

public class EightQueen2 {	
	static int row = 8;
	static int col = 8;
	static int[][]field = new int [row][col] ;
	
	static boolean check(int x, int y) {
		if(checkRow(x)&&checkCol(y)&&checkSlash(x, y)&&checkBackslash(x, y))
			return true;
		return false;
	}
	static boolean checkRow(int x) {
		for(int i=0; i<row; i++) {
			if (field[x][i] == 1)
				return false;
		}
		return true;
	}
	
	static boolean checkCol(int y) {
		for(int i=0; i<col; i++) {
			if (field[i][y] == 1)
				return false;
		}
		return true;
	}
	
	static boolean checkSlash(int x, int y) {
		int dx = x;
		int dy = y;
		while (dx >= 0 && dx < row && dy >= 0 && dy < col) {
			if (field[dx][dy] == 1)
				return false;
			dx--;
			dy++;
		}
		while (dx >=0 && dx < row && dy >= 0 && dy < col) {
			if (field[dx][dy] == 1)
				return false;
			dx++;
			dy--;
		}
		return true;
	}
	
	static boolean checkBackslash(int x, int y) {
		int dx = x;
		int dy = y;
		while (dx >= 0 && dx < row && dy >= 0 && dy < col) {
			if (field[dx][dy] == 1)
				return false;
			dx--;
			dy--;
		}
		while (dx >= 0 && dx < row && dy >= 0 && dy < col) {
			if (field[dx][dy] == 1)
				return false;
			dx++;
			dy++;
		}
		return true;
	}
	
	static void solveQueen() {
		Point p = new Point(0,0);
		MyStack s = new MyStack(100);
		int x = p.getX();
		int y = p.getY();
		int count = 0;
		while(x < row) {
			while(y < col) {
				if(check(x, y)) {
					field[x][y] =1;
					s.push(new Point(x,y));
					y = 0;
					break;
				}
				y ++;
			}
			x++;
		}
	}
	
	static void print() {
		int[][]d = new int [row][col];
		for (int i=0; i<d[0].length; i++) {
			for(int j=0; j<d.length; j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {		
		solveQueen();
		print();
	}
}
