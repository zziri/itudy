package treeSetClass;

import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {

		TreeSet<String> treeSet = new TreeSet<String>();
		
		treeSet.add("Fred");
		treeSet.add("Amy");
		treeSet.add("Yohan");
		
		// ������������ ���ĵ� ���� �˼� ����.
		for(String str : treeSet)
		{
			System.out.println(str);
		}

	}

}
