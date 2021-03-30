package _008자료구조;

import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		// <key,value> pair 형태의 리스트, Map에서 key를 이용하여 value를 찾음
		HashMap<String, Student> leaderMap = new HashMap<String, Student>();
		
		leaderMap.put("1반", new Student(104,"KIM"));
		leaderMap.put("2반", new Student(214,"LEE"));
		leaderMap.put("3반", new Student(306,"PARK"));
		leaderMap.put("4반", new Student(417,"Jo"));
		leaderMap.put("5반", new Student(509,"Jang"));
		
		if(leaderMap.containsKey("3반")) {
			Student leader3 = leaderMap.get("3반");
			System.out.printf("3반 반장은 %s(%d번) 입니다.",leader3.getName(),leader3.getId());
		}
			

	}

}
