package sort.ex3;

import java.util.*;

public class Solution {
	public static class Student{
		private String name;
		private int score;
		
		public String getName() {
			return name;
		}

		public int getScore() {
			return score;
		}

		public Student(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}
	
	public static void sol() {
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		
		List<Student> sList = new ArrayList<Student>();
		
		for(int i=0; i<cnt; i++)
		{
			String name = sc.next();
			int score = sc.nextInt();
			sList.add(new Student(name, score));
		}
		
		Collections.sort(sList, new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				return o1.getScore() - o2.getScore(); 
			}
			
		});
		
		for(Student s : sList)
			System.out.printf("%s ",s.getName());
	}

	public static void main(String[] args) {
		sol();

	}

}
