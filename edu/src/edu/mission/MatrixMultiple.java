package edu.mission;

public class MatrixMultiple {
	
	public static void printArray(int[][] arr) {
		for(int i=0; i < arr.length; i++) {
			for(int j=0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] A = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
		int [][] B = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
		int [][] C = new int [4][4];
		
		printArray(A);		
		printArray(B);		
		
		for(int i=0; i < A.length; i++) {
			for(int j=0; j < B[0].length; j++) {
				for(int k=0; k < A[0].length; k++) {
					C[i][j] += A[i][k] * B[k][j];					
				}
			}
		}
		printArray(C);
//		for(int i=0; i < C.length; i++) {
//			for(int j=0; j < C[0].length; j++) {
//				System.out.print(C[i][j] + " ");
//			}
//			System.out.println("\n");
//		}
	}
	
}
