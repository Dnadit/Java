package edu;
//2차원 배열의 행렬(array) 출력
public class Test38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = new int[3][4];
		int[][] b = new int[4][5];
		//int[][] c = new int[3][3];
		int[][] d = new int[3][5];
		
		for(int i = 0; i < a.length; i++)
			for(int j = 0; j < a[i].length; j++) {
				double rnum = Math.random();        // 0<=rnum<1 실수, 난수 코드 찾아와서 쓰면 됨.
				int num = (int) (rnum * 5);
				a[i][j] = num;
			}
		for(int i = 0; i < b.length; i++)
			for(int j = 0; j < b[i].length; j++) {
				double rnum = Math.random();        // 0<=rnum<1 실수, 난수 코드 찾아와서 쓰면 됨.
				int num = (int) (rnum * 5);
				b[i][j] = num;
			}
		//a
		System.out.println("행렬 a = ");
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				System.out.print(" " + a[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}		
		//b
		System.out.println("행렬 b = ");
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[i].length; j++) {
				System.out.print(" " + b[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}		
		// c = a + b 행렬 더하기
//		System.out.println("행렬 c = a + b");		
//		for(int i = 0; i < a.length; i++) {
//			for(int j = 0; j < a[i].length; j++) {
//				c[i][j] = a[i][j] + b[i][j];
//				System.out.print(" " + c[i][j]);
//				System.out.print("\t");
//			}
//			System.out.println("\n");
//		}		
		// d = a * b 행렬 곱하기				
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < b[i].length; j++) {
				int sum = 0;
				for(int k = 0; k < a[i].length; k++) {
					sum += a[i][k] * b[k][j]; // sum = sum + (a[i][k] * b[k][j]);
				}
				d[i][j] = sum;
			}
		}
			System.out.println("행렬 d = a * b ");
			for(int i = 0; i < d.length; i++) {
				for(int j = 0; j < d[i].length; j++) {
					System.out.print(" " + d[i][j]);
					System.out.print("\t");
				}
				System.out.println("\n");
			}			
			System.out.println("\n");
	}
}