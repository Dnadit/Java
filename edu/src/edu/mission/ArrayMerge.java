package edu.mission;
// 길이가 N+1인 두 정수 배열 A와 B가 있을 때 배열 C를 만들고자한다.
// 메소드 merge()를 완성하고, 각 배열값을 출력하세요.
// hint for loop 한번
public class ArrayMerge {
	
	public static void printArray(int [] arr) {
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
		System.out.print("\n");
	}
	/* 아래에 c 를 int[] 타입으로 받기 위해서 void >> int[]으로 작성.
	 * int[] 타입으로 반환하기 위해서 반환값 타입을 생성*/
	public static int[] merge(int [] arr, int [] arr2) {
		int [] ret = new int [arr.length*2]; //int[] 타입으로 반환하기 위해서 반환값 타입을 생성
		int k = 0;
		for(int i =0; i < arr.length; i++) {
			ret[k++] = arr[i];
//			k++;
			ret[k++] = arr2[i];
//			k++;
		}
		return ret; // ret[] = {arr[0], arr2[0], arr[1], arr2[1],
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1,3,5,7};
		int [] b = {2,4,6,8};
		int [] c;
		
		printArray(a);
		printArray(b);
		c = merge(a, b);
		printArray(c);
	}

}
