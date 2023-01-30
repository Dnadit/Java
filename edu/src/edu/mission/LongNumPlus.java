package edu.mission;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LongNumPlus {
	
	// file 읽어오기
	public static ArrayList<String> readNumbers() {
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));) {
			ArrayList<String> list = new ArrayList<String>();
			String str;
			while ((str = br.readLine()) != null) {
				System.out.printf("%30s\n", str);
				list.add(str);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Integer> reverseNumber(String str) {
		String [] sa = str.split(""); 
		ArrayList <Integer> ret = new ArrayList<>();
		for (int i = sa.length - 1; i <= 0 ; i--) {
			ret.add(Integer.parseInt(sa[i])); // parseInt 문자열을 숫자열로 변환. ret 배열에 거꾸로 정렬.
		}
		return ret;
	}

	public static void main(String[] args) {
		ArrayList<String> strArr = readNumbers();
		if (strArr == null) {
			System.out.println("Error");
			return;
		}
		// 배열 만들기(거꾸로)
		ArrayList<Integer> arr1 = reverseNumber(strArr.get(0));
		ArrayList<Integer> arr2 = reverseNumber(strArr.get(1));
				
		// 배열 더하기 ==> arr1이 arr2보다 개수가 많다고 가정. size 메서드 찾아보기.
		if (arr1.size() < arr2.size()) {
			ArrayList<Integer> temp = arr1;
			arr1 = arr2;
			arr2 = temp;
		}
		int add = 0 ;
		for (int i = 0; i < arr2.size(); i++) {
			int sum = arr1.get(i) + arr2.get(i) + add ;
			if (10 <= sum) add = 1 ;
			else add = 0;
			arr1.set(i, sum % 10) ;
		}
		
		
		// 출력하기
		String result = "";
		for (int i = arr1.size() - 1 ; 0 <= i ; i--) {
			result += arr1.get(i);
		}
		System.out.printf("%30s\n", result);
	}

}
