package Chap05_recursive;

public class NQueen {
	
	public static boolean checkMove(int x, int y, int [][] arr) {
		if(!checkRow(x, arr) || !checkCol(y, arr) || !checkSlash(x, y, arr) || !checkBslash(x, y, arr)) 
			return false;
		return true;
	}	

	private static boolean checkRow(int x, int[][] arr) {
		for (int i=0; i < arr[x].length; i++) {
			if (arr[x][i] == 1)
				return false;
		}
		return true;
	}
	
	private static boolean checkCol(int y, int[][] arr) {
		for (int i=0; i < arr[y].length; i++) {
			if (arr[i][y] == 1)
				return false;
		}
		return true;
	}
	
	private static boolean checkSlash(int x, int y, int[][] arr) {
		int dx = x;
		int dy = y;
		
		while (dx >= 0 && dx < arr[y].length && dy >= 0 && dy < arr[x].length) {
			if (arr[dx][dy] == 1)
				return false;
			dx++;
			dy--;
		}
		// 아래 오른쪽 검사 다하고 원래 자리로 초기화
		dx = x;
		dy = y;
		while (dx >= 0 && dx < arr[y].length && dy >= 0 && dy < arr[x].length) {
			if (arr[dx][dy] == 1)
				return false;
			dx--;
			dy++;
		}
		return true;
	}
	
	private static boolean checkBslash(int x, int y, int[][] arr) {
		int dx = x;
		int dy = y;
		
		while (dx >= 0 && dx < arr[y].length && dy >= 0 && dy < arr[x].length) {
			if (arr[dx][dy] == 1)
				return false;
			dx++;
			dy++;
		}
		// 아래 왼쪽 검사 다하고 원래 자리로 초기화
		dx = x;
		dy = y;
		while (dx >= 0 && dx < arr[y].length && dy >= 0 && dy < arr[x].length) {
			if (arr[dx][dy] == 1)
				return false;
			dx--;
			dy--;
		}
		return true;
	}
	
	
	
	public static void solveQueen(int row, int col, int [][] arr) {
		MyStack1 s = new MyStack1();
		Point1 p = new Point1(0,0);
		int x = p.getX();
		int y = p.getY();		
		
		while(x < row) {
			while (y < col) {
				if (checkMove(x, y, arr)) {
					arr[x][y] = 1;
					s.push(new Point1(x,y));					
					y=0;
					x++;
					break;
				}
				y++;
			}
			if (y == col) {
				if(!s.isEmpty()) {
					p = s.pop();
					x = p.getX();
					y = p.getY();
					arr[x][y] = 0;
					y++;
				}
			}
			if (x == row) {	
				print(row, col, arr);								
				if(!s.isEmpty()) {
					p = s.pop();
					x = p.getX();
					y = p.getY();
					arr[x][y] = 0;
					y++;
				}
			}
		}
	}
	
	static int count = 0;
	
	public static void print(int row, int col, int[][] arr) {
		System.out.println("경우의 수 : " + (++count));
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("====================");
	}

	public static void main(String[] args) {		
		int row = 8;
		int col = 8;
		int[][] field = new int[row][col];
		// 배열 0으로 초기화
		for(int i=0; i<field[0].length; i++) {
			for (int j=0; j<field.length; j++) {
				field[i][j] = 0;
			}
		}
		solveQueen(row, col, field);		
	}

}
