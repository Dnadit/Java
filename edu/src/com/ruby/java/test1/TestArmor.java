package com.ruby.java.test1;

public class TestArmor {
	static void test(int... v) {
		System.out.print(v.length + " : ");
		for(int x : v)
			System.out.print(x + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Armor a = new Armor(); // int n = 0; int [][]arr = new int[3][4];
		int n;
		n = a.takeoff(100); // Method 호출	
		System.out.println("n = " + n);	
		
		test(1);
		test(1,2);
		test(1,2,3,4,5,6,7);
	}

}
