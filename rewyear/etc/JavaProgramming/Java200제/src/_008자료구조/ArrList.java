package _008자료구조;

import java.util.ArrayList;

public class ArrList {
	public static void main(String[] args)
	{
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		studentList.clear();
		studentList.add(new Student(100,"Kim"));
		studentList.add(new Student(101,"Lee"));
		studentList.add(new Student(102,"Park"));
		studentList.add(new Student(103,"Seo"));
		
		System.out.println(studentList.size());
		
		Student leader = studentList.get(1);
		System.out.printf("이 팀의 팀장은 %d번 %s입니다.",leader.getId(), leader.getName());
		
		
	}
}
