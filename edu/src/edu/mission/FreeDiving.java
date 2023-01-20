package edu.mission;
// 자유 낙하 물체의 위치 구하기
import java.util.Scanner;

public class FreeDiving {		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("몇초 후 까지?");
		Scanner sc = new Scanner(System.in);	
		int seconds = sc.nextInt();
		
		for(int t=1; t <= seconds; t++) {
		double a = 9.81;
		double x = (double)1/2 * a * t * t;
		
		System.out.print(t + "초 후 위치 : ");
		System.out.printf("%.2fm\n", 1000-x);		
//		if(1000-x < 0) {
//			break;
//		}
		}
		

		// 위의 for문과 같은 기능을 하는 while문		
//		int t = 0;
//		while(t <= seconds) {
//			double a = 9.81;
//			double x = 1000 - (double)1/2 * a * t * t;
//			
//			System.out.print(t + "초 후 위치 : ");
//			System.out.printf("%.2fm\n", x);
//			t++;
//			}
	}

}
