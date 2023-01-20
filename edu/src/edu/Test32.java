package edu;
//배열 연습
public class Test32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [] score;
//		score = new int[] {1,2,3,4,5};
		
		int arr [] = new int[20];
		//int [] a = {1,2,3,4,5};
		System.out.println(arr.length);
		for (int i = 0; i<arr.length; i++)
		arr[i] = i * 10;
		/*
		 * arr[1] = 20; arr[2] = 30; arr[3] = 40; arr[4] = 50;
		 */
		//for(int i = 0; i<arr.length; i++)
		//System.out.print(" " + arr[i]);
		for (int num : arr) {
			System.out.print(" " + num);  //위의 for문 대신에 이와 같이 사용함. 배열 전체 다 실행.
		}
		System.out.println();
		System.out.println("Hong");
	}

}
