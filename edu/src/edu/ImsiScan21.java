package edu;

public class ImsiScan21 {
	
public static boolean prime(int num) {
	for(int i=2; i < num; i++) {
		if(num % i == 0) return false;
	}
	return true;
}
	
	public static void main(String[] args) {
		
		int num = Integer.parseInt(args[0]);
		if(prime(num) == 0) System.out.println("소수가 아닙니다.");
		System.out.println("소수 입니다.");
		System.out.println("Done");
	}
	

}