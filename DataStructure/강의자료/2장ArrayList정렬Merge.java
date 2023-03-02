//1차 수업 - 2번째 코딩 실습
package Chap2_기본자료구조;


//10장 Collection, Test01, Test02를 사용

//string 정렬, binary search 구현
//1단계: string, 2단계: string 객체,  Person 객체들의 list\
//file1: 서울,북경,상해,서울,도쿄, 뉴욕,부산
//file2: 런던, 로마,방콕, 도쿄,서울,부산
// file > string split() > 배열 > ArrayList > sort > iterator 사용하여 merge > 중복 제거 > string 배열 > file에 저장

public class ArrarList정렬Merge {
	/*
	static int binSearch(String[] s, int n, String key) {
		//자료구조 책 페이지 115 코드 사용한다.
	}
	*/
	public static void main(String[] args) {
		try {
			Path input = Paths.get("a.txt");

			byte[] bytes = Files.readAllBytes(input);

			String[] sarray = new String[20];
			// file1에서 read하여 list1.add()한다.
			// 배열을 list로 만드는 방법
			// 방법1:
			ArrayList<String> arrayList = new ArrayList<>();
			for (String temp : sarray) {
				arrayList.add(temp);
			}
			// 방법2
			ArrayList<String> list1 = new ArrayList<>(Arrays.asList(sarray));

			ArrayList<String> list2 = new ArrayList<String>();
			// file2에서 read하여 list1.add()한다.

			//
			System.out.println("collection.sort()::");
			Collections.sort(list1);
			System.out.println("list1::");
			for (String city : list1)
				System.out.print(city + " ");
			System.out.println();
			System.out.println("list2::");
			Collections.sort(list2);
			for (String city : list2)
				System.out.print(city + " ");
			ArrayList<String> list3 = new ArrayList<String>();

			Iterator<String> iter1 = list1.iterator();
			Iterator<String> iter2 = list2.iterator();
			// iterator를 사용하여 merge한다
			String data1 = iter1.next();
			String data2 = iter2.next();
			
			//ArrayList를 merge하는 코드 구현 list3 = list1 + list2(merge)

			// binary search 구현
			// 방법1:
			Arrays.binarySearch(null, null, null);// ArrayList에는 binarySearch()가 없다.
			// 방법2:
			// int result = Collections.binarySearch(list3, newFruit, cc);

			// 방법3:

			System.out.println();
			System.out.println("merge:: ");
			for (String city : list3)
				System.out.print(city + " ");
			// ArrayList를 배열로 전환
			String[] st = list3.toArray(new String[list3.size()]);
			// binary search 구현
			// binSearch(st, st.length, "key");
			// 정렬된 list3을 file에 출력하는 코드 완성
			int bufferSize = 10240;
			String b = " ";
			ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
			for (String sx : list3) {
				System.out.println(" " + sx);
				buffer.put(sx.getBytes());
				buffer.put(b.getBytes());
			}
			buffer.flip();
			FileOutputStream file = new FileOutputStream("c.txt");
			FileChannel channel = file.getChannel();
			channel.write(buffer);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
