package treeSetClass;

import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {

		TreeSet<String> treeSet = new TreeSet<String>();
		
		treeSet.add("Fred");
		treeSet.add("Amy");
		treeSet.add("Yohan");
		
		// 오름차순으로 정렬된 것을 알수 있음.
		for(String str : treeSet)
		{
			System.out.println(str);
		}

	}

}
