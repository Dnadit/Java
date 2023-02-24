package edu.mission;

import java.util.Scanner;

// 구구단을 출력하는 메소드를 구현해보세요. (1단, 2단, 3단)
public class Gugudan {

	public static void main(String[] args) {
		
		int col;
		Scanner kb = new Scanner(System.in);
		System.out.print("col : ");
		col = kb.nextInt();
		
		for(int i=2; i < 10; i++) {			
			for(int j=1; j < 10; j++) {
				for(int k=0; k < col; k++) {
					if(10 <= i+k) {
						System.out.println();
						break;
					}
					System.out.printf("%d*%d=%2d", (i+k), j, (i+k)*j);
					
					if(k < col-1) System.out.print("\t");
					else		  System.out.print("\n");
				}
			}
			i = i+col-1;
			System.out.println("------------");
		}
	}

}
