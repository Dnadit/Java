package 자료구조123장;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

//Comparable 인터페이스를 사용하려면 compareTo() method를 구현
class Fruit implements Comparable<Fruit> {
	    private String name;
	    private int price;
	    public Fruit(String name, int price) {
	        this.name = name;
	        this.price = price;
	    }

	    @Override
	    public String toString() {
	        return "<" + name + ", " + price + ">";
	    }

		@Override //메소드를 오버라이드 하겠다는 의미, 해당 메소드가 없다면 컴파일오류 발생.
		public int compareTo(Fruit o) {
		//구현할 부분
			if (o.price < this.price) {
				return 1;				
			} else if (o.price > this.price) {
				return -1;
			}
			return 0;
		}
	public int getPrice() {
		return price;
	}
}

//===========================
public class Chap3_ObjectArraySort {
	public static void main(String[] args) {
//	String[] s = { "sort", "string", "array" };
//	Arrays.sort(s);
//	Arrays.sort(s, Comparator.naturalOrder());
//	Arrays.sort(s, Comparator.reverseOrder()); 
	
	/*
	Arrays.sort(s, new Comparator<String>() {
	    @Override
	    public int compare(String o1, String o2) {
	        return o2.compareTo(o1);            // 내림차순으로 정렬
	    }
	});
	*/
//	s = Arrays.stream(s).sorted().toArray(String[]::new);	
//	s = Arrays.stream(s).sorted(Collections.reverseOrder()).toArray(String[]::new);
//	Collections.sort(Arrays.asList(s));
	Fruit[] arr = {
	        new Fruit("사과", 200),
	        new Fruit("키위", 500),
	        new Fruit("오렌지", 200),
	        new Fruit("바나나", 50),
	        new Fruit("수박", 880),
	        new Fruit("체리", 10)
	};
	
  System.out.println(arr);
  System.out.println("정렬전::");
  for ( Fruit city: arr)
  	System.out.print(" " + city);
	Arrays.sort(arr, (a,b) -> a.getPrice() - b.getPrice()); //Fruit에 compareTo()가 있어도 람다식 우선 적용

//  int count = arr.length;
//  for (int i = 0; i < count; i++)
//  	for (int j = i +1; j < count; j++) {
//  		if (arr[i].compareTo(arr[j]) > 0)
//  		{
//  			Fruit temp; temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
//  		}
//  	}
  System.out.println();
  System.out.println("정렬후::");
  for ( Fruit city: arr)
  	System.out.print(" " + city);

	ArrayList<Fruit> lst1 = new ArrayList<Fruit>(Arrays.asList(arr));
	ArrayList<Fruit> lst2 = new ArrayList<Fruit>();
	lst2.add(new Fruit("복숭아", 200));
	lst2.add(new Fruit("포도", 300));
	lst2.add(new Fruit("참외", 100));
	lst2.add(new Fruit("딸기", 50));
	lst2.add(new Fruit("블루베리", 500));
	lst2.add(new Fruit("구지뽕", 300));
	System.out.println();
	System.out.println("리스트2::");
  for ( Fruit city: lst2)
  	System.out.print(" " + city);
//  Arrays.sort(lst2);
    Collections.sort(lst2);
	System.out.println();
	System.out.println("정렬된 리스트2::");
  for ( Fruit city: lst2)
  	System.out.print(" " + city);
  
  ArrayList<Fruit> lst3 = new ArrayList<Fruit>();
	
	Iterator<Fruit> iter1 = lst1.iterator();
	Iterator<Fruit> iter2 = lst2.iterator();
	Fruit data1 = iter1.next() ;
	Fruit data2 = iter2.next() ;
	System.out.println();	
  	//구현할 부분
	while (iter1.hasNext() && iter2.hasNext()) {
		if (data1.compareTo(data2) < 0) {	
			lst3.add(data1);
			data1 = iter1.next();			
		} else if(data1.compareTo(data2) > 0) {
			lst3.add(data2);
			data2 = iter2.next();
		} else {
			lst3.add(data1);
			data1 = iter1.next();
			data2 = iter2.next();
		}
	}
	if (data1.compareTo(data2) < 0) {
		lst3.add(data1);
		lst3.add(data2);
	} else {
		lst3.add(data2);
		lst3.add(data1);
	}
//	while (iter1.hasNext()) {
//		lst3.add(data1);
//		data1 = iter1.next();
//	}
//	while (iter2.hasNext()) {
//		lst3.add(data2);
//		data2 = iter2.next();
//	}	
	
	System.out.println();
  System.out.println("merge:: ");
  for ( Fruit city: lst3)
  	System.out.print(city+ " ");
  Fruit newFruit = new Fruit("참외", 100);
  //binary search
  Comparator<Fruit> cc = new Comparator<Fruit>() {//익명클래스 사용 
      public int compare(Fruit u1, Fruit u2) {
        return u1.compareTo(u2);
      }
    };
   int res = cc.compare(data1, newFruit);
   if (res > 0)
  	 System.out.println("\ndata1 > newFruit\n");
    /*
  System.out.println();
  int result = Collections.binarySearch(lst3, newFruit, cc);
		System.out.println("\nCollections.binarySearch() 조회결과::" + lst3.get(result));
	*/

	Fruit [] fa = new Fruit[lst3.size()];
	fa = lst3.toArray(fa);
  int result3 = Arrays.binarySearch(fa, newFruit, cc);
	System.out.println("\nArrays.binarySearch() 조회결과::" + lst3.get(result3));
	/*
	int result2 = binSearch(fa, lst3.size(), newFruit);
	System.out.println("\nbinSearch() 조회결과:" + lst3.get(result2));
	*/
	}
	// 교재 111 페이지 참조하여 구현
	static int binSearch(Fruit[]a, int n, Fruit f) {
	//구현할 부분
		int pl = 0;
		int pr = n-1;
		
		do {
			int pc = (pl + pr) /2 ;
			if (a[pc].compareTo(f) == 0)
				return pc ;
			else if (a[pc].compareTo(f) > 0)
				pr = pc - 1;
			else
				pl = pc + 1;
		} while (pl <= pr);
		return -1;
	}
}
