package Chap06_정렬알고리즘;

//퀵 정렬(비재귀 버전)

import java.util.Scanner;

import Chap05_recursive.Point;

public class QuickSort2 {
 //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
 static void swap(int[] a, int idx1, int idx2) {
     int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
 }

 //--- 퀵 정렬(비재귀 버전)---//
 static void quickSort(int[] a, int left, int right) {
     IntStack stack = new IntStack(right - left + 1);
	 Point p = new Point(left, right);	 
	 
	 stack.push(p);	 
     while (stack.isEmpty() != true) {
         p = stack.pop();         
    	 int pl = left = p.getX();
    	 int pr = right = p.getY();         
    	 int x = a[(left + right) / 2];        // 피벗은 가운데 요소

         do {
             while (a[pl] < x) pl++;
             while (a[pr] > x) pr--;
             if (pl <= pr)
                 swap(a, pl++, pr--);
             System.out.println("fivot : " + x);
             for(int num: a)            	 
            	 System.out.print(" " + num);
             System.out.println();
         } while (pl <= pr);

         if (left < pr) {
        	 System.out.println("왼쪽 정렬");
        	 p = new Point(left, pr);
             stack.push(p);           
         }
         if (pl < right) {
        	 System.out.println("오른쪽 정렬");
        	 p = new Point(pl, right);
             stack.push(p);
         }
     }
 }

 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);

     System.out.println("퀵 정렬");
//     System.out.print("요솟수: ");
//     int nx = stdIn.nextInt();
//     int[] x = new int[nx];
//
//     for (int i = 0; i < nx; i++) {
//         System.out.print("x[" + i + "]: ");
//         x[i] = stdIn.nextInt();
//     }
     
     int[] x = {5,8,4,2,6,1,3,9,7};
	 int nx = 9;
     quickSort(x, 0, nx - 1);            // 배열 x를 퀵정렬

     System.out.println("오름차순으로 정렬했습니다.");
     for (int i = 0; i < nx; i++)
         System.out.print(" " + x[i]);
 }
}
