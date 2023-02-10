package edu.mission;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BigNumSum {
	// 빈 ArrayList 생성
	private static ArrayList<ArrayList<Integer>> numArr = new ArrayList<>();

	// 유효성검사를 포함하여 txt파일을 입력받아 거꾸로 numArr에 담음.
	public static boolean readNumber() {
		String str;
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));) {

			for (int i = 0; i < 2; i++) {

				numArr.add(new ArrayList<Integer>());

				str = br.readLine();
				if (str == null)
					return false;
				System.out.println(str);

				String[] arr = str.split("");

				for (int j = arr.length - 1; 0 <= j; j--) {
					numArr.get(i).add(Integer.parseInt(arr[j])); // int 값으로 넣어줬음.
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		// System.out.println("numArr : " + numArr);
		return true;
	}

	public static void main(String[] args) {
		// 두 숫자 읽어서 배열로 입력 , 유효성 검사를 통해 error 메세지 출력.
		if (readNumber() == false) {
			System.out.println("Error");
			return;
		}

		// 자리수가 큰 배열을 0번째로 설정
		// system.out.println(numArr.get(0).size());
		int dif = numArr.get(0).size() - numArr.get(1).size();
		if (dif < 0) {
			ArrayList<Integer> tArr = numArr.get(0);
			numArr.set(0, numArr.get(1));
			numArr.set(1, tArr);
		}
		// 두 배열 더하기
		int olrim = 0;
		for (int i = 0; i < numArr.get(1).size(); i++) {
			int sum = numArr.get(0).get(i) + numArr.get(1).get(i) + olrim;
			numArr.get(0).set(i, sum % 10);
			if (10 <= sum)
				olrim = 1;
			else
				olrim = 0;
		}

		if (olrim == 1) {
			// if 코드 왜 들어갔는지 ? 자릿수가 같으면 올림된 1을 추가해준다.
			if (numArr.get(0).size() == numArr.get(1).size()) {
				numArr.get(0).add(1);
			}
			// else 코드 : 자릿수 다를 때 재연산
			else {
				for (int i = numArr.get(1).size(); i < numArr.get(0).size(); i++) {
					int sum = numArr.get(0).get(i) + olrim;
					numArr.get(0).set(i, sum % 10);
					if (10 <= sum)
						olrim = 1;
					else {
						olrim = 0;
						break;
					}
				}
				if (olrim == 1)
					numArr.get(0).add(1);				
			}
		}
		// 결과 출력하기
		for (int i = numArr.get(0).size() - 1; 0 <= i; i--) {
			System.out.print(numArr.get(0).get(i));
		}
		System.out.println("\nDone");
	}
}
