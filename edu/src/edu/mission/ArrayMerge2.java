package edu.mission;
// 길이가 N+1인 두 정수 배열 A와 B가 있을 때 배열 C를 만들고자한다.
// 메소드 merge()를 완성하고, 각 배열값을 출력하세요.
// hint for loop 한번
public class ArrayMerge2 {
	
	public static void printArray(int [] arr) {
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
		System.out.print("\n");
	}
	
	public static void merge(int [] ret, int [] arr, int [] arr2) {		
		int k = 0;
		for(int i =0; i < arr.length; i++) {
			ret[k++] = arr[i];
//			k++;
			ret[k++] = arr2[i];
//			k++;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1,3,5,7};
		int [] b = {2,4,6,8};		
		int [] c = new int [a.length*2];		
		
		printArray(a);
		printArray(b);
		merge(c, a, b);
		printArray(c);
	}

}
