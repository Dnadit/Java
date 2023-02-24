package Chap05_recursive;

import java.util.Stack;

class Items {
	private int x;
	private int y;
	private int direction;
			
	public Items(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		direction = dir;
	}
	public int getX() {				
		return x;
	}
	public int getY() {				
		return y;
	}		
	public int getDir() {
		return direction;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setDir(int dir) {
		direction = dir;
	}
}

class Offsets {
	public int a, b;
}

public class Maze {	
	static int[][] maze = new int[100][100];
	static int[][] mark = new int[100][100];
	static Offsets[] moves = new Offsets[8];
	
	static void path(int m , int p) {		
		//start at (1,1)
		int x = 1;
		int y = 1;
		int dir = 0;
		mark[1][1] = 1;
		Stack<Items> stack = new Stack<Items>();
		Items temp = new Items(x, y, dir);		
		stack.push(temp);

		while (!stack.isEmpty()) // stack not empty
		{
			temp = stack.pop(); // unstack
			int i = temp.getX(); int j = temp.getY(); int d = temp.getDir();
			while (d < 8) // moves forward
			{
				//outFile << i << " " << j << " " << d << endl;
				int g = i + moves[d].a;
				int h = j + moves[d].b;
				if ((g == m) && (h == p)) { // reached exit
											// output path
					System.out.println("탈출 성공");
					return;
				}
				if ((maze[g][h] == 0) && (mark[g][h] == 0)) { // new position
					mark[g][h] = 1;
					//push the old temp to the stack, but the direction changes.
					//Because the neighbor in the direction of d has been checked.
					temp.setX(i);  temp.setY(j); temp.setDir(d+1);
					stack.push(temp); // stack it
					i = g; j = h; d = 0; // moves to (g,h)
				}
				else d++; // try next direction
			}
		}
		System.out.println("no path in maze ");
	}
	
	public static void main(String[] args) {		
		int a = 0;
		int b = 0;		
		
		int[][] input =	{
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 },
				};
		
		for(int i=0; i<8; i++)
			moves[i] = new Offsets();
		
		moves[0].a = -1; moves[0].b = 0;
		moves[1].a = -1; moves[1].b = 1;
		moves[2].a = 0; moves[2].b = 1;
		moves[3].a = 1; moves[3].b = 1;
		moves[4].a = 1; moves[4].b = 0;
		moves[5].a = 1; moves[5].b = -1;
		moves[6].a = 0; moves[6].b = -1;
		moves[7].a = -1; moves[7].b = -1;
		
		// maze 초기화
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++)
			{
				if ((i == 0) || (j == 0) || (i == 13) || (j == 16))
					maze[i][j] = 1;
				else {
					maze[i][j] = input[i - 1][j - 1];
				};
				mark[i][j] = 0;
			}
		}
		for (int i = 0; i <= 13; i++)
		{
			for (int j = 0; j <= 16; j++)
				System.out.print(maze[i][j] + " ");
			System.out.println();
		}
		path(12, 15);

		System.out.println("end");
	}

}
