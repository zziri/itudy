package _008�ڷᱸ��;

import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		// <key,value> pair ������ ����Ʈ, Map���� key�� �̿��Ͽ� value�� ã��
		HashMap<String, Student> leaderMap = new HashMap<String, Student>();
		
		leaderMap.put("1��", new Student(104,"KIM"));
		leaderMap.put("2��", new Student(214,"LEE"));
		leaderMap.put("3��", new Student(306,"PARK"));
		leaderMap.put("4��", new Student(417,"Jo"));
		leaderMap.put("5��", new Student(509,"Jang"));
		
		if(leaderMap.containsKey("3��")) {
			Student leader3 = leaderMap.get("3��");
			System.out.printf("3�� ������ %s(%d��) �Դϴ�.",leader3.getName(),leader3.getId());
		}
			

	}

}
