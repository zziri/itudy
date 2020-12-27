package hashMapClass;

import java.util.HashMap;
import java.util.Iterator;

public class MemberHashMap {
	private HashMap<Integer, Member> hashMap;
	
	public MemberHashMap()
	{
		hashMap = new HashMap<Integer, Member>();
	}
	
	public void addMember(Member member)
	{
		hashMap.put(member.getMemberId(), member);
	}
	
	public boolean removeMember(int memberId)
	{
		if(hashMap.containsKey(memberId)) {
			hashMap.remove(memberId);
			return false;
		}
		System.out.println("회원 번호가 없습니다.");
		return false;
	}
	
	public void showAllMember() {
		// HashMap의 keySet() 메서드는 모든 key객체를 Set형태로 반환
		Iterator ir = hashMap.keySet().iterator();
		
		while(ir.hasNext())
		{
			int key = (int)ir.next();
			Member member = hashMap.get(key);
			System.out.println(member);
		}
	}
	
	
}
