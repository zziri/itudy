package sortInterfaceEx;

import java.io.IOException;

public class SortTest {

	public static void main(String[] args) throws IOException {
		System.out.println("정렬 방식을 선택하세요.");
		System.out.println("B: BubbleSort");
		System.out.println("H: HeapSort");
		System.out.println("Q: QuickSort");
		
		Sort sort = null;
		
		int ch;
		ch = System.in.read();
		
		if(ch == 'B' || ch == 'b') {
			sort = new BubbleSort();
		}
		else if(ch == 'H' || ch == 'h') {
			sort = new HeapSort();
		}
		else if(ch == 'Q' || ch == 'q') {
			sort = new QuickSort();
		}
		else
		{
			System.out.println("잘못 선택하셨습니다.");
		}
		
		int[] testArr= {1,2,3,4,5};
		
		sort.ascending(testArr);
		sort.descending(testArr);
		sort.description();

	}

}
