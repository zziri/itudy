package stream;

import java.util.Arrays;

public class IntArrayStreamTest {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		int sum = Arrays.stream(arr).filter(n->n>=3).sum();
		int cnt = (int)Arrays.stream(arr).count();
		
		System.out.println(sum);
		System.out.println(cnt);

		System.out.println(Arrays.stream(arr).reduce(0,(a,b)->a+b));
	}

}
